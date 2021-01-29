// Lina Kang
// 1072568
// 09/05/2020
// HW2 3.19 - Determine whether input values are valid to form a triangle

package HW2;

import java.util.Scanner;

public class Exercise_3_19 {
    public static void main(String[]args)
    {
        Scanner input = new Scanner(System.in);
        // Input - Read in 3 triangle edges
        System.out.print("Please enter first edge: ");
        double edge1 = input.nextDouble();

        System.out.print("Please enter second edge: ");
        double edge2 = input.nextDouble();

        System.out.print("Please enter third edge: ");
        double edge3 = input.nextDouble();

        System.out.println();

        if(edge1 > edge2 + edge3 || edge2 > edge1 + edge3 || edge3 > edge1 + edge2)
            System.out.println("The input is invalid.");
        else
            System.out.println("The input is valid.\nTriangle Perimeter: " + (edge1+edge2+edge3));   
    }
}
