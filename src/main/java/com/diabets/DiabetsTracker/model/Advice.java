package com.diabets.DiabetsTracker.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;


@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Entity
@Table(name = "Advice")
public class Advice {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long adviceId;

    @Column(columnDefinition = "TEXT")
    private String adviceText;

    @Column(nullable = false)
    private Integer levelMin;

    @Column(nullable = false)
    private Integer levelMax;

    @OneToMany(mappedBy = "advice",fetch = FetchType.EAGER)
    private List<GlucoseReading> glucosesReading = new ArrayList<>();



}
