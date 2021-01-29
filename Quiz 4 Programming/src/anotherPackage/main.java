// Lina Kang
// 1072568
// CS4A 7:30 - 9:50 PM
// 10/22/2020

// This program will take in input of the necessary information for a shape,
// create three different objects (Circle, Square, Rectangle), and
// test out its functions such as calculating the area or perimeter

package anotherPackage;	// to simulate the usage of shape classes from a different package

import java.util.Scanner;

import shapes.*;	// separate package holding all shape classes (Circle, Square, Rectangle...)

public class main {

	public static void main(String[] args) {
		
		Scanner input = new Scanner(System.in);
		
		// INPUT
		
		System.out.println("Enter a SINGLE number. This will be used for the circle radius, the square's side, and one side of the rectangle:");
		double side1 = input.nextDouble();
		
		System.out.println("Enter the other side of the rectangle:");
		double side2 = input.nextDouble();
				
		// INITIALIZE OBJECTS
		
		Circle circ    = new Circle(side1);
		Square squa    = new Square(side1);
		Rectangle rect = new Rectangle(side1, side2);
		
		// OUTPUT
		
		System.out.println("\nCircle area: "  + circ.calcArea());
		System.out.println("Square area: "    + squa.calcArea());
		System.out.println("Rectangle area: " + rect.calcArea()+'\n');
		
		System.out.println("Circle area: "    + circ.calcPerim());
		System.out.println("Square area: "    + squa.calcPerim());
		System.out.println("Rectangle area: " + rect.calcPerim());
	}

}
