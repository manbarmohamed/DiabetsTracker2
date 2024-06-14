package com.diabets.DiabetsTracker.services;

import com.diabets.DiabetsTracker.model.User;
import com.diabets.DiabetsTracker.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {

    @Autowired
    UserRepository userRepository;

    public User findById(Integer id) {
        return userRepository.findById(Long.valueOf(id)).orElse(null);
    }

    public User getUser(Long userid) {
        return userRepository.findById(userid).get();
    }

    public List<User> listAll() {
        return userRepository.findAll();
    }

    public User getuser(Long id) {
        return userRepository.findById(id).get();
    }


}
