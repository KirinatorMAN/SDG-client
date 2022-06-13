package com.Generator.Client.service;

public class CarInfo {

    private long id;
    private int numbCar;
    private int speed;
    private CoordInfo coord;

    public CarInfo() {

    }

    public CarInfo(int numbCar, int speed, CoordInfo coord) {
        this.numbCar = numbCar;
        this.speed = speed;
        this.coord = coord;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public int getNumbCar() {
        return numbCar;
    }

    public void setNumbCar(int numbCar) {
        this.numbCar = numbCar;
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