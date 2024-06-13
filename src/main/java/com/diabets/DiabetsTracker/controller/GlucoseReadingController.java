package com.diabets.DiabetsTracker.controller;


import com.diabets.DiabetsTracker.model.Advice;
import com.diabets.DiabetsTracker.model.GlucoseReading;
import com.diabets.DiabetsTracker.model.User;
import com.diabets.DiabetsTracker.services.AdviceService;
import com.diabets.DiabetsTracker.services.GlucoseReadingService;
import com.diabets.DiabetsTracker.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;

import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Arrays;

import java.util.List;


@Controller
@RequestMapping("/glucose-readings")
public class GlucoseReadingController {


    @Autowired
    private UserService userService;

    @Autowired
    private AdviceService adviceService;

    @Autowired
    private GlucoseReadingService glucoseReadingService;


    @GetMapping("/chart")
    public String chart(Model model) {
        model.addAttribute("readings", glucoseReadingService.getAllGlucoseReadings());
        return "chart";

    }

    @GetMapping("/chartDisplay")
    public String getGlucoseReadings(
            @RequestParam(value = "view", required = false, defaultValue = "week") String view,
            @RequestParam(value = "year", required = false) Integer year,
            @RequestParam(value = "month", required = false) Integer month,
            @RequestParam(value = "week", required = false) Integer week,
            Model model) {

        List<GlucoseReading> readings;

        switch (view) {
            case "month":
                readings = glucoseReadingService.getAllGroupedByMonth();
                break;
            case "year":
                readings = glucoseReadingService.getAllGroupedByYear();
                break;
            case "specificMonth":
                readings = glucoseReadingService.getByYearAndMonth(year, month);
                break;
            case "specificWeek":
                readings = glucoseReadingService.getByYearAndWeek(year, week);
                break;
            default:
                readings = glucoseReadingService.getAllGroupedByWeek();}

                List<String> labels = new ArrayList<>();
                List<Integer> data = new ArrayList<>();

                for (GlucoseReading reading : readings) {
                    labels.add(reading.getDateAndTime().toString());
                    data.add(reading.getLevel());
                }
//       labels = Arrays.asList("January", "February", "March", "April", "May");
//       data = Arrays.asList(10, 20, 30, 40, 50);
                model.addAttribute("labels", labels);
                model.addAttribute("data", data);
                return "index";
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

        Advice advice = adviceService.getAdviceByLevel(level);

        System.out.println(advice);
        GlucoseReading glucoseReading = GlucoseReading.builder()
                .dateAndTime(localDateTime)
                .level(level)
                .measurementType(measurementType)
                .user(user)
                .comment(comment)
                .advice(advice)
                .build();
        System.out.println(glucoseReading);
        glucoseReadingService.saveGlucoseReading(glucoseReading);
        System.out.println("oooooooooooooooooooooooooooooooooooooooooooooooo");
        return "redirect:/glucose-readings/all";
    }

    @GetMapping("/advice")
    public String showAdvice(@RequestParam Integer glucoseReadingsId, ModelMap model){
        model.put("advice",adviceService.getAdviceByGlucoseReading(glucoseReadingsId));
        return "advice";
    }

}
