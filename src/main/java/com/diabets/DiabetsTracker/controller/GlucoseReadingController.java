package com.diabets.DiabetsTracker.controller;

import com.diabets.DiabetsTracker.model.GlucoseReading;
import com.diabets.DiabetsTracker.services.GlucoseReadingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/glucose-readings")
public class GlucoseReadingController {

    private final GlucoseReadingService glucoseReadingService;

    @Autowired
    public GlucoseReadingController(GlucoseReadingService glucoseReadingService) {
        this.glucoseReadingService = glucoseReadingService;
    }

    @PostMapping
    public ResponseEntity<GlucoseReading> createGlucoseReading(@RequestBody GlucoseReading glucoseReading) {
        GlucoseReading savedGlucoseReading = glucoseReadingService.saveGlucoseReading(glucoseReading);
        return ResponseEntity.ok(savedGlucoseReading);
    }

    @GetMapping("/{id}")
    public ResponseEntity<GlucoseReading> getGlucoseReadingById(@PathVariable Integer id) {
        Optional<GlucoseReading> glucoseReading = glucoseReadingService.getGlucoseReadingById(id);
        return glucoseReading.map(ResponseEntity::ok)
                .orElseGet(() -> ResponseEntity.notFound().build());
    }

    @GetMapping
    public ResponseEntity<List<GlucoseReading>> getAllGlucoseReadings() {
        List<GlucoseReading> glucoseReadings = glucoseReadingService.getAllGlucoseReadings();
        return ResponseEntity.ok(glucoseReadings);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteGlucoseReading(@PathVariable Integer id) {
        glucoseReadingService.deleteGlucoseReadingById(id);
        return ResponseEntity.noContent().build();
    }

    @PutMapping("/{id}")
    public ResponseEntity<GlucoseReading> updateGlucoseReading(@PathVariable Integer id, @RequestBody GlucoseReading glucoseReading) {
        Optional<GlucoseReading> updatedGlucoseReading = glucoseReadingService.getGlucoseReadingById(id);
        if (updatedGlucoseReading.isPresent()) {
            GlucoseReading readingToUpdate = updatedGlucoseReading.get();
            readingToUpdate.setDateAndTime(glucoseReading.getDateAndTime());
            readingToUpdate.setLevel(glucoseReading.getLevel());
            readingToUpdate.setMeasurementType(glucoseReading.getMeasurementType());
            readingToUpdate.setUser(glucoseReading.getUser());
            readingToUpdate.setAdvice(glucoseReading.getAdvice());
            readingToUpdate.setComment(glucoseReading.getComment());
            GlucoseReading savedGlucoseReading = glucoseReadingService.saveGlucoseReading(readingToUpdate);
            return ResponseEntity.ok(savedGlucoseReading);
        } else {
            return ResponseEntity.notFound().build();
        }
    }
}
