package com.diabets.DiabetsTracker.services;

import com.diabets.DiabetsTracker.model.Advice;
import com.diabets.DiabetsTracker.repository.AdviceRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Repository
public class AdviceService {
    @Autowired
    private AdviceRepository adviceRepository;

    @Transactional
    public Advice getAdviceByGlucoseReading(Integer glucoseReadingID) {
        return adviceRepository.findByGlucoseReading(glucoseReadingID);
    }

    @Transactional
    public Advice getAdviceByLevel(Integer level) {
        return adviceRepository.findByLevel(level);
    }
}
