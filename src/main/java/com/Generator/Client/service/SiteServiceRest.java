package com.Generator.Client.service;

//import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpMethod;
//import org.springframework.retry.annotation.Backoff;
//import org.springframework.retry.annotation.Retryable;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;


import java.util.List;

@Service
public class SiteServiceRest implements SiteService {

    private final RestTemplate restTemplate;
    private final String serverUrl;

    public SiteServiceRest(
            RestTemplate restTemplate,
            @Value("${application.server.url}")
            String serverUrl
    ) {
        this.restTemplate = restTemplate;
        this.serverUrl = serverUrl;
    }

    @Override
    public void findAllBlockedSites1() {

//   Сделал просто для того что бы что то хоть было, в дальнейшем переедет в класс
        CarInfo newSiteInfo = new CarInfo(3);

//  Начало цикла в рамках одной машины
        CarInfo createdSite = restTemplate.postForObject(serverUrl + "/",
                newSiteInfo,
                CarInfo.class
        );
//  Конец цикла в рамках одной машины
    }
    @Override
    public List<CarInfo> findAllBlockedSites() {
        return restTemplate.exchange(
                serverUrl + "/",
                HttpMethod.GET,
                null,
                new ParameterizedTypeReference<List<CarInfo>>() {
                }
        ).getBody();
    }
}
