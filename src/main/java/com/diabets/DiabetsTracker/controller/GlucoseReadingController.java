package com.diabets.DiabetsTracker.controller;


import com.diabets.DiabetsTracker.model.GlucoseReading;
import com.diabets.DiabetsTracker.services.GlucoseReadingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
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
    GlucoseReadingService glucoseReadingService;


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
}
