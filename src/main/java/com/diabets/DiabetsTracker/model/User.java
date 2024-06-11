package com.diabets.DiabetsTracker.model;




import jakarta.persistence.*;

import java.util.List;
import java.util.Set;

@Entity
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long userId;

    private String userName;
    private int age;
    private String userPicture;

    @OneToMany(mappedBy = "user", cascade = CascadeType.ALL)
    private List<GlucoseReading> glucoseReadings;

    @OneToMany(mappedBy = "user", cascade = CascadeType.ALL)
    private List<PhysicalActivity> physicalActivities;

    @OneToMany(mappedBy = "user", cascade = CascadeType.ALL)
    private List<Meal> meals;

    @OneToMany(mappedBy = "user", cascade = CascadeType.ALL)
    private List<Advice> advices;

    // Getters and setters
}

