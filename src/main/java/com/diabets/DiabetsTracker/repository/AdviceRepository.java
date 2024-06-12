package com.diabets.DiabetsTracker.repository;

import com.diabets.DiabetsTracker.model.Advice;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface AdviceRepository extends CrudRepository<Advice,Long> {

       @Query(value = "select a.* from Advice a inner join Glucose_Reading g on a.advice_id=g.advice_id where g.glucose_reading_id = :glucoseReadingId", nativeQuery = true)
       Advice findByGlucoseReading(@Param("glucoseReadingId") int glucoseReadingId);

}
