package com.jhecohe.application.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.jhecohe.application.service.ValidateRectangleService;
import com.jhecohe.application.service.model.InputValidation;
import com.jhecohe.application.service.model.ResponseValidation;

import lombok.AllArgsConstructor;

@RestController
@RequestMapping("/api")
@AllArgsConstructor
public class ValidateRectanglesController {

	ValidateRectangleService vrs;
	
	@PostMapping("/intersection")
	ResponseEntity<ResponseValidation> validateIntersection(@RequestBody InputValidation iv){
		ResponseValidation rv = vrs.validateIntersection(iv);
		return new ResponseEntity<>(rv, HttpStatus.OK);
	}
	
	@PostMapping("/containment")
	ResponseEntity<ResponseValidation> validateContainment(@RequestBody InputValidation iv){
		ResponseValidation rv = vrs.validateContianment(iv);
		return new ResponseEntity<>(rv, HttpStatus.OK);
	}
	
	@PostMapping("/adjacency")
	ResponseEntity<ResponseValidation> validateAdjacency(@RequestBody InputValidation iv){
		ResponseValidation rv = vrs.validateAdjacency(iv);
		return new ResponseEntity<>(rv, HttpStatus.OK);
	}
}
