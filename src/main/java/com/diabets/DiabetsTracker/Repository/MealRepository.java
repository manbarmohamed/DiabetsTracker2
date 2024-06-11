package com.diabets.DiabetsTracker.Repository;


import com.diabets.DiabetsTracker.model.Meal;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MealRepository extends JpaRepository<Meal, Long> {

}