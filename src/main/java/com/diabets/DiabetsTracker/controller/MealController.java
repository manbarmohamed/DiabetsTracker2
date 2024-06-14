package com.diabets.DiabetsTracker.controller;
import com.diabets.DiabetsTracker.Service.MealService;
import com.diabets.DiabetsTracker.Service.UserService;
import com.diabets.DiabetsTracker.model.Meal;
import com.diabets.DiabetsTracker.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;

import java.util.List;



@Controller
@RequestMapping(value = "api/meal")
public class MealController {

    @Autowired
    private MealService mealService;
    @Autowired
    private UserService userService;


    @RequestMapping("/homeMeal/{userId}")
    public String homeUser( @PathVariable Long userId, ModelMap model) {
        model.addAttribute("userId", userId);
        List<Meal> listMeals = mealService.getMeals(userId);
        model.addAttribute("listMeals", listMeals);
        return "/Meal/displayMeals";
    }

    @GetMapping("/new/{userId}")
    public String addNewMeal(@PathVariable Long userId, Model model){
        User user = userService.getUser(userId);
        model.addAttribute("userId", userId);
        model.addAttribute("user", user);
        model.addAttribute("meal", new Meal());
        return "/Meal/addMeal";
    }


    @PostMapping("/addMeal")
    public String addNewMeal(@ModelAttribute Meal meal) {
        mealService.addMeal(meal);
        return "redirect:/api/meal/homeMeal/" + meal.getUser().getUserId();
    }

}
