package com.jhecohe.application.service.model.interfaces.impl;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import com.jhecohe.application.service.model.Rectangle;
import com.jhecohe.application.service.model.SubTypeEnum;
import com.jhecohe.application.service.model.TypeEnum;

public class ContainmentImplTest {

	
	private ContainmentImpl containment;
	
	@BeforeEach
	void intializeRectangles() {
		containment = new ContainmentImpl(); 
	}
	@Test
	void shouldContain() {
		
		Rectangle r1 = new Rectangle(1, 52, 6, 6);   //smaller
		Rectangle r2 = new Rectangle(0, 50, 10, 10);		
		
		assertTrue(containment.isContainment(r1, r2).isValidation());
		assertEquals(SubTypeEnum.NOT, containment.isContainment(r1, r2).getSubRelatioship());
		assertEquals(TypeEnum.CONTAINMENT, containment.isContainment(r1, r2).getRelationship());
	}
	
	@Test
	void shouldNotContainInterseccion() {
		
		Rectangle r1 = new Rectangle(-1, 52, 6, 6);   //smaller
		Rectangle r2 = new Rectangle(0, 50, 10, 10);		
		
		assertFalse(containment.isContainment(r1, r2).isValidation());
		assertEquals(SubTypeEnum.INTERSECTION, containment.isContainment(r1, r2).getSubRelatioship());
		assertEquals(TypeEnum.NO_CONTAINMENT, containment.isContainment(r1, r2).getRelationship());
	}
	
	@Test
	void shouldNotContain() {
		
		Rectangle r1 = new Rectangle(-10, 52, 6, 6);   //smaller
		Rectangle r2 = new Rectangle(0, 50, 10, 10);		
		
		assertFalse(containment.isContainment(r1, r2).isValidation());
		assertEquals(SubTypeEnum.NOT, containment.isContainment(r1, r2).getSubRelatioship());
		assertEquals(TypeEnum.NO_CONTAINMENT, containment.isContainment(r1, r2).getRelationship());
	}
	
	
}
