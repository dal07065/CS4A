// Lina Kang
// 1072568
// 09/05/2020
// HW2 3.23 - Checks whether a point is in a rectangle

package HW2;
import java.util.Scanner;
public class Exercise_3_23 {
    public static void main(String[]args)
    {
        Scanner input = new Scanner(System.in);

        System.out.print("Enter a point with two coordinates: ");
        int x = input.nextInt();
        int y = input.nextInt();

        if( x <= (10/2) && y <= (5.0/2))
            System.out.println("Point (" + (double)(x) + ", " + (double)(y) + ") is in the rectangle");
        else
        {
            System.out.println("Point (" + (double)(x) + ", " + (double)(y) + ") is not in the rectangle");
        }

    }
}
