package com.example.retrofit2_examples.models;

public class UserRequest {

    String name;
    String job;

    public String getName() {
        return name;
    }

    public UserRequest(String name, String job) {
        this.name = name;
        this.job = job;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getJob() {
        return job;
    }

    public void setJob(String job) {
        this.job = job;
    }
}
