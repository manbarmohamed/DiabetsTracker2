package com.diabets.DiabetsTracker.controller;
import com.diabets.DiabetsTracker.Service.PhysicalAtivityService;
import com.diabets.DiabetsTracker.Service.UserService;
import com.diabets.DiabetsTracker.model.PhysicalActivity;
import com.diabets.DiabetsTracker.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping(value = "api/phyisicalActivty")
public class PhysicalActivityController {


    @Autowired
    PhysicalAtivityService physicalAtivityService;

    @Autowired
    UserService userService;

    @RequestMapping("/homeActivity/{userId}")
    public String homeUser(@PathVariable Long userId, Model model) {
        model.addAttribute("userId", userId);
        List<PhysicalActivity> listActivities = physicalAtivityService.getPhysicalActivities(userId);
        model.addAttribute("listActivities", listActivities);
        return "/PhysicalActivity/displayPAct";
    }


    @GetMapping("/new2/{userId}")
    public String addNewMeal(@PathVariable Long userId, Model model) {
        User user = userService.getUser(userId);
        model.addAttribute("user", user);
        model.addAttribute("physicalActivities", new PhysicalActivity());
        return "/PhysicalActivity/addPAct";
    }



    @PostMapping("/addActivity")
    public String addNewActivity(@ModelAttribute PhysicalActivity physicalActivity) {
        physicalAtivityService.addPhysicalActivity(physicalActivity);
        return "redirect:/api/phyisicalActivty/homeActivity/" + physicalActivity.getUser().getUserId();
    }

}
