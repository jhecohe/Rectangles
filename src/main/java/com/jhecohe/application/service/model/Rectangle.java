package com.jhecohe.application.service.model;

import org.springframework.stereotype.Component;

import com.jhecohe.application.interfaces.IShow;
import com.jhecohe.application.service.model.interfaces.IValidation;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@EqualsAndHashCode(callSuper=false)
@Component
public class Rectangle extends Shape{
	
	float x, y, width, height;
	
	public Rectangle(float x, float y, float width, float height) {
		this.x = x;
		this.y = y;
		this.width = width;
		this.height = height;
		super.shapeName = "Rectangle";
	}
	
	public ResponseValidation validateContaiment(Rectangle other, IValidation containment)
	{
		return containment.validateRectangle(this, other);
	}
	
	public ResponseValidation validateAdjacency(Rectangle other, IValidation adjacency)
	{
		return adjacency.validateRectangle(this, other);
	}
	
	
	public void show(ResponseValidation rv, IShow show) {
		show.showShape(rv);
	}
	
	public float getOppositeX() {
		return this.x + this.width;
	}
	
	public float getOppositeY() {
		return this.y + this.height;
	}

	@Override
	public String toString() {
		return "Rectangle [x=" + x + ", y=" + y + ", width=" + width + ", height=" + height + "]";
	}
}
