package com.diabets.DiabetsTracker.model;

import jakarta.persistence.*;

import java.util.ArrayList;
import java.util.List;


@Entity
@Table(name = "meal")
public class Meal {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int mId;

    @Column(name = "m_name", nullable = false)
    private String mName;

    @Column(name = "m_description")
    private String mDescription;

    @Column(name = "m_calories", nullable = false)
    private int mCalories;

    @OneToMany(mappedBy = "user", cascade = CascadeType.REMOVE)
    private List<Meal> meal = new ArrayList<>();
    // Constructors


    public Meal() {
    }

    public Meal(int mId, String mName, String mDescription, int mCalories, List<Meal> meal) {
        this.mId = mId;
        this.mName = mName;
        this.mDescription = mDescription;
        this.mCalories = mCalories;
        this.meal = meal;
    }

    public int getmId() {
        return mId;
    }

    public void setmId(int mId) {
        this.mId = mId;
    }

    public String getmName() {
        return mName;
    }

    public void setmName(String mName) {
        this.mName = mName;
    }

    public String getmDescription() {
        return mDescription;
    }

    public void setmDescription(String mDescription) {
        this.mDescription = mDescription;
    }

    public int getmCalories() {
        return mCalories;
    }

    public void setmCalories(int mCalories) {
        this.mCalories = mCalories;
    }

    public List<Meal> getMeal() {
        return meal;
    }

    public void setMeal(List<Meal> meal) {
        this.meal = meal;
    }
}
