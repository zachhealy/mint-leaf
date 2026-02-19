package com.mintleaf.user;

import org.springframework.stereotype.Service;

@Service
public class UserService {
    private final UserRepository userRepository;

    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public Iterable<User> getUsers() {
        return this.userRepository.findAll();
    }

    public User addUser(User user) {
        return this.userRepository.save(user);
    }

    public User updateUser(User user) {
        if (user.getUserId() == null) {
            throw new IllegalArgumentException("User ID must not be null for update");
        }
        return this.userRepository.findById(user.getUserId())
                .map(existing -> this.userRepository.save(user))
                .orElseThrow(() -> new IllegalArgumentException(
                        String.format("User with id [%d] does not exist", user.getUserId())));
    }

    public void deleteUser(Long id) {
        User user = this.userRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException(String.format("User with id [%d] does not exist", id)));
        this.userRepository.delete(user);
    }
}
