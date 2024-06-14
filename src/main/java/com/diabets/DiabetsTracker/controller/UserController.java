package com.diabets.DiabetsTracker.controller;


import com.diabets.DiabetsTracker.model.User;
import com.diabets.DiabetsTracker.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Controller
@RequestMapping(value = "api/user")
public class UserController {

    @Autowired
    private UserService userService;

    @RequestMapping("/")
    public String welcomehome(){
        return "homePage";
    }

    @RequestMapping("/homeU")
    public ModelAndView home(){
        List<User> listUsers = userService.listAll();
        ModelAndView mav = new ModelAndView("/User/displayUser");
        mav.addObject("listUsers", listUsers);
        return mav;
    }

}
