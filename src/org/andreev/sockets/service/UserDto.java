package org.andreev.sockets.service;

import lombok.Builder;
import lombok.Value;
import org.andreev.sockets.entity.Gender;
import org.andreev.sockets.entity.Role;

import java.time.LocalDate;

@Value
@Builder
public class UserDto {
    Integer id;
    String email;
    String name;
    LocalDate birthday;
    Role role;
    Gender gender;
    String image;
}
