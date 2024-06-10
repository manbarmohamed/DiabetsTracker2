package com.diabets.DiabetsTracker.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("api/test/")
public class test {
    @GetMapping("/")
    public String show(){
        return "index";
    }
}
