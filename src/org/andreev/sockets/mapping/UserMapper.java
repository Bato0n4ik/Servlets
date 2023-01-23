package org.andreev.sockets.mapping;

import org.andreev.sockets.entity.Gender;
import org.andreev.sockets.entity.Role;
import org.andreev.sockets.entity.User;
import org.andreev.sockets.service.CreateUserDto;
import org.andreev.sockets.util.LocalDateFormatUtil;

import java.sql.Timestamp;

public class UserMapper implements Mapper<CreateUserDto, User>{
    private static final UserMapper INSTANCE = new UserMapper();
    private final String IMAGE_FOLDER = "users/";

    @Override
    public User mapping(CreateUserDto userDto) {
        return User.builder()
                .name(userDto.getName())
                .birthday(LocalDateFormatUtil.getLocalDate(userDto.getBirthday()))
                .email(userDto.getEmail())
                .password(userDto.getPassword())
                .role(Role.valueOf(userDto.getRole()))
                .gender(Gender.valueOf(userDto.getGender()))
                .image(IMAGE_FOLDER + userDto.getImage().getSubmittedFileName())
                .build();

    }

    private UserMapper(){}

    public static UserMapper getInstance(){
        return INSTANCE;
    }
}
