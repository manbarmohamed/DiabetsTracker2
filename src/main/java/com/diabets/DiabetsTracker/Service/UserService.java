package com.diabets.DiabetsTracker.Service;


import com.diabets.DiabetsTracker.Repository.UserRepository;

import com.diabets.DiabetsTracker.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class UserService {


    @Autowired
    private UserRepository userRepository;



    public User getUser(Long userid) {
        return userRepository.findById(userid).get();
    }

    public List<User> listAll() {
        return (List<User>) userRepository.findAll();
    }

    public User getuser(Long id) {
        return userRepository.findById(id).get();
    }


}
