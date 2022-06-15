package com.Generator.Client.service;

import org.springframework.scheduling.annotation.Scheduled;

import java.util.Random;

public class CarInfo {

    private long id;
    private int numbCar;
    private double speed;
    private CoordInfo coord;

    public CarInfo() {

    }

    public CarInfo(int numbCar) {
        this.numbCar = numbCar;
        this.speed = (random(17)+1)*3.6;
        this.coord = new CoordInfo();
    }

    public Integer random(int num){
        Random rnd = new Random();
        return rnd.nextInt(num);
    }

    @Scheduled(fixedRate = 1000)
    private void Drive(){
        int a = this.random(100);
        if ((this.speed/3.6>=17)&&(this.speed/3.6<5)) {
            switch (Double.toString(this.speed)) {
//          17 м/с
                case ("61.2"):
//          16 м/с
                case ("57.6"):
                    if (a < 55) {           // 55%-Без изменения скорости
                        move(this.speed / 3.6);
                    } else{    // 45%-Замедление
                        move(this.speed / 3.6 - 3);
                        this.speed -= 3*3.6;
                    }
                    break;
                default:
                    if (a < 40) {           // 40%-Без изменения скорости
                        move(this.speed / 3.6);
                    } else if (a < 70) {    // 30%-Ускорение
                        move(this.speed / 3.6 + 2);
                        this.speed += 2*3.6;
                    } else {                   // 30%-Замедление
                        move(this.speed / 3.6 - 3);
                        this.speed -= 3*3.6;
                    }
            }
        }else {
            switch (Double.toString(this.speed)) {
//          1 м/с
                case ("3.6"):
//          2 м/с
                case ("7.2"):
//          3 м/с
                case ("10.8"):
                    if (a < 55) {           // 55%-Без изменения скорости
                        move(this.speed / 3.6);
                    } else {                 // 45%-Ускорение
                        move(this.speed / 3.6 + 2);
                        this.speed += 2*3.6;
                    }
                    break;
                default:
                    if (a < 45) {           // 45%-Без изменения скорости
                        move(this.speed / 3.6);
                    } else if (a < 80) {    // 35%-Ускорение
                        move(this.speed / 3.6 + 2);
                        this.speed += 2*3.6;
                    } else {                  // 20%-Замедление
                        move(this.speed / 3.6 - 3);
                        this.speed -= 3*3.6;
                    }
            }
        }
    }
    public void move(double meter){
        if ((this.speed/3.6>=17)&&(this.speed/3.6<9)){
            moveForward(meter);
        }else{
            int b = this.random(100);
            if (b < 80)
                moveForward(meter);     // 80%-Движение прямо
            else if (b < 90)
                moveLeft(meter);        // 10%-Поворот влево
            else
                moveRight(meter);       // 10%-Поворот вправо
        }
    }
    public void moveForward(double meter){
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

    public void moveLeft(double meter){
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

    public void moveRight(double meter){
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

    public void firstStep(double meter){
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