// Lina Kang
// CS4A
// Homework 1 - Exercise 2.19
// Due date : 08/27/20

// Allow user to enter three points of a triangle and display its area

import java.util.Scanner;

public class Exercise2_19 {
    public static void main (String[]args)
    {
        Scanner input = new Scanner(System.in);

        System.out.print("Enter three points for a triangle: ");
        double firstX = input.nextDouble();
        double firstY = input.nextDouble();
        double secondX = input.nextDouble();
        double secondY = input.nextDouble();
        double thirdX = input.nextDouble();
        double thirdY = input.nextDouble();

        // calculate side lengths with distance equation

        double side1 = Math.pow(Math.pow(firstX - secondX, 2) + Math.pow(firstY - secondY, 2), 0.5);
        double side2 = Math.pow(Math.pow(secondX - thirdX, 2) + Math.pow(secondY - thirdY, 2), 0.5);
        double side3 = Math.pow(Math.pow(thirdX - firstX, 2) + Math.pow(thirdY - firstY, 2), 0.5);

        // calculate triangle area

        double s = (side1 + side2 + side3)/2;
        float area = (float)(Math.pow(s*(s - side1)*(s - side2)*(s - side3),0.5));

        System.out.println("The area of the triangle is " + area);


    }
}