package com.Generator.Client.service;

//import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
//import org.springframework.retry.annotation.Backoff;
//import org.springframework.retry.annotation.Retryable;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;


import java.util.Collections;
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
        SiteInfo newSiteInfo = new SiteInfo(3L,"https://nnmclub.to/");


        SiteInfo createdSite = restTemplate.postForObject(serverUrl + "/",
                newSiteInfo,
                SiteInfo.class
        );
    }
    @Override
    public List<SiteInfo> findAllBlockedSites() {
        return restTemplate.exchange(
                serverUrl + "/",
                HttpMethod.GET,
                null,
                new ParameterizedTypeReference<List<SiteInfo>>() {
                }
        ).getBody();
    }
}
