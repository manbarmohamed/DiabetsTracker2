package com.diabets.DiabetsTracker.services;

import com.diabets.DiabetsTracker.model.User;
import com.diabets.DiabetsTracker.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService {
    private final UserRepository userRepository;

    @Autowired
    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public User findById(Integer id) {
        return userRepository.findById(Long.valueOf(id)).orElse(null);
    }

    public User findByUsername(String username) {
        return userRepository.findUserByUserName(username);
    }
}
