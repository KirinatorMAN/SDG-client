package com.Generator.Client.service;

import org.springframework.data.annotation.Id;
//import javax.persistence.GeneratedValue;

import java.util.ArrayList;
import java.util.List;

public class CarInfo {

    private int id;
    private int speed;
    private CoordInfo coord;

    private List lis = new ArrayList<>();


    public CarInfo() {

    }

    public CarInfo(int id, int speed, CoordInfo coord) {
        this.id = id;
        this.speed = speed;
        this.coord = coord;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getSpeed() {
        return speed;
    }

    public void setSpeed(int speed) {
        this.speed = speed;
    }

    public CoordInfo getCoord() {
        return coord;
    }

    public void setCoord(CoordInfo coord) {
        this.coord = coord;
    }

}