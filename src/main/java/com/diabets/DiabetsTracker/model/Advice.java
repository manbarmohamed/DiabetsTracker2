package com.diabets.DiabetsTracker.model;

import jakarta.persistence.*;
import lombok.*;

import java.util.ArrayList;
import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
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

    @OneToMany(mappedBy = "advice", fetch = FetchType.EAGER)
    private List<GlucoseReading> glucoseReadings = new ArrayList<>();
}
