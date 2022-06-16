package com.Generator.Client.service;

import com.Generator.Client.Multithreading;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class CarServiceRest implements CarService {

    private final RestTemplate restTemplate;
    private final String serverUrl;

    public CarServiceRest(
            RestTemplate restTemplate,
            @Value("${application.server.url}")
            String serverUrl
    ) {
        this.restTemplate = restTemplate;
        this.serverUrl = serverUrl;
    }

    @Override
    public void SendCarInfo(int index) {
        System.out.println("StartSend");
        Multithreading.v.get(index).Drive();
        CarInfo createdCar = restTemplate.postForObject(serverUrl+index,
                Multithreading.v.get(index),
                CarInfo.class
        );
    }
}
