package com.Generator.Client.service;

import org.springframework.scheduling.annotation.Scheduled;

import java.util.Random;

public class CoordInfo {

    private float Clat;
    private float Clong;

    private String orientation;
    public CoordInfo() {
        this.Clat= (float) (55+random(70622, 79318)*Math.pow(10,-5));
        this.Clong=(float) (55+random(53204, 74628)*Math.pow(10,-5));
    }

    public Integer random(int min, int max){
        Random rnd = new Random();
        return rnd.nextInt(max - min) + min;
    }

    public void stepUp(double meter){
        this.Clat+=meter*0.000009;
        this.orientation="North";
    }

    public void stepDown(double meter){
        this.Clat-=meter*0.000009;
        this.orientation="South";
    }

    public void stepRight(double meter){
//        40075000/(360*60*60)=30.922
        this.Clong+=meter*278/(30.922*Math.cos(this.Clat))*Math.pow(10,-6);
        this.orientation="East";
    }
    public void stepLeft(double meter){
        this.Clong-=meter*278/(30.922*Math.cos(this.Clat))*Math.pow(10,-6);
        this.orientation="West";
    }



    public float getClat() {
        return Clat;
    }

    public void setClat(float Clat) {
        this.Clat = Clat;
    }

    public float getClong() {
        return Clong;
    }

    public void setClong(float Clong) {
        this.Clong = Clong;
    }

    public String getOrientation() {
        return orientation;
    }

    public void setOrientation(String orientation) {
        this.orientation = orientation;
    }


}
