// Lina Kang
// CS4A
// Homework 1 - Exercise 1.13
// Due date : 08/27/20

// Solve given equations and display values for x and y
//  3.4x + 50.2y = 44.5
//  2.1x + 0.55y = 5.9

public class Exercise1_13 {
    public static void main (String[]args)
    {
        double a = 3.4;
        double b = 50.2;
        double c = 2.1;
        double d = 0.55;
        double e = 44.5;
        double f = 5.9;

        double x = (e * d - b * f)/(a * d - b * c);
        double y = (a * f - e * c)/(a * d - b * c);

        System.out.println("Given Equation: ");
        System.out.println("3.4x + 50.2y = 44.5");
        System.out.println("2.1x + 0.55y = 5.9");
        System.out.println();

        // System.out.println("X : " + String.format("%.2f", x));
        // System.out.println("Y : " + String.format("%.2f", y));

        System.out.println("'x' is equal to " + x);
        System.out.println("'y' is equal to " + y);
    }
}