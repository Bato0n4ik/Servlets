package org.andreev.sockets.DAO;

import org.andreev.sockets.entity.User;
import org.andreev.sockets.util.ConnectionManager;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;
import java.util.Optional;

public class UserDAO implements Dao<Integer, User>{

    private static final UserDAO INSTANCE = new UserDAO();

    private final String SQL_INSERT ="INSERT INTO users (name, birthday, email, password, role, gender, image) VALUES (?,?,?,?,?,?,?)";

    private UserDAO(){

    }

    public static UserDAO getInstance(){
        return INSTANCE;
    }


    public User insert(User user){
        try(Connection connection = ConnectionManager.get()) {
            assert connection != null;
            try(PreparedStatement preparedStatement = connection.prepareStatement(SQL_INSERT)){

                preparedStatement.setObject(1, user.getName());
                preparedStatement.setObject(2, user.getBirthday());
                preparedStatement.setObject(3, user.getEmail());
                preparedStatement.setObject(4, user.getPassword());
                preparedStatement.setObject(5, user.getRole().name());
                preparedStatement.setObject(6, user.getGender().name());
                preparedStatement.setObject(7, user.getImage());

                preparedStatement.executeQuery();
                var result = preparedStatement.getGeneratedKeys();
                if(result.next()){
                    user.setId(result.getInt("id"));
                }
            }
        }
        catch(SQLException exc){
            exc.printStackTrace();
        }
        return user;
    }








    @Override
    public Optional<Integer> findById(User id) {
        return Optional.empty();
    }

    @Override
    public List<Integer> findAll() {
        return null;
    }

    @Override
    public void insert(Integer object) {

    }

    @Override
    public boolean delete(User id) {
        return false;
    }

    @Override
    public void update(Integer object) {

    }
}
