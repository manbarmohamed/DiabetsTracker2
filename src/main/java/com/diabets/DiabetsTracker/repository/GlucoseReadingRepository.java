package com.diabets.DiabetsTracker.repository;

import com.diabets.DiabetsTracker.model.GlucoseReading;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface GlucoseReadingRepository extends JpaRepository<GlucoseReading, Integer> {

    @Query(value = "SELECT * FROM glucose_reading ORDER BY YEAR(date_and_time), WEEK(date_and_time), date_and_time", nativeQuery = true)
    List<GlucoseReading> findAllGroupedByWeek();

    @Query(value = "SELECT * FROM glucose_reading ORDER BY YEAR(date_and_time), MONTH(date_and_time), date_and_time", nativeQuery = true)
    List<GlucoseReading> findAllGroupedByMonth();

    @Query(value = "SELECT * FROM glucose_reading ORDER BY YEAR(date_and_time), date_and_time", nativeQuery = true)
    List<GlucoseReading> findAllGroupedByYear();

    @Query(value = "SELECT * FROM glucose_reading WHERE YEAR(date_and_time) = ?1 AND WEEK(date_and_time) = ?2 ORDER BY date_and_time", nativeQuery = true)
    List<GlucoseReading> findByYearAndWeek(int year, int week);

    @Query(value = "SELECT * FROM glucose_reading WHERE YEAR(date_and_time) = ?1 AND MONTH(date_and_time) = ?2 ORDER BY date_and_time", nativeQuery = true)
    List<GlucoseReading> findByYearAndMonth(int year, int month);

    @Query(value = "SELECT * FROM glucose_reading ORDER BY date_and_time DESC LIMIT 1", nativeQuery = true)
    GlucoseReading findFirstByOrderByDateAndTimeDesc();
}
