package com.diabets.DiabetsTracker.services;

import com.diabets.DiabetsTracker.model.GlucoseReading;
import com.diabets.DiabetsTracker.repository.GlucoseReadingRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
public class GlucoseReadingService {
    @Autowired
    GlucoseReadingRepository glucoseReadingRepository;



    public List<GlucoseReading> getGlucose(){
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

    public GlucoseReading getLatestReading() {
        return glucoseReadingRepository.findFirstByOrderByDateAndTimeDesc();
    }
}
