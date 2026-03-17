package com.mintleaf.user;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Data;

@Data
@JsonIgnoreProperties(ignoreUnknown = true)
public class UpdateUserRequest {
    private String username;
    private String email;
    private String password;

    public User toUser(Long userId) {
        User user = new User();
        user.setUserId(userId);
        user.setUsername(this.username);
        user.setEmail(this.email);
        user.setPassword(this.password);
        return user;
    }
}
