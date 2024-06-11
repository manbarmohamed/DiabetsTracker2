package com.diabets.DiabetsTracker.model;


import jakarta.persistence.*;

@Entity
public class Meal {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long mealId;

    private String mealDescription;
    private double carbohydrates;

    @ManyToOne
    @JoinColumn(name = "userId")
    private User user;

    // Getters and setters
}
