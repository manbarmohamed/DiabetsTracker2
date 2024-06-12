package com.diabets.DiabetsTracker.controller;

import com.diabets.DiabetsTracker.model.GlucoseReading;
import com.diabets.DiabetsTracker.model.User;
import com.diabets.DiabetsTracker.services.GlucoseReadingService;
import com.diabets.DiabetsTracker.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.util.List;

@Controller
@RequestMapping("/glucose-readings")
public class GlucoseReadingController {

    private final GlucoseReadingService glucoseReadingService;
    private final UserService userService;

    @Autowired
    public GlucoseReadingController(GlucoseReadingService glucoseReadingService, UserService userService) {
        this.glucoseReadingService = glucoseReadingService;
        this.userService = userService;
    }

    @GetMapping("/all")
    public String getAllGlucoseReadings(Model model) {
        List<GlucoseReading> glucoseReadings = glucoseReadingService.getAllGlucoseReadings();
        model.addAttribute("glucoseReadings", glucoseReadings);
        return "glucose_readings";
    }

    @GetMapping("/add")
    public String addGlucoseReading(Model model) {
        model.addAttribute("glucoseReading", new GlucoseReading());
        return "add_glucose_reading";
    }

    @PostMapping("/save")
    public String saveGlucoseReading(@RequestParam("dateAndTime") String dateAndTime,
                                     @RequestParam("level") Integer level,
                                     @RequestParam("measurementType") String measurementType,
                                     @RequestParam("userId") Integer userId,
                                     @RequestParam("comment") String comment) {
        System.out.println(dateAndTime + level+ measurementType + userId + comment);
        LocalDateTime localDateTime = LocalDateTime.parse(dateAndTime);
        System.out.println(localDateTime);
        User user = userService.findById(userId);
        System.out.println(user);
        if (user == null) {
            return "redirect:/glucose-readings/add?error=userNotFound";
        }

        GlucoseReading glucoseReading = GlucoseReading.builder()
                .dateAndTime(localDateTime)
                .level(level)
                .measurementType(measurementType)
                .user(user)
                .comment(comment)
                .build();
        System.out.println(glucoseReading);
        glucoseReadingService.saveGlucoseReading(glucoseReading);
        System.out.println("oooooooooooooooooooooooooooooooooooooooooooooooo");
        return "redirect:/glucose-readings/all";
    }

}
