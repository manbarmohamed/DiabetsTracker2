package com.diabets.DiabetsTracker.model;

import jakarta.persistence.*;
import lombok.*;
import org.springframework.format.annotation.DateTimeFormat;
import java.time.LocalDateTime;


@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Entity
@Table(name = "GlucoseReading")
public class GlucoseReading {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer glucoseReadingId;

    @Column(nullable = false)
    @DateTimeFormat(pattern = "dd-MM-yyyy HH:MM")
    private LocalDateTime dateAndTime;

    @Column(nullable = false)
    private Integer level;

    @Column(nullable = false, length = 50)
    private String measurementType;

    @ManyToOne
    @JoinColumn(name = "idUser", nullable = false)
    private User user;

    @ManyToOne
    @JoinColumn(name = "adviceId", nullable = false)
    private Advice advice;

    @Column(columnDefinition = "TEXT")
    private String comment;




}
