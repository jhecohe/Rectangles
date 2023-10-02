# Rectangle Application by Jherson Cohecha


## Description

This application allow validating the relationship between two rectangles, the possibles relations ship are intersecting, adjacent, or contained, The application can be used it from the terminal or as API restful


### Tools
* Spring boot
* Java 17
* lombok

## Deploy the app

1. clone the project https://github.com/jhecohe/Rectangles.git 
2. cd Rectangles
3. mvn clean install


## Use the application

To use the application we need to give the coordinates X and Y and the value for width and height

The application show us the next menu in console

![Console menu](./img/menuconsole.png)

* Select the case

* The application will ask the values for the two rectangles with the next format "x,y,w,h", x and y the coordinates, w to widht and h to height of the rectangle.

example:
	validation -> A
	rectangle1 -> "0,0,20,20"
	rectangle2 -> "-20,0,20,20"
	


	

