package com.diabets.DiabetsTracker.model;

import jakarta.persistence.*;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;


@Entity
@Table(name = "physical_activity")
public class PhysicalActivity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long pid;

    @Column(name = "activity_type", nullable = false)
    private String activityType;

    @Column(name = "duration_minutes", nullable = false)
    private int durationMinutes;

    @Column(name = "calories_burned", nullable = false)
    private int caloriesBurned;

    @Column(name = "activity_date", nullable = false)
    private LocalDateTime activityDate;

    @OneToMany(mappedBy = "user", cascade = CascadeType.REMOVE)
    private List<PhysicalActivity> physicalActivity = new ArrayList<>();
    // Constructors


    public PhysicalActivity() {
    }

    public PhysicalActivity(Long pid, String activityType, int durationMinutes, int caloriesBurned, LocalDateTime activityDate, List<PhysicalActivity> physicalActivity) {
        this.pid = pid;
        this.activityType = activityType;
        this.durationMinutes = durationMinutes;
        this.caloriesBurned = caloriesBurned;
        this.activityDate = activityDate;
        this.physicalActivity = physicalActivity;
    }

    public Long getPid() {
        return pid;
    }

    public void setPid(Long pid) {
        this.pid = pid;
    }

    public String getActivityType() {
        return activityType;
    }

    public void setActivityType(String activityType) {
        this.activityType = activityType;
    }

    public int getDurationMinutes() {
        return durationMinutes;
    }

    public void setDurationMinutes(int durationMinutes) {
        this.durationMinutes = durationMinutes;
    }

    public int getCaloriesBurned() {
        return caloriesBurned;
    }

    public void setCaloriesBurned(int caloriesBurned) {
        this.caloriesBurned = caloriesBurned;
    }

    public LocalDateTime getActivityDate() {
        return activityDate;
    }

    public void setActivityDate(LocalDateTime activityDate) {
        this.activityDate = activityDate;
    }

    public List<PhysicalActivity> getPhysicalActivity() {
        return physicalActivity;
    }

    public void setPhysicalActivity(List<PhysicalActivity> physicalActivity) {
        this.physicalActivity = physicalActivity;
    }
}

