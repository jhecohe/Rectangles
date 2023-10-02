package com.jhecohe.application.service.model.interfaces.impl;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import com.jhecohe.application.service.model.Rectangle;
import com.jhecohe.application.service.model.SubTypeEnum;
import com.jhecohe.application.service.model.TypeEnum;

class AdjacencyImplTest {

	private AdjacencyImpl adjacency;
	
	@BeforeEach
	void intializeRectangles() {
		adjacency = new AdjacencyImpl(); 
	}
	
	@Test
	void shouldBeNotLeftAdjacency() {
		Rectangle r1 = new Rectangle(0, 0, 2, 2);
		Rectangle r2 = new Rectangle(-3, -3, 2, 2);
		
		assertEquals(false, adjacency.validateRectangle(r1, r2).isValidation());
		assertEquals(TypeEnum.NO_ADJACENT, adjacency.validateRectangle(r1, r2).getRelationship());
		assertEquals(SubTypeEnum.NOT, adjacency.validateRectangle(r1, r2).getSubRelatioship());
	}
	
	@Test
	void shouldBeLeftAdjacency() {
		Rectangle r1 = new Rectangle(0, 0, 20, 20);
		Rectangle r2 = new Rectangle(-20, 0, 20, 20);
		
		assertEquals(true, adjacency.validateRectangle(r1, r2).isValidation());
		assertEquals(TypeEnum.ADJACENT, adjacency.validateRectangle(r1, r2).getRelationship());
		assertEquals(SubTypeEnum.PROPER, adjacency.validateRectangle(r1, r2).getSubRelatioship());
		
		Rectangle r3 = new Rectangle(0, 0, 20, 20);
		Rectangle r4 = new Rectangle(-20, 3, 20, 10);
		
		
		assertEquals(true, adjacency.validateRectangle(r3, r4).isValidation());
		assertEquals(TypeEnum.ADJACENT, adjacency.validateRectangle(r3, r4).getRelationship());
		assertEquals(SubTypeEnum.SUB_LINE, adjacency.validateRectangle(r3, r4).getSubRelatioship());
		
		Rectangle r5 = new Rectangle(0, 0, 20, 20);
		Rectangle r6 = new Rectangle(-20, 18, 20, 10);
		
		assertEquals(true, adjacency.validateRectangle(r5, r6).isValidation());
		assertEquals(TypeEnum.ADJACENT, adjacency.validateRectangle(r5, r6).getRelationship());
		assertEquals(SubTypeEnum.PARTIAL, adjacency.validateRectangle(r5, r6).getSubRelatioship());
	}
	
	@Test
	void shouldBeNotRightAdjacency() {
		Rectangle r1 = new Rectangle(21, 20, 20, 20);
		Rectangle r2 = new Rectangle(0, 0, 20, 20);
		
		assertEquals(false, adjacency.isRightAdjacency(r1, r2).isValidation());
		assertEquals(TypeEnum.NO_ADJACENT, adjacency.validateRectangle(r1, r2).getRelationship());
		assertEquals(SubTypeEnum.NOT, adjacency.validateRectangle(r1, r2).getSubRelatioship());
	}
	
	@Test
	void shouldBeRightAdjacency() {
		Rectangle r1 = new Rectangle(0, 0, 20, 20);
		Rectangle r2 = new Rectangle(20, 0, 20, 20);
		
		assertEquals(true, adjacency.isRightAdjacency(r1, r2).isValidation());
		assertEquals(TypeEnum.ADJACENT, adjacency.validateRectangle(r1, r2).getRelationship());
		assertEquals(SubTypeEnum.PROPER, adjacency.validateRectangle(r1, r2).getSubRelatioship());
		
		Rectangle r3 = new Rectangle(0, 0, 20, 20);
		Rectangle r4 = new Rectangle(20, 3, 20, 10);
		
		assertEquals(true, adjacency.isRightAdjacency(r3, r4).isValidation());
		assertEquals(TypeEnum.ADJACENT, adjacency.validateRectangle(r3, r4).getRelationship());
		assertEquals(SubTypeEnum.SUB_LINE, adjacency.validateRectangle(r3, r4).getSubRelatioship());
		
		Rectangle r5 = new Rectangle(0, 0, 20, 20);
		Rectangle r6 = new Rectangle(20, 18, 20, 10);
		
		assertEquals(true, adjacency.isRightAdjacency(r5, r6).isValidation());
		assertEquals(TypeEnum.ADJACENT, adjacency.validateRectangle(r5, r6).getRelationship());
		assertEquals(SubTypeEnum.PARTIAL, adjacency.validateRectangle(r5, r6).getSubRelatioship());
	}
	
	@Test
	void shouldBeNotTopAdjacency() {
		Rectangle r1 = new Rectangle(21, 0, 20, 20);
		Rectangle r2 = new Rectangle(0, 0, 20, 20);
		
		assertEquals(false, adjacency.isTopAdjacency(r1, r2).isValidation());
		assertEquals(TypeEnum.NO_ADJACENT, adjacency.validateRectangle(r1, r2).getRelationship());
		assertEquals(SubTypeEnum.NOT, adjacency.validateRectangle(r1, r2).getSubRelatioship());
	}
	
	@Test
	void shouldBeTopAdjacency() {
		Rectangle r1 = new Rectangle(0, 0, 20, 20);
		Rectangle r2 = new Rectangle(0, -20, 20, 20);
		
		assertEquals(true, adjacency.isTopAdjacency(r1, r2).isValidation());
		assertEquals(TypeEnum.ADJACENT, adjacency.validateRectangle(r1, r2).getRelationship());
		assertEquals(SubTypeEnum.PROPER, adjacency.validateRectangle(r1, r2).getSubRelatioship());

		Rectangle r3 = new Rectangle(8, 0, 8, 20);
		Rectangle r4 = new Rectangle(0, -20, 20, 20);
		//s1.getX(), s2.getX(), s1.getOppositeX(), s2.getOppositeX()
		assertEquals(true, adjacency.isTopAdjacency(r3, r4).isValidation());
		assertEquals(TypeEnum.ADJACENT, adjacency.validateRectangle(r3, r4).getRelationship());
		assertEquals(SubTypeEnum.SUB_LINE, adjacency.validateRectangle(r3, r4).getSubRelatioship());
		
		Rectangle r5 = new Rectangle(18, 0, 8, 20);
		Rectangle r6 = new Rectangle(0, -20, 20, 20);
		
		assertEquals(true, adjacency.isTopAdjacency(r5, r6).isValidation());
		assertEquals(TypeEnum.ADJACENT, adjacency.validateRectangle(r5, r6).getRelationship());
		assertEquals(SubTypeEnum.PARTIAL, adjacency.validateRectangle(r5, r6).getSubRelatioship());
	}
	
	@Test
	void shouldBeNotBottomAdjacency() {
		Rectangle r1 = new Rectangle(21, 20, 20, 20);
		Rectangle r2 = new Rectangle(0, 0, 20, 20);
		
		assertEquals(false, adjacency.isBottomAdjacency(r1, r2).isValidation());
		assertEquals(TypeEnum.NO_ADJACENT, adjacency.validateRectangle(r1, r2).getRelationship());
		assertEquals(SubTypeEnum.NOT, adjacency.validateRectangle(r1, r2).getSubRelatioship());
	}
	
	@Test
	void shouldBeBottomAdjacency() {
		Rectangle r1 = new Rectangle(0, 0, 20, 20);
		Rectangle r2 = new Rectangle(0, 20, 20, 20);
//		s1.getY(), s2.getY(), s1.getOppositeY(), s2.getOppositeY()
		assertEquals(true, adjacency.isBottomAdjacency(r1, r2).isValidation());
		assertEquals(TypeEnum.ADJACENT, adjacency.validateRectangle(r1, r2).getRelationship());
		assertEquals(SubTypeEnum.PROPER, adjacency.validateRectangle(r1, r2).getSubRelatioship());

		Rectangle r3 = new Rectangle(0, 0, 20, 20);
		Rectangle r4 = new Rectangle(4, 20, 10, 20);

		assertEquals(true, adjacency.isBottomAdjacency(r3, r4).isValidation());
		assertEquals(TypeEnum.ADJACENT, adjacency.validateRectangle(r3, r4).getRelationship());
		assertEquals(SubTypeEnum.SUB_LINE, adjacency.validateRectangle(r3, r4).getSubRelatioship());
		
		Rectangle r5 = new Rectangle(0, 0, 20, 20);
		Rectangle r6 = new Rectangle(18, 20, 10, 20);
		
		assertEquals(true, adjacency.isBottomAdjacency(r5, r6).isValidation());
		assertEquals(TypeEnum.ADJACENT, adjacency.validateRectangle(r5, r6).getRelationship());
		assertEquals(SubTypeEnum.PARTIAL, adjacency.validateRectangle(r5, r6).getSubRelatioship());
	}
}
