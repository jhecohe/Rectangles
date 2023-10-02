package com.jhecohe.application.interfaces.impl;

import com.jhecohe.application.interfaces.IShow;
import com.jhecohe.application.service.model.ResponseValidation;
import com.jhecohe.application.service.model.ValidationTypeEnum;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class ConsoleOutputImpl implements IShow{
	
	@Override
	public void showShape(ResponseValidation rv) {

//		switch(rv.getRelationship()) {
//		case INTERSECTION:
//			title = "INTERSECTION";
//			break;
//		case NO_INTERSECTION:
//			title = "INTERSECTION";
//			break;
//		case CONTAINMENT:
//			title = "CONTAINMENT";
//			break;
//		case NO_CONTAINMENT:
//			title = "CONTAINMENT";
//			break;
//		case INTERSECTION_NO_CONTAINMENT:
//			title = "INTERSECTION";
//			break;
//		case ADJACENT:
//			title = "ADJACENT";
//			break;
//		case NO_ADJACENT:
//			title = "ADJACENT";
//			break;
//		default:
//			title = "No valid option";
//		}
		
		showResponse(rv);
	}
	
	private void showResponse(ResponseValidation rv) {
		if(rv.getProcess().equals(ValidationTypeEnum.INTERSECTION)) {
			log.info("It was validated the rectangle one -> " + rv.getR1().toString());
			log.info("with the rectangle two -------------> " + rv.getR2().toString());
			log.info("==> After validate if the two rectangles are " + rv.getProcess());
			log.info("==> and they are " + rv.getSubRelatioship());
		}else {
			log.info("It was validated the rectangle one -> " + rv.getR1().toString());
			log.info("with the rectangle two -------------> " + rv.getR2().toString());
			log.info("==> After validate if the two rectangles are " + rv.getProcess());
			log.info("==> the rectangles are " + rv.getRelationship());
			log.info("==> and they have a sub type " + rv.getSubRelatioship());
		}
	}

}
