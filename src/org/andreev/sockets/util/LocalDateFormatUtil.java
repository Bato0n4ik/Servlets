package org.andreev.sockets.util;

import org.andreev.sockets.service.CreateUserDto;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.util.Arrays;
import java.util.Optional;

public class LocalDateFormatUtil {
    private static final DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");

    public static LocalDate getLocalDate(String date){
        return LocalDate.parse(date, formatter);
    }

    public static boolean isValid(String date){
        try{
            return Optional.ofNullable(date)
                    .map(t -> LocalDateFormatUtil.getLocalDate(t))
                    .isPresent();
        }
        catch(DateTimeParseException exc){
            return false;
        }
    }
}
