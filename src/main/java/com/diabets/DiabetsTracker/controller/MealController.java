package com.diabets.DiabetsTracker.controller;


import com.diabets.DiabetsTracker.Service.MealService;
import com.diabets.DiabetsTracker.model.Meal;
import org.apache.catalina.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@Transactional
public class MealController {

    @Autowired
    MealService mealService;

    @Autowired
    UserService userService;

    @RequestMapping("/homeUser/{userId}")
    public String homeUser(@PathVariable Long userId, Model model) {
        model.addAttribute("userId", userId);
        List<Meal> meals = mealService.getMeals();
        model.addAttribute("meals", meals);
        return "homeUser";
    }

    @GetMapping("/new1/{userId}")
    public String addNewMeal(@PathVariable Long userId, Model model) {
        User user = userService.getUser(userId);
        model.addAttribute("user", user);
        model.addAttribute("meals", new Meal());
        return "newMeal";
    }

    @PostMapping("/addMeal")
    public String addNewMeal(@ModelAttribute Meal meal) {
        mealService.addMeal(meal);
        return "redirect:/homeUser" + meal.getUser().getuserId();
    }
}
