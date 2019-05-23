package com.example.otherpatterns.convertor_pattern;

import java.util.function.Function;

public class UserConvertor extends Convertor<UserDTO, User> {

    static Function<UserDTO, User> fromDto = (from) -> new User(from.getName(), from.getUsername(), from.getPassword());
    static Function<User, UserDTO> fromEntity = (from) -> new UserDTO(from.getName(), from.getUsername(), from.getPassword());

    public UserConvertor() {
        super(fromDto, fromEntity);
    }

}
