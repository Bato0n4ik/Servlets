package org.andreev.sockets.validation;

import org.andreev.sockets.entity.Gender;
import org.andreev.sockets.entity.Role;
import org.andreev.sockets.service.CreateUserDto;
import org.andreev.sockets.util.LocalDateFormatUtil;

public class CreateUserValidator implements Validation<CreateUserDto>{

    private final static CreateUserValidator INSTANCE = new CreateUserValidator();

    @Override
    public ValidationResult isValid(CreateUserDto userDto) {
        ValidationResult validationResult = new ValidationResult();

        if(userDto.getGender() == null || Gender.find(userDto.getGender()).isEmpty()){
            validationResult.addError(Error.of("invalid.gender", "Error: Gender is invalid!\n"));
        }
        if(userDto.getRole()==null || Role.find(userDto.getRole()).isEmpty()){
            validationResult.addError(Error.of("invalid.role", "Error: Role is invalid!\n"));
        }
        if(userDto.getBirthday() == null || !LocalDateFormatUtil.isValid(userDto.getBirthday())){
            validationResult.addError(Error.of("invalid.birthday", "Error: Birthday date time is invalid!\n"));
        }
        if(userDto.getName() == null){
            validationResult.addError(Error.of("invalid.name", "Error: Name is invalid!\n"));
        }
        if(userDto.getEmail() == null || userDto.getPassword() == null){
            validationResult.addError(Error.of("invalid.email|password", "Error: Invalid Password Or Email !\n"));
        }

        return validationResult;
    }

    private CreateUserValidator(){}

    public static CreateUserValidator getInstance(){
        return INSTANCE;
    }
}
