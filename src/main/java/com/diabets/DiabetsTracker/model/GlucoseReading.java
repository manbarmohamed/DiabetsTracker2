package com.diabets.DiabetsTracker.model;



import jakarta.persistence.*;


import java.time.LocalDateTime;

@Entity
public class GlucoseReading {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long glucoseReadingId;

    private LocalDateTime dateAndTime;
    private double level;
    private String measurementType;
    private String comment;

    @ManyToOne
    @JoinColumn(name = "userId")
    private User user;

    // Getters and setters
}
