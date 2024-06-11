package com.diabets.DiabetsTracker.model;

import jakarta.persistence.*;

import java.util.ArrayList;
import java.util.List;

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

    public void setAdviceId(Long adviceId) {
        this.adviceId = adviceId;
    }

    public Long getAdviceId() {
        return adviceId;
    }
    public String getAdviceText() {
        return adviceText;
    }

    public void setAdviceText(String adviceText) {
        this.adviceText = adviceText;
    }

    public Integer getLevelMin() {
        return levelMin;
    }

    public void setLevelMin(Integer levelMin) {
        this.levelMin = levelMin;
    }

    public Integer getLevelMax() {
        return levelMax;
    }

    public void setLevelMax(Integer levelMax) {
        this.levelMax = levelMax;
    }



}
