package com.Generator.Client;

import com.Generator.Client.service.CarInfo;
import com.Generator.Client.service.CarService;
import org.springframework.context.ApplicationContext;

import java.util.Vector;
public class Multithreading {
    public static Vector<CarInfo> v = new Vector<>();
    private final Vector<MyThread> the = new Vector<>();
    private final ApplicationContext ctx;

    public Multithreading(ApplicationContext ctx,int quantity) {
        for (int i = 0; i < quantity; ++i) {
            v.add(new CarInfo(i));
        }
        this.ctx = ctx;
    }
    public void run() {
        for (int i = 0; i < v.size(); ++i) {
            MyThread element;
            Runtime.getRuntime().addShutdownHook(element = new MyThread(i, ctx.getBean(CarService.class)));
            the.addElement(element);
            the.get(i).start();
        }
    }
}
class MyThread extends Thread {
    private final int index;
    CarService service;
    private final boolean isActive;
    public MyThread (int index, CarService service)
    {
        this.index = index;
        this.service = service;
        isActive = true;
    }
    @Override
    public void run()
    {
        while (isActive) {
            try {
                service.SendCarInfo(index);
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
    }
}