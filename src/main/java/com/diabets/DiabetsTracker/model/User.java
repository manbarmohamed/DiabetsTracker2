package com.diabets.DiabetsTracker.model;

import jakarta.persistence.*;
import lombok.*;

import java.util.ArrayList;
import java.util.List;


@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Entity
@Table(name = "User")
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long userId;

    @Column(nullable = false)
    private String userName;

    @Column(nullable = false)
    private Integer age;

    @Column(nullable = false)
    private String userPicture;

    @OneToMany(mappedBy = "user",fetch = FetchType.EAGER)
    private List<Meal> meals = new ArrayList<>();

    @OneToMany(mappedBy = "user",fetch = FetchType.EAGER)
    private List<PhysicalActivity> physicalActivitys = new ArrayList<>();

    @OneToMany(mappedBy = "user",fetch = FetchType.EAGER)
    private List<GlucoseReading> glucosesReading = new ArrayList<>();




}
