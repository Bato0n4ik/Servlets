package org.andreev.sockets.DAO;

import lombok.SneakyThrows;
import org.andreev.sockets.entity.Gender;
import org.andreev.sockets.entity.Role;
import org.andreev.sockets.entity.User;
import org.andreev.sockets.util.ConnectionManager;

import java.sql.*;
import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

public class UserDAO implements Dao<Integer, User>{

    private static final UserDAO INSTANCE = new UserDAO();

    private final String SQL_INSERT ="INSERT INTO users (name, birthday, email, password, role, gender, image) VALUES (?,?,?,?,?,?,?)";
    private final String SQL_SELECT_BY_EMAIL_AND_PASSWORD = "SELECT * FROM users WHERE email = ? AND password = ?";
    private UserDAO(){

    }

    public static UserDAO getInstance(){
        return INSTANCE;
    }

    public Optional<User> findUserByEmailAndPassword(String email, String password){
        User user = null;
        try(Connection connection = ConnectionManager.get()){
            assert connection != null;
            PreparedStatement preparedStatement = connection.prepareStatement(SQL_SELECT_BY_EMAIL_AND_PASSWORD);
            preparedStatement.setObject(1, email);
            preparedStatement.setObject(2, password);

            ResultSet result = preparedStatement.executeQuery();
            if(result.next()){
                user = userBuilder(result);
            }
        }
        catch(SQLException exc){
            throw new RuntimeException(exc);
        }
        return Optional.ofNullable(user);
    }

    @SneakyThrows
    private User userBuilder(ResultSet result) {
        return User.builder()
                        .id(result.getObject("id", Integer.class))
                        .name(result.getObject("name", String.class))
                        .birthday(result.getObject("birthday", Date.class).toLocalDate())
                        .image(result.getObject("image", String.class))
                        .email(result.getObject("email", String.class))
                        .password(result.getObject("password", String.class))
                        .role(Role.find(result.getObject("role", String.class)).orElse(null))
                        .gender(Gender.find(result.getObject("gender", String.class)).orElse(null))
                        .build();
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
