package com.diabets.DiabetsTracker.model;

import jakarta.persistence.*;
import lombok.*;

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

    @ManyToOne
    @JoinColumn(name = "userId", nullable = false)
    private User user;


}
