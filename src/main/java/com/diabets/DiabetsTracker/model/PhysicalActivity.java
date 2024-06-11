package com.diabets.DiabetsTracker.model;



import jakarta.persistence.*;


@Entity
public class PhysicalActivity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long activityId;

    private String activityDescription;
    private int duration;

    @ManyToOne
    @JoinColumn(name = "userId")
    private User user;

    // Getters and setters
}
