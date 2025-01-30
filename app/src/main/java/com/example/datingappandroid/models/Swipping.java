package com.example.datingappandroid.models;

public class Swipping {
    private String profile_pic;
    private String name;
    private int age;
    private int distance;
    private int id;

    // Constructor
    public Swipping(String name, int age, String profile_pic, int distance) {
        this.name = name;
        this.age = age;
        this.profile_pic = profile_pic;
        this.distance = distance;
    }

    public String getProfile_pic() {
        return profile_pic;
    }

    public void setProfile_pic(String profile_pic) {
        this.profile_pic = profile_pic;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public int getDistance() {
        return distance;
    }

    public void setDistance(int distance) {
        this.distance = distance;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
}
