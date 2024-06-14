package com.diabets.DiabetsTracker.Repository;
import com.diabets.DiabetsTracker.model.Meal;
import com.diabets.DiabetsTracker.model.PhysicalActivity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;


public interface PhysicalActivityRepository extends JpaRepository<PhysicalActivity, Long> {
    List<PhysicalActivity> findByUser_UserId(long id);

}