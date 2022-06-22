package com.Generator.Client.service;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.Random;

public class CoordInfo {

    private BigDecimal Clat;
    private BigDecimal Clong;

    private String orientation = "None";
    public CoordInfo() {
        this.Clat = BigDecimal.valueOf(55).add(BigDecimal.valueOf(random(706220, 793189)).divide(BigDecimal.valueOf(10).pow(6),6, RoundingMode.HALF_UP));
        this.Clong = BigDecimal.valueOf(55).add(BigDecimal.valueOf(random(532040, 746289)).divide(BigDecimal.valueOf(10).pow(6),6, RoundingMode.HALF_UP));
    }
    public Integer random(int min, int max){
        Random rnd = new Random();
        return rnd.nextInt(max - min) + min;
    }
    public void stepUp(float meter){
        this.Clat = this.Clat.add(BigDecimal.valueOf(meter).multiply(BigDecimal.valueOf(0.000009))).setScale(6,RoundingMode.HALF_UP);
        this.orientation="North";
    }
    public void stepDown(float meter){
        this.Clat = this.Clat.subtract(BigDecimal.valueOf(meter).multiply(BigDecimal.valueOf(0.000009))).setScale(6,RoundingMode.HALF_UP);
        this.orientation="South";
    }
    public void stepRight(float meter){
//      1/(40075000/360*cos(Clat))
        this.Clong = this.Clong.add(BigDecimal.valueOf(meter).multiply(BigDecimal.valueOf(1)).divide(BigDecimal.valueOf(40075000).divide(BigDecimal.valueOf(360), 8, RoundingMode.HALF_UP).multiply(BigDecimal.valueOf(Math.cos(this.Clat.doubleValue()))), 8, RoundingMode.HALF_UP)).setScale(6, RoundingMode.HALF_UP);
        this.orientation="East";
    }
    public void stepLeft(float meter){
        this.Clong = this.Clong.subtract(BigDecimal.valueOf(meter).multiply(BigDecimal.valueOf(1)).divide(BigDecimal.valueOf(40075000).divide(BigDecimal.valueOf(360), 8, RoundingMode.HALF_UP).multiply(BigDecimal.valueOf(Math.cos(this.Clat.doubleValue()))), 8, RoundingMode.HALF_UP)).setScale(6, RoundingMode.HALF_UP);
        this.orientation="West";
    }
    public BigDecimal getClat() {
        return Clat;
    }
    public void setClat(float Clat) {
        this.Clat = BigDecimal.valueOf(Clat);
    }
    public BigDecimal getClong() {
        return Clong;
    }
    public void setClong(float Clong) {
        this.Clong = BigDecimal.valueOf(Clong);
    }
    public String getOrientation() {
        return orientation;
    }
    public void setOrientation(String orientation) {
        this.orientation = orientation;
    }
}
