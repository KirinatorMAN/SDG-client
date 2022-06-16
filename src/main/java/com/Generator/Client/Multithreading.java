package com.Generator.Client;

import com.Generator.Client.service.CarInfo;
import com.Generator.Client.service.CarService;
import org.springframework.context.ApplicationContext;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;

import java.util.Vector;
@EnableScheduling
public class Multithreading {
    public static Vector<CarInfo> v = new Vector<>();
    private final ApplicationContext ctx;

    public Multithreading(ApplicationContext ctx) {
        for (int i = 0; i < 2; ++i) {
            v.add(new CarInfo(i));
        }
        this.ctx = ctx;
    }

    public void run() {
        Vector<MyThread> the = new Vector<>();
        for (int i = 0; i < v.size(); ++i) {
            the.addElement(new MyThread(i, ctx.getBean(CarService.class)));
            the.get(i).start();
        }
    }
}
class MyThread extends Thread {
    private final int index;
    CarService service;
    public MyThread (int index, CarService service)
    {
        this.index = index;
        this.service = service;
    }
    @Scheduled(fixedRate = 1000)
    public void startThread() throws InterruptedException {
        while (true){
            service.SendCarInfo(index);
            Thread.sleep(1000);
        }
    }
    @Override
    public void run()
    {
        try {
            startThread();
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }
}