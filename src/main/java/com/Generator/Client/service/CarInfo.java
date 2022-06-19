package com.Generator.Client.service;

import java.util.Random;

public class CarInfo {

    private long id;
    private int numbCar;
    private float speed;
    private CoordInfo coord;

    public CarInfo() {

    }

    public CarInfo(int numbCar) {
        this.numbCar = numbCar;
        this.speed = (random(17)+1)*36f/10f;
        this.coord = new CoordInfo();
    }

    public Integer random(int num){
        Random rnd = new Random();
        return rnd.nextInt(num);
    }

    public void Drive(){
        System.out.println("ChangeParam");
        int speedInt = (int) (this.speed*10);
        int a = this.random(100);
        if ((speedInt/36<=17)&&(speedInt/36>6)) {
            switch (speedInt) {
//          17 м/с
                case (612):
//          16 м/с
                case (576):
                    if (a < 55) {           // 55%-Без изменения скорости
                        moveForward(speedInt / 36f);
                    } else{                 // 45%-Замедление
//                                          S=v0*t+(a*t^2)/2
                        moveForward(speedInt / 36f - 1.5f);
                        this.speed = (float)(speedInt - 3 * 36)/10;
                    }
                    break;
                default:
                    if (a < 40) {           // 40%-Без изменения скорости
                        move(speedInt / 36f);
                    } else if (a < 70) {    // 30%-Ускорение
                        moveForward(speedInt / 36f + 1);
                        this.speed = (float)(speedInt + 2 * 36)/10;
                    } else {                // 30%-Замедление
                        moveForward(speedInt / 36f - 1.5f);
                        this.speed = (float)(speedInt - 3 * 36)/10;
                    }
            }
        }else {
            switch (speedInt) {
//          1 м/с
                case (36):
//          2 м/с
                case (72):
//          3 м/с
                case (108):
                    if (a < 55) {           // 55%-Без изменения скорости
                        move(speedInt / 36f);
                    } else {                // 45%-Ускорение
                        moveForward(speedInt / 36f + 1);
                        this.speed = (float)(speedInt + 2 * 36)/10;
                    }
                    break;
                default:
                    if (a < 45) {           // 45%-Без изменения скорости
                        move(speedInt / 36f);
                    } else if (a < 80) {    // 35%-Ускорение
                        moveForward(speedInt / 36f + 1);
                        this.speed = (float)(speedInt + 2 * 36)/10;
                    } else {                // 20%-Замедление
                        moveForward(speedInt / 36f - 1.5f);
                        this.speed = (float)(speedInt - 3 * 36)/10;
                    }
            }
        }
    }
    public void move(float meter){
        int speedInt = (int) (this.speed*10);
        if ((speedInt/36<=17)&&(speedInt/36>9)||(speedInt/36<3))
            moveForward(meter);
        else {
            int b = this.random(100);
            if (b < 80)
                moveForward(meter);     // 80%-Движение прямо
            else if (b < 90)
                moveLeft(meter);        // 10%-Поворот влево
            else
                moveRight(meter);       // 10%-Поворот вправо
        }
    }
    public void moveForward(float meter){
        switch (this.coord.getOrientation()){
            case ("North"):
                this.coord.stepUp(meter);
                break;

            case ("South"):
                this.coord.stepDown(meter);
                break;

            case ("East"):
                this.coord.stepRight(meter);
                break;

            case ("West"):
                this.coord.stepLeft(meter);
                break;
            default:
                firstStep(meter);
        }
    }

    public void moveLeft(float meter){
        switch (this.coord.getOrientation()){
            case ("North"):
                this.coord.stepLeft(meter);
                break;

            case ("South"):
                this.coord.stepRight(meter);
                break;

            case ("East"):
                this.coord.stepUp(meter);
                break;

            case ("West"):
                this.coord.stepDown(meter);
                break;
            default:
                firstStep(meter);
        }
    }

    public void moveRight(float meter){
        switch (this.coord.getOrientation()){
            case ("North"):
                this.coord.stepRight(meter);
                break;

            case ("South"):
                this.coord.stepLeft(meter);
                break;

            case ("East"):
                this.coord.stepDown(meter);
                break;

            case ("West"):
                this.coord.stepUp(meter);
                break;
            default:
                firstStep(meter);
        }
    }

    public void firstStep(float meter){
        int c = this.random(100);
        if (c < 25)
            this.coord.stepUp(meter);
        else if (c < 50)
            this.coord.stepDown(meter);
        else if (c < 75)
            this.coord.stepRight(meter);
        else
            this.coord.stepLeft(meter);
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

    public double getSpeed() {
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