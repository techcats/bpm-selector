package com.techcats.bpmselector;

import com.techcats.bpmselector.client.FitbitClient;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class BpmSelectorApplication {

	@Bean
	public FitbitClient getFitbitClient(){
		FitbitClient fitbitClient = new FitbitClient();
		return fitbitClient;
	}

	public static void main(String[] args) {
		SpringApplication.run(BpmSelectorApplication.class, args);
	}
}
