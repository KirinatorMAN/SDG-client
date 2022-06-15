package com.Generator.Client.service;

import org.springframework.scheduling.annotation.Async;
import org.springframework.scheduling.annotation.Scheduled;

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
        this.speed = (Float)((random(17)+1)*36f)/10f;
        this.coord = new CoordInfo();
    }

    public Integer random(int num){
        Random rnd = new Random();
        return rnd.nextInt(num);
    }

//    @Scheduled(fixedRate = 1000)
    public void Drive(){
        System.out.println("ChangeParam");
        int speedInt = (int) (this.speed*10);
        int a = this.random(100);
        if ((speedInt/36<=17)&&(speedInt/36>5)) {
            switch (speedInt) {
//          17 м/с
                case (612):
//          16 м/с
                case (576):
                    if (a < 55) {           // 55%-Без изменения скорости
                        move(speedInt / 36);
                    } else{    // 45%-Замедление
                        move(speedInt / 36 - 3);
                        this.speed = (float)(speedInt - 3 * 36)/10;
                    }
                    break;
                default:
                    if (a < 40) {           // 40%-Без изменения скорости
                        move(speedInt / 36);
                    } else if (a < 70) {    // 30%-Ускорение
//                        S=v0*t+(a*t^2)/2
                        move(speedInt / 36 + 2);
                        this.speed = (float)(speedInt + 2 * 36)/10;
                    } else {                   // 30%-Замедление
                        move(speedInt / 36 - 3);
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
                        move(speedInt / 36);
                    } else {                 // 45%-Ускорение
                        move(speedInt / 36 + 2);
                        this.speed = (float)(speedInt + 2 * 36)/10;
                    }
                    break;
                default:
                    if (a < 45) {           // 45%-Без изменения скорости
                        move(speedInt / 36);
                    } else if (a < 80) {    // 35%-Ускорение
                        move(speedInt / 36 + 2);
                        this.speed = (float)(speedInt + 2 * 36)/10;
                    } else {                  // 20%-Замедление
                        move(speedInt / 36 - 3);
                        this.speed = (float)(speedInt - 3 * 36)/10;
                    }
            }
        }
    }
    public void move(int meter){
        int speedInt = (int) (this.speed*10);
        if ((speedInt/36<=17)&&(speedInt/36>9)){
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
    public void moveForward(int meter){
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

    public void moveLeft(int meter){
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

    public void moveRight(int meter){
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

    public void firstStep(int meter){
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