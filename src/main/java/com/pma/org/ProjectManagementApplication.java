package com.pma.org;

import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;



import ch.qos.logback.classic.Logger;

@SpringBootApplication
public class ProjectManagementApplication  {
    
	public static void main(String[] args) {
		
		SpringApplication.run(ProjectManagementApplication.class, args);
		
	}
	

}
