package com.diabets.DiabetsTracker.repository;

import com.diabets.DiabetsTracker.model.GlucoseReading;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface GlucoseReadingRepository extends JpaRepository<GlucoseReading, Integer> {
}
