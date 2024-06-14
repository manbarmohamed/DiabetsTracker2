package com.diabets.DiabetsTracker.model;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "Meal")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Meal {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "meal_id")
    private Long mealId;

    @Column(name = "meal_name")
    private String mealName;

    @Column(name = "meal_description", columnDefinition = "TEXT")
    private String mealDescription;

    @Column(name = "carbohydrates", nullable = false)
    private Integer carbohydrates;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_id", nullable = false)
    private User user;

    @Override
    public String toString() {
        return "Meal{" +
                "mealId=" + mealId +
                ", mealName='" + mealName + '\'' +
                ", mealDescription='" + mealDescription + '\'' +
                ", carbohydrates=" + carbohydrates +
                ", user=" + user +
                '}';
    }
}
