package com.diabets.DiabetsTracker.model;

import jakarta.persistence.*;

import java.util.ArrayList;
import java.util.List;

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


    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public String getUserPicture() {
        return userPicture;
    }

    public void setUserPicture(String userPicture) {
        this.userPicture = userPicture;
    }

}
