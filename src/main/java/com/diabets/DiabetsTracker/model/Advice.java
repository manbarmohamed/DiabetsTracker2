package com.diabets.DiabetsTracker.model;


import jakarta.persistence.*;

@Entity
public class Advice {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long adviceId;

    private String adviceText;

    private Long maxLevel;
    private Long minLevel;
    @ManyToOne
    @JoinColumn(name = "userId")
    private User user;

}
