package org.andreev.sockets.service;

import org.andreev.sockets.DAO.TicketDao;
import org.andreev.sockets.entity.Ticket;

import java.util.List;
import java.util.stream.Collectors;

public class TicketService {
    private final static TicketService INSTANCE = new TicketService();
    private final static TicketDao ticketDao = TicketDao.getInstance();
    private TicketService(){}

    public static TicketService getInstance(){
        return INSTANCE;
    }

    public List<TicketDto> findAllByFlightId(Long id){
        return ticketDao.findAllByFlightId(id).stream().map(
                ticket -> new TicketDto(
                        ticket.getId(),
                        ticket.getFlightId(),
                        ticket.getSeatNo())
        ).collect(Collectors.toList());
    }
}


