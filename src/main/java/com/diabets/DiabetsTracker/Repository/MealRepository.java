package com.diabets.DiabetsTracker.repository;


import com.diabets.DiabetsTracker.model.Meal;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface MealRepository extends JpaRepository<Meal, Long> {


    List<Meal> findByUser_UserId(Long id);
}