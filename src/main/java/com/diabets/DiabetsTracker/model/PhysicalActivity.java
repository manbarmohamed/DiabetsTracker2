package com.diabets.DiabetsTracker.model;

import jakarta.persistence.*;

@Entity
@Table(name = "PhysicalActivity")
public class PhysicalActivity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long activityId;

    @Column(columnDefinition = "TEXT")
    private String activityDescription;

    @Column(nullable = false)
    private Integer duration;

    @ManyToOne
    @JoinColumn(name = "userId", nullable = false)
    private User user;

    public Long getActivityId() {
        return activityId;
    }

    public void setActivityId(Long activityId) {
        this.activityId = activityId;
    }

    public String getActivityDescription() {
        return activityDescription;
    }

    public void setActivityDescription(String activityDescription) {
        this.activityDescription = activityDescription;
    }

    public Integer getDuration() {
        return duration;
    }

    public void setDuration(Integer duration) {
        this.duration = duration;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }
}
