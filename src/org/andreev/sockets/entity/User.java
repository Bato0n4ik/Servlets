package org.andreev.sockets.entity;

import jakarta.servlet.http.Part;
import lombok.*;

import java.time.LocalDate;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class User {
    int id;
    String name;
    LocalDate birthday;
    String email;
    String password;
    Role role;
    Gender gender;
    String image;
}
