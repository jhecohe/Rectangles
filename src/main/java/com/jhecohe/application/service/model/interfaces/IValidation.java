package com.jhecohe.application.service.model.interfaces;

import com.jhecohe.application.service.model.Rectangle;
import com.jhecohe.application.service.model.ResponseValidation;

public interface IValidation {
	public ResponseValidation validateRectangle(Rectangle r1, Rectangle r2);
}
