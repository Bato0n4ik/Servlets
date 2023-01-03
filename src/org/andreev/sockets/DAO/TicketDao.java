package org.andreev.sockets.DAO;

import org.andreev.sockets.entity.Ticket;
import org.andreev.sockets.util.ConnectionManager;

import java.math.BigDecimal;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class TicketDao implements Dao<Ticket, Long>{

    private static volatile TicketDao INSTANCE = new TicketDao();

    private static final String SQL_FIND_ALL_BY_ID = """
            SELECT * FROM ticket WHERE flight_id = ?
            """;

    private TicketDao(){}

    public static TicketDao getInstance(){
        synchronized (TicketDao.class){
            return INSTANCE;
        }
    }

    public List<Ticket> findAllByFlightId(long id) {

        try(var connection = ConnectionManager.get();
        var prepareStatement = connection.prepareStatement(SQL_FIND_ALL_BY_ID)){

            prepareStatement.setLong(1, id);
            var resultSet = prepareStatement.executeQuery();

            List<Ticket> ticketList = new ArrayList<>();
            while(resultSet.next()){
                ticketList.add(buildTicket(resultSet));
            }
            return ticketList;
        }
        catch(SQLException exc){
            throw new RuntimeException(exc);
        }

    }

    @Override
    public Optional<Ticket> findById(Long id) {
        return Optional.empty();
    }

    @Override
    public List<Ticket> findAll() {
        return null;
    }

    @Override
    public void insert(Ticket object) {

    }

    @Override
    public boolean delete(Long id) {
        return false;
    }

    @Override
    public void update(Ticket object) {

    }

    private static Ticket buildTicket(ResultSet resultSet) throws SQLException {
        return new Ticket(
                resultSet.getObject("id", Long.class),
                resultSet.getObject("passenger_no", String.class),
                resultSet.getObject("passenger_name", String.class),
                resultSet.getObject("flight_id", Long.class),
                resultSet.getObject("seat_no", String.class),
                resultSet.getObject("cost", BigDecimal.class)
        );
    }
}
