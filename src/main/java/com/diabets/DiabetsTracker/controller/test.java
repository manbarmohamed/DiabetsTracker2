package com.diabets.DiabetsTracker.controller;

import com.diabets.DiabetsTracker.services.AdviceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("api/test/")
public class test {
    @Autowired
    private AdviceService adviceService;

    @GetMapping("/")
    public String show(){
        return "index";
    }

    @GetMapping("/advice")
    public String showAdvice(ModelMap model){
        model.put("advice",adviceService.getAdviceByGlucoseReading(1));
        return "advice";
    }
}
