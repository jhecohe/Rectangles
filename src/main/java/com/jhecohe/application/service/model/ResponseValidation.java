package com.jhecohe.application.service.model;

import lombok.AllArgsConstructor;
import lombok.Data;

@AllArgsConstructor
@Data
public class ResponseValidation {
	ValidationTypeEnum process; 
	TypeEnum relationship;
	SubTypeEnum subRelatioship;
	boolean validation;
	Rectangle r1;
	Rectangle r2;
	
	public ResponseValidation(TypeEnum relationship, SubTypeEnum subRelatioship, boolean validation) {
		super();
		this.relationship = relationship;
		this.subRelatioship = subRelatioship;
		this.validation = validation;
	}
}
