package org.andreev.sockets.service;

import jakarta.servlet.http.Part;
import lombok.Builder;
import lombok.Value;
import org.andreev.sockets.entity.Gender;
import org.andreev.sockets.entity.Role;

import java.time.LocalDate;

@Value
@Builder
public class CreateUserDto {
    String name;
    String birthday;
    String email;
    String password;
    String role;
    String gender;
    Part image;
}
