// Lina Kang
// 1072568
// 09/05/2020
// HW2 3.27 - Checks whether a point is in a triangle

package HW2;

import java.util.Scanner;

public class Exercise_3_27 {
    public static void main(String[]args)
    {
        Scanner input = new Scanner(System.in);

        System.out.print("Enter a point's x- and y-coordinates: ");
        double x = input.nextDouble();
        double y = input.nextDouble();

        // if "x" is within [0,200], "y" should be on the hypotenuse if the triangle
        // or lower to be considered "inside the triangle"

        // y = mx + b
        // m = 100 - 0 / 0 - 200 = -1/2
        // y = -1/2x + 100

            // For example ...
            // if x = 100
            // y = -1/2(100) + 100
            // y = -50 + 100
            // y = 50

        double triangleY = (-0.5)*x + 100;

        if(x <= 200 && y <= triangleY && x >= 0 && y >= 0)
            System.out.println("The point is in the triangle");
        else
            System.out.println("The point is not in the triangle");
    }
}
