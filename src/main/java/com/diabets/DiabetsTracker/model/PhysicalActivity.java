package com.diabets.DiabetsTracker.model;

import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDateTime;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
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

    @Column(name = "burned_calories")
    private Integer burnedCalories;

    @ManyToOne
    @JoinColumn(name = "userId", nullable = false)
    private User user;

    @Override
    public String toString() {
        return "PhysicalActivity{" +
                "activityId=" + activityId +
                ", activityDescription='" + activityDescription + '\'' +
                ", duration=" + duration +
                ", user=" + user +
                '}';
    }
}
