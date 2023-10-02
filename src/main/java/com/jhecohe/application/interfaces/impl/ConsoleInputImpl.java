package com.jhecohe.application.interfaces.impl;

import java.util.Scanner;

import org.springframework.stereotype.Component;

import com.jhecohe.application.interfaces.Input;
import com.jhecohe.application.service.model.InputValidation;
import com.jhecohe.application.service.model.Rectangle;
import com.jhecohe.application.service.model.ValidationTypeEnum;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Component
public class ConsoleInputImpl implements Input {

	@Override
	public InputValidation readData() {
		return getData();
	}

	private InputValidation getData() {

		Scanner scan = new Scanner(System.in);
		log.info("Please enter the following information ");

		String typeValidation = "Type of validation: please write the letter of the validation \n"
		+ "Intersection -> I \n"
		+ "Containment -> C \n"
		+ "Adjacency -> A ";

		String validation = readValue(typeValidation, "[iacIAC]", scan);

		String coordinates = "Coordinates of the first rectangle and the width and length with the following pattern \"X,Y,W,H\"";

		String firstRectangle = readValue(coordinates, "\"[0-9,-]+\"", scan);

		coordinates = "Coordinates of the second rectangle and the width and length with the following pattern \"X,Y,W,H\"";

		String secondRectangle = readValue(coordinates, "\"[0-9,-]+\"", scan);

		scan.close();
		
		return mapperRectangles(firstRectangle, secondRectangle, validation);
	}

	private InputValidation mapperRectangles(String firstRectangle, String secondRectangle, String validation) {

		try {
			String[] fr = firstRectangle.replaceAll("\"", "").split(",");
			String[] sr = secondRectangle.replaceAll("\"", "").split(",");
			Rectangle r1 = new Rectangle(Float.parseFloat(fr[0]), Float.parseFloat(fr[1]), Float.parseFloat(fr[2]),
					Float.parseFloat(fr[3]));
			Rectangle r2 = new Rectangle(Float.parseFloat(sr[0]), Float.parseFloat(sr[1]), Float.parseFloat(sr[2]),
					Float.parseFloat(sr[3]));

			ValidationTypeEnum val = null;

			switch (validation.toUpperCase()) {
			case "I":
				val = ValidationTypeEnum.INTERSECTION;
				break;
			case "C":
				val = ValidationTypeEnum.CONTAINMENT;
				break;
			case "A":
				val = ValidationTypeEnum.ADJACENCY;
				break;
			default:
				log.error(validation + " It is not a opcion valid, please select one of these options I, C, A");
			}
			return new InputValidation(r1, r2, val);
		} catch (NumberFormatException e) {
			log.error("The values sent don't match with the pattern {X,Y,W,H} all the values must be numbers");
		}

		return null;
	}
	
	private String readValue(String message, String pattern, Scanner scan) {
		
		log.info(message);
		String input = null;
	    while (input == null) {
	        input = scan.next();
	        if (!input.matches(pattern)) {
	            log.error("Please enter the values with the pattern"); 
	            input = null;
	        }
	    }
	    
	    return input;
	}
}
