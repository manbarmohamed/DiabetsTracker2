package com.diabets.DiabetsTracker.model;

import jakarta.persistence.*;
import lombok.*;


@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Entity
@Table(name="Meal")
public class Meal {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long mealId;

    @Column(columnDefinition = "TEXT")
    private String mealDescription;

    @Column(nullable = false)
    private Integer carbohydrates;

    @ManyToOne
    @JoinColumn(name = "userId", nullable = false)
    private User user;


}
