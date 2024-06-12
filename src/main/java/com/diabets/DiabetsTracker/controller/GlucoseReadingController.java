package com.diabets.DiabetsTracker.controller;

import com.diabets.DiabetsTracker.model.GlucoseReading;
import com.diabets.DiabetsTracker.services.GlucoseReadingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
@RequestMapping("/glucose-readings")
public class GlucoseReadingController {

    private final GlucoseReadingService glucoseReadingService;

    @Autowired
    public GlucoseReadingController(GlucoseReadingService glucoseReadingService) {
        this.glucoseReadingService = glucoseReadingService;
    }

    @GetMapping("/all")
    public String getAllGlucoseReadings(Model model) {
        List<GlucoseReading> glucoseReadings = glucoseReadingService.getAllGlucoseReadings();
        model.addAttribute("glucoseReadings", glucoseReadings);
        return "glucose_readings";
    }
}
