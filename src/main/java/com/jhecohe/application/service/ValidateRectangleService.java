package com.jhecohe.application.service;

import org.springframework.stereotype.Service;

import com.jhecohe.application.interfaces.impl.ConsoleInputImpl;
import com.jhecohe.application.interfaces.impl.ConsoleOutputImpl;
import com.jhecohe.application.service.model.InputValidation;
import com.jhecohe.application.service.model.Rectangle;
import com.jhecohe.application.service.model.ResponseValidation;
import com.jhecohe.application.service.model.interfaces.impl.AdjacencyImpl;
import com.jhecohe.application.service.model.interfaces.impl.ContainmentImpl;

import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Service
@AllArgsConstructor
@Slf4j
public class ValidateRectangleService {

	ContainmentImpl containment;
	AdjacencyImpl adjacency;
	
	public ResponseValidation validateIntersection(InputValidation iv) {
		Rectangle rectangle = iv.getR1();
		ResponseValidation rv = rectangle.validateContaiment(iv.getR2(), containment);
		rv.setR1(iv.getR1());
		rv.setR2(iv.getR2());
		rv.setProcess(iv.getProcess());
		return rv;
	}
	
	public ResponseValidation validateContianment(InputValidation iv) {
		Rectangle rectangle = iv.getR1();
		ResponseValidation rv = rectangle.validateContaiment(iv.getR2(), containment);
		rv.setR1(iv.getR1());
		rv.setR2(iv.getR2());
		rv.setProcess(iv.getProcess());
		return rv;
	}
	
	public ResponseValidation validateAdjacency(InputValidation iv) {
		Rectangle rectangle = iv.getR1();
		ResponseValidation rv = rectangle.validateContaiment(iv.getR2(), adjacency);
		rv.setR1(iv.getR1());
		rv.setR2(iv.getR2());
		rv.setProcess(iv.getProcess());
		return rv;
	}
	
	public void validateByConsole() {
		
		ConsoleInputImpl console = new ConsoleInputImpl();
		InputValidation iv = console.readData();
		
		ResponseValidation rv = null;
		
		switch(iv.getProcess()) {
        case INTERSECTION:
        	rv = validateIntersection(iv);
        	break;
        case CONTAINMENT:
        	rv = validateContianment(iv);
        	break;
        case ADJACENCY:
        	rv = validateAdjacency(iv);
        	break;
        default :
        	log.error(iv.getProcess() + " It is not a opcion valid, please select one of these options I, C, A");
        }
		
		iv.getR1().show(rv, new ConsoleOutputImpl());
	}
}
