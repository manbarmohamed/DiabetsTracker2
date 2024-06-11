package com.diabets.DiabetsTracker.services;

import com.diabets.DiabetsTracker.model.GlucoseReading;
import com.diabets.DiabetsTracker.repository.GlucoseReadingRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class GlucoseReadingService {

    private final GlucoseReadingRepository glucoseReadingRepository;

    @Autowired
    public GlucoseReadingService(GlucoseReadingRepository glucoseReadingRepository) {
        this.glucoseReadingRepository = glucoseReadingRepository;
    }

    public GlucoseReading saveGlucoseReading(GlucoseReading glucoseReading) {
        glucoseReadingRepository.save(glucoseReading);
        return glucoseReading;
    }

    public void deleteGlucoseReadingById(Integer id) {
        glucoseReadingRepository.deleteById(id);
    }

    public Optional<GlucoseReading> getGlucoseReadingById(Integer id) {
        return glucoseReadingRepository.findById(id);
    }

    public List<GlucoseReading> getAllGlucoseReadings() {
        return glucoseReadingRepository.findAll();
    }
}
