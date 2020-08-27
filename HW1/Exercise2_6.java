// Lina Kang
// CS4A
// Homework 1 - Exercise 2.6
// Due date : 08/27/20

// Read a 3-digit integer and display a sum of the integers

import java.util.Scanner;

public class Exercise2_6 {
    public static void main (String[]args)
    {
        Scanner input = new Scanner(System.in);

        System.out.print("Enter a number between 0 and 1000: ");
        int num = input.nextInt();

        // extract individual digits
        int hundred = num / 100;
        num = num - (hundred*100);
        int ten = num / 10;
        num = num - (ten*10);
        int one = num;

        //calculate the sum
        num = hundred + ten + one;

        System.out.println("The sum of the digits is " + num);
    
    }
}