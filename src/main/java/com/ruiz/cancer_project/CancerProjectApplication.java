package com.ruiz.cancer_project;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class CancerProjectApplication {

	private static final Logger log = LoggerFactory.getLogger(CancerProjectApplication.class);

	public static void main(String[] args) {
		SpringApplication.run(CancerProjectApplication.class, args);
		log.info("App is runing!!!!");
	}

}
