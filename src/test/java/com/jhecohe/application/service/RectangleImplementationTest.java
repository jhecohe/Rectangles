package com.jhecohe.application.service;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

import org.junit.jupiter.api.Test;

import com.jhecohe.application.service.model.Rectangle;
import com.jhecohe.application.service.model.ResponseValidation;
import com.jhecohe.application.service.model.TypeEnum;
import com.jhecohe.application.service.model.interfaces.impl.AdjacencyImpl;

public class RectangleImplementationTest {

	@Test	
	void createRectangle() {
		Rectangle rectangle = new Rectangle(0, 0, 0, 0);
		assertNotNull(rectangle);
		assertEquals(0, rectangle.getX());
		assertEquals(0, rectangle.getY());
		assertEquals(0, rectangle.getWidth());
		assertEquals(0, rectangle.getHeight());
	}
	
	@Test
	void shapeIsAdjacency() {
		Rectangle rectangle1 = new Rectangle(0, 0, 0, 0);
		Rectangle rectangle2 = new Rectangle(0, 0, 0, 0);
		
		ResponseValidation adjacency = rectangle1.validateAdjacency(rectangle2, new AdjacencyImpl());
		
		assertEquals(TypeEnum.ADJACENT, adjacency.getRelationship());
	}
}
