package org.andreev.sockets.service;

import lombok.SneakyThrows;
import org.andreev.sockets.DAO.UserDAO;
import org.andreev.sockets.entity.User;
import org.andreev.sockets.exceptions.ValidationException;
import org.andreev.sockets.mapping.UserMapper;
import org.andreev.sockets.validation.CreateUserValidator;
import org.andreev.sockets.validation.ValidationResult;

import java.sql.SQLException;

public class UserService {
    private static final UserService INSTANCE = new UserService();
    private final UserDAO userDao = UserDAO.getInstance();
    private final UserMapper userMapper = UserMapper.getInstance();
    private final CreateUserValidator userValidator = CreateUserValidator.getInstance();
    private final ImageService imageService = ImageService.getInstance();

    @SneakyThrows
    public Integer getUserDao(CreateUserDto userDto){
        ValidationResult validationResult = userValidator.isValid(userDto);
        if(!validationResult.isValid()){
            throw new ValidationException(validationResult.getErrors());
        }
        User user = userMapper.mapping(userDto);
        imageService.upload(user.getImage(), userDto.getImage().getInputStream());
        userDao.insert(user);

        return user.getId();
    }

    private UserService(){
    }

    public static UserService getInstance(){
        return INSTANCE;
    }
}
