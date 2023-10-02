package com.jhecohe.application.service.model;

import lombok.AllArgsConstructor;
import lombok.Data;

@AllArgsConstructor
@Data
public class InputValidation {
	Rectangle r1;
	Rectangle r2;
	ValidationTypeEnum process; 
}
