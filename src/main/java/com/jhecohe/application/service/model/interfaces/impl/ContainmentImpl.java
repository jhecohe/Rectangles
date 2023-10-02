package com.jhecohe.application.service.model.interfaces.impl;

import org.springframework.stereotype.Component;

import com.jhecohe.application.service.model.Rectangle;
import com.jhecohe.application.service.model.ResponseValidation;
import com.jhecohe.application.service.model.SubTypeEnum;
import com.jhecohe.application.service.model.TypeEnum;
import com.jhecohe.application.service.model.interfaces.IValidation;

@Component
public class ContainmentImpl implements IValidation {

	@Override
	public ResponseValidation validateRectangle(Rectangle r1, Rectangle r2) {
		return isContainment(r1, r2);
	}

	public ResponseValidation isContainment(Rectangle r1, Rectangle r2) {

		if (r1.getX() < r2.getX() || r1.getOppositeX() > r2.getOppositeX()) {
			if (r1.getX() > r2.getOppositeX() || r1.getOppositeX() < r2.getX())
				return new ResponseValidation(TypeEnum.NO_CONTAINMENT, SubTypeEnum.NOT, false);
			return new ResponseValidation(TypeEnum.NO_CONTAINMENT, SubTypeEnum.INTERSECTION, false);
		}
		if (r1.getY() < r2.getY() || r1.getOppositeY() > r2.getOppositeY()) {
			if (r1.getY() > r2.getOppositeY() || r1.getOppositeY() < r2.getY())
				return new ResponseValidation(TypeEnum.NO_CONTAINMENT, SubTypeEnum.NOT, false);
			return new ResponseValidation(TypeEnum.NO_CONTAINMENT, SubTypeEnum.INTERSECTION, false);
		}

		return new ResponseValidation(TypeEnum.CONTAINMENT, SubTypeEnum.NOT, true);
	}

}
