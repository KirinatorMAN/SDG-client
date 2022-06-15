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

//@EnableRetry
//@EnableCaching
//@EnableHystrix
@SpringBootApplication
@EnableScheduling
public class ClientApplication {

	public static void main(String[] args) throws InterruptedException {

		ApplicationContext ctx = SpringApplication.run(ClientApplication.class, args);
		SiteService siteService = ctx.getBean(SiteService.class);

//		for (int i = 0; i < 3; ++i) {
//			System.out.println("Blocked urls:");
//			siteService.findAllBlockedSites();
//
//			Thread.sleep(5000);
//		}



		System.out.println("Car info add");
		siteService.findAllBlockedSites1();



//		for (int i = 0; i < 3; ++i) {
//			System.out.println("Cars:");
//			siteService.findAllBlockedSites().forEach(site -> System.out.println(site.getNumbCar()));
//
//			Thread.sleep(5000);
//		}

	}
}
