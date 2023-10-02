package com.jhecohe.application.service.model.interfaces.impl;

import com.jhecohe.application.service.model.SubTypeEnum;

import org.springframework.stereotype.Component;

import com.jhecohe.application.service.model.Rectangle;
import com.jhecohe.application.service.model.ResponseValidation;
import com.jhecohe.application.service.model.TypeEnum;
import com.jhecohe.application.service.model.interfaces.IValidation;

@Component
public class AdjacencyImpl implements IValidation {

	TypeEnum adjacency;
	SubTypeEnum subType;

	public AdjacencyImpl() {
		this.adjacency = TypeEnum.NO_ADJACENT;
		this.subType = SubTypeEnum.NOT;
	}

	@Override
	public ResponseValidation validateRectangle(Rectangle r1, Rectangle r2) {
		if (isLeftAdjacency(r1, r2).isValidation() || isRightAdjacency(r1, r2).isValidation()
				|| isTopAdjacency(r1, r2).isValidation() || isBottomAdjacency(r1, r2).isValidation())
			return new ResponseValidation(TypeEnum.ADJACENT, subType, true);
		return new ResponseValidation(TypeEnum.NO_ADJACENT, subType, false);
	}

	public ResponseValidation isLeftAdjacency(Rectangle s1, Rectangle s2) {
		boolean isAdjacency = s1.getX() == s2.getOppositeX() && s1.getY() <= s2.getOppositeY()
				&& s1.getOppositeY() >= s2.getY();

		if (isAdjacency) {
			validateTypeAdjacent(s1.getY(), s2.getY(), s1.getOppositeY(), s2.getOppositeY());
			return new ResponseValidation(TypeEnum.ADJACENT, subType, isAdjacency);
		}
		return new ResponseValidation(null, null, isAdjacency);
	}

	public ResponseValidation isRightAdjacency(Rectangle s1, Rectangle s2) {
		boolean isAdjacency = s1.getOppositeX() == s2.getX() && s1.getY() <= s2.getOppositeY()
				&& s1.getOppositeY() >= s2.getY();
		if (isAdjacency) {
			validateTypeAdjacent(s1.getY(), s2.getY(), s1.getOppositeY(), s2.getOppositeY());
			return new ResponseValidation(TypeEnum.ADJACENT, subType, isAdjacency);
		}
		return new ResponseValidation(null, null, isAdjacency);
	}

	public ResponseValidation isTopAdjacency(Rectangle s1, Rectangle s2) {
		boolean isAdjacency = s1.getY() == s2.getOppositeY() && s1.getX() <= s2.getOppositeX()
				&& s1.getOppositeX() >= s2.getX();
		if (isAdjacency) {
			validateTypeAdjacent(s2.getX(), s1.getX(), s2.getOppositeX(), s1.getOppositeX());
			return new ResponseValidation(TypeEnum.ADJACENT, subType, isAdjacency);
		}
		return new ResponseValidation(null, null, isAdjacency);
	}

	public ResponseValidation isBottomAdjacency(Rectangle s1, Rectangle s2) {
		boolean isAdjacency = s1.getOppositeY() == s2.getY() && s1.getX() <= s2.getOppositeX()
				&& s1.getOppositeX() >= s2.getX();
		if (isAdjacency) {
			validateTypeAdjacent(s1.getX(), s2.getX(), s1.getOppositeX(), s2.getOppositeX());
			return new ResponseValidation(TypeEnum.ADJACENT, subType, isAdjacency);
		}
		return new ResponseValidation(null, null, isAdjacency);
	}

	private void validateTypeAdjacent(float p1, float p2, float opposite1, float opposite2) {
		subType = SubTypeEnum.PARTIAL;
		if (p1 == p2 && opposite1 == opposite2) {
			subType = SubTypeEnum.PROPER;
		}
		if (p1 < p2 && opposite1 > opposite2) {
			subType = SubTypeEnum.SUB_LINE;
		}
	}
}
