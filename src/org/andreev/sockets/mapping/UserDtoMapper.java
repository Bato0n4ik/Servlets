package org.andreev.sockets.mapping;

import lombok.AccessLevel;
import lombok.NoArgsConstructor;
import org.andreev.sockets.entity.User;
import org.andreev.sockets.service.UserDto;

@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class UserDtoMapper implements Mapper<User, UserDto> {

    private static final UserDtoMapper INSTANCE = new UserDtoMapper();

    public static UserDtoMapper getInstance(){
        return INSTANCE;
    }
    @Override
    public  UserDto mapping(User object) {
        return UserDto.builder()
                .id(object.getId())
                .name(object.getName())
                .birthday(object.getBirthday())
                .image(object.getImage())
                .email(object.getEmail())
                .role(object.getRole())
                .gender(object.getGender())
                .build();
    }
}
