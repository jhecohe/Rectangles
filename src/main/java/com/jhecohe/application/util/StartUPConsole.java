package com.jhecohe.application.util;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import com.jhecohe.application.service.ValidateRectangleService;

import lombok.AllArgsConstructor;

@AllArgsConstructor
@Component
public class StartUPConsole implements CommandLineRunner {

	@Autowired
	ValidateRectangleService validateRectangle;

	@Override
	public void run(String... args) throws Exception {
		if (args.length == 0)
			validateRectangle.validateByConsole();
	}
}
