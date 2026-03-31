package com.mintleaf.user;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.StreamSupport;

import lombok.Data;

@Data
public class UserDto {
    private Long userId;
    private String username;
    private String email;

    public static UserDto from(User user) {
        if (user == null) {
            return null;
        }
        UserDto dto = new UserDto();
        dto.setUserId(user.getUserId());
        dto.setUsername(user.getUsername());
        dto.setEmail(user.getEmail());
        return dto;
    }

    public static List<UserDto> fromAll(Iterable<User> users) {
        if (users == null) {
            return List.of();
        }
        List<UserDto> list = new ArrayList<>();
        StreamSupport.stream(users.spliterator(), false)
                .map(UserDto::from)
                .forEach(list::add);
        return list;
    }
}
