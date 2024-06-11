package com.diabets.DiabetsTracker.Repository;
import com.diabets.DiabetsTracker.model.PhysicalActivity;
import org.springframework.data.jpa.repository.JpaRepository;


public interface PhysicalActivityRepository extends JpaRepository<PhysicalActivity, Long> {

}