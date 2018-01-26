package com.example.android.androidtutorial2;

import java.util.Date;

public class Test {
    private String name;
    private String topic;
    private String makerName;
    private Date date;
    private int maxDegree;
    private int minDegree;
    private String discription;

    public Test(String name, String topic, String makerName, Date date, int maxDegree, int minDegree) {
        this.name = name;
        this.topic = topic;
        this.makerName = makerName;
        this.date = date;
        this.maxDegree = maxDegree;
        this.minDegree = minDegree;
    }

    public String getDiscription() {
        return discription;
    }

    public void setDiscription(String discription) {
        this.discription = discription;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getTopic() {
        return topic;
    }

    public void setTopic(String topic) {
        this.topic = topic;
    }

    public String getMakerName() {
        return makerName;
    }

    public void setMakerName(String makerName) {
        this.makerName = makerName;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public int getMaxDegree() {
        return maxDegree;
    }

    public void setMaxDegree(int maxDegree) {
        this.maxDegree = maxDegree;
    }

    public int getMinDegree() {
        return minDegree;
    }

    public void setMinDegree(int minDegree) {
        this.minDegree = minDegree;
    }
}
