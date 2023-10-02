package com.jhecohe.application;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.WebApplicationType;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;

@SpringBootApplication
public class RectanglesApplication {
	
	public static void main(String[] args) {		
		
		if(args[0].equals("API")) {
			SpringApplication.run(RectanglesApplication.class, args);
		} else {
			new SpringApplicationBuilder(RectanglesApplication.class)
			  .web(WebApplicationType.NONE)
			  .run(args);
		}
	}

}
