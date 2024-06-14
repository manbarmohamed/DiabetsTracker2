package com.diabets.DiabetsTracker.Service;
import com.diabets.DiabetsTracker.Repository.MealRepository;
import com.diabets.DiabetsTracker.model.Meal;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class MealService {

    @Autowired
    private MealRepository mealRepo;

    public List<Meal> getMeals() {
        return mealRepo.findAll();
    }

    public List<Meal> getMeals(Long id) {
        return mealRepo.findByUser_UserId(id);
    }

    public void addMeal(Meal meal) {
        mealRepo.save(meal);
    }
}
