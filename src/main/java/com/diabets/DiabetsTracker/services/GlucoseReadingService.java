package com.diabets.DiabetsTracker.services;

import com.diabets.DiabetsTracker.model.GlucoseReading;
import com.diabets.DiabetsTracker.repository.GlucoseReadingRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

@Service
public class GlucoseReadingService {
    @Autowired
    GlucoseReadingRepository glucoseReadingRepository;


    public Optional<GlucoseReading> getGlucoseReadingById(Integer id) {
        return glucoseReadingRepository.findById(id);
    }

    public GlucoseReading saveGlucoseReading(GlucoseReading glucoseReading) {
        return glucoseReadingRepository.save(glucoseReading);
    }

    public List<GlucoseReading> getAllGlucoseReadings() {
        return glucoseReadingRepository.findAll();
    }
    public List<GlucoseReading> getAllGroupedByWeek() {
        return glucoseReadingRepository.findAllGroupedByWeek();
    }

    public List<GlucoseReading> getAllGroupedByMonth() {
        return glucoseReadingRepository.findAllGroupedByMonth();
    }

    public List<GlucoseReading> getAllGroupedByYear() {
        return glucoseReadingRepository.findAllGroupedByYear();
    }

    public List<GlucoseReading> getByYearAndWeek(int year, int week) {
        return glucoseReadingRepository.findByYearAndWeek(year, week);
    }

    public List<GlucoseReading> getByYearAndMonth(int year, int month) {
        return glucoseReadingRepository.findByYearAndMonth(year, month);
    }
    public void deleteGlucoseReadingById(Integer id) {
        glucoseReadingRepository.deleteById(id);
    }
}
