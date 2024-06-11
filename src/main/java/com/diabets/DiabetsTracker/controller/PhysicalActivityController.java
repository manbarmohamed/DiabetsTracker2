package com.diabets.DiabetsTracker.controller;

import com.diabets.DiabetsTracker.Service.MealService;
import com.diabets.DiabetsTracker.Service.PhysicalAtivityService;
import com.diabets.DiabetsTracker.model.Meal;
import com.diabets.DiabetsTracker.model.PhysicalActivity;
import org.apache.catalina.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@Transactional
public class PhysicalActivityController {


    @Autowired
    PhysicalAtivityService physicalAtivityService;

    @Autowired
    UserService userService;

    @RequestMapping("/homeUser/{userId}")
    public String homeUser(@PathVariable Long userId, Model model) {
        model.addAttribute("userId", userId);
        List<PhysicalActivity> physicalActivities = physicalAtivityService.getPhysicalActivities();
        model.addAttribute("physicalActivities", physicalActivities);
        return "homeUser";
    }

    @GetMapping("/new2/{userId}")
    public String addNewMeal(@PathVariable Long userId, Model model) {
        User user = userService.getUser(userId);
        model.addAttribute("user", user);
        model.addAttribute("physicalActivities",new PhysicalActivity());
        return "newActivity";
    }

    @PostMapping("/addActivity")
    public String addNewActivity(@ModelAttribute PhysicalActivity physicalActivity) {
        physicalAtivityService.addPhysicalActivity(physicalActivity);
        return "redirect:/homeUser" + physicalActivity.getUser().getuserId();
    }
}
