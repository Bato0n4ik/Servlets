package org.andreev.sockets.service;

import org.andreev.sockets.DAO.FlightDao;

import java.util.List;
import java.util.stream.Collectors;

public class FlightService {
    private final static FlightDao flightDao = FlightDao.getInstance();

    private final static FlightService INSTANCE = new FlightService();

    public List<FlightDto> findAll(){
        return flightDao.findAll().stream().map(
                flight -> FlightDto.builder().id(flight.getId()).description(
                        """ 
                            %s - %s - %s
                        """.formatted(flight.getDepartureAirportCode(),
                                flight.getArrivalAirportCode(), flight.getStatus()))
                        .build()
        ).collect(Collectors.toList());
    }

    private FlightService(){

    }

    public static FlightService getInstance(){
        return INSTANCE;
    }
}
