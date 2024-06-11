package com.diabets.DiabetsTracker.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Entity
@Table(name = "physical_activity")
public class PhysicalActivity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long pid;


    private String activityType;


    private int durationMinutes;


    private int caloriesBurned;


    private LocalDateTime activityDate;

    @OneToMany(mappedBy = "user", cascade = CascadeType.REMOVE)
    private List<PhysicalActivity> physicalActivity = new ArrayList<>();
    // Constructors

}

