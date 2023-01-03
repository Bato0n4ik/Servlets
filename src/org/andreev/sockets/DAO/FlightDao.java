package org.andreev.sockets.DAO;

import org.andreev.sockets.entity.Flight;
import org.andreev.sockets.entity.FlightStatus;
import org.andreev.sockets.util.ConnectionManager;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class FlightDao implements Dao<Flight, Long>{

    private static volatile FlightDao INSTANCE = new FlightDao();

    private String SQL_FIND_ALL = """
            SELECT * FROM flight
            """;
    private FlightDao(){}

    public static FlightDao getInstance(){
        synchronized (FlightDao.class){
            return INSTANCE;
        }
    }

    @Override
    public Optional<Flight> findById(Long id) {
        return Optional.empty();
    }

    @Override
    public List<Flight> findAll() {
        List<Flight> flights = new ArrayList<>();
        try(Connection connection = ConnectionManager.get();
        var prepareStatement = connection.prepareStatement(SQL_FIND_ALL)){
            ResultSet result = prepareStatement.executeQuery();
            while(result.next()){
                flights.add(buildFlight(result));
            }

        }
        catch(SQLException exc){
            throw new RuntimeException(exc);
        }
        return flights;
    }

    @Override
    public void insert(Flight object) {

    }

    @Override
    public boolean delete(Long id) {
        return false;
    }

    @Override
    public void update(Flight object) {

    }

    private Flight buildFlight(ResultSet resultSet) throws SQLException {
        return new Flight(
                resultSet.getObject("id", Long.class),
                resultSet.getObject("flight_no", String.class),
                resultSet.getObject("departure_date", Timestamp.class).toLocalDateTime(),
                resultSet.getObject("departure_airport_code", String.class),
                resultSet.getObject("arrival_date", Timestamp.class).toLocalDateTime(),
                resultSet.getObject("arrival_airport_code", String.class),
                resultSet.getObject("aircraft_id", Integer.class),
                FlightStatus.valueOf(resultSet.getObject("status", String.class)));
    }
}
