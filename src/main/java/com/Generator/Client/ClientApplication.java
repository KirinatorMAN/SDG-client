package com.Generator.Client;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;
//import org.springframework.cloud.netflix.hystrix.EnableHystrix;
import org.springframework.context.ApplicationContext;
//import org.springframework.retry.annotation.EnableRetry;
import com.Generator.Client.service.SiteService;
import org.springframework.scheduling.annotation.EnableScheduling;

import java.util.TimerTask;

@SpringBootApplication
@EnableScheduling
public class ClientApplication {

	public static void main(String[] args) throws InterruptedException {

		ApplicationContext ctx = SpringApplication.run(ClientApplication.class, args);


			SiteService siteService = ctx.getBean(SiteService.class);

			System.out.println("Car info add");
			siteService.SendCarInfo();



//		for (int i = 0; i < 3; ++i) {
//			System.out.println("Cars:");
//			siteService.findAllBlockedSites().forEach(site -> System.out.println(site.getNumbCar()));
//
//			Thread.sleep(5000);
//		}

	}

}
