// Name       : Lina Kang
// Date       : 08/27/2020
// Student #  : 1072568
// Class      : CS4A TTH 7:30 - 9:50

// Quiz 1 Programming Exercise
// This program will receive input of three numbers (2 ints and 1 long),
// calculate the average, and display the result.
// (This program will also truncate the calculated result upto 2 decimal places)  

import java.util.Scanner;

public class AverageCalculator {
    public static void main(String[]args)
    {
        //Input - Get input from the user for 2 int and 1 long numbers
        // - Prompt the user for each number one at a time
        // - Read in the input and assort them into appropriate data types.
        Scanner input = new Scanner(System.in);

        System.out.print("Please enter the first number (an int): ");
        int firstNumber = input.nextInt();

        System.out.print("Please enter the second number (an int): ");
        int secondNumber = input.nextInt();
        
        System.out.print("Please enter the third number (a long): ");
        long thirdNumber = input.nextLong();

        //Calculation - Calculate the average of the three numbers
        // - Add all the numbers together
        // - Divide by the total amount of numbers added
        double average = (firstNumber + secondNumber + thirdNumber)/3.0;

        //Formatting - Decimal Places
        // - Multiply by 100 to "add" in the two decimal place numbers to use for later
        // - Convert to a whole number (long) to get rid of remaining decimal numbers
        // - Lastly, divide by 100 to reposition the decimal point to two decimal places
        long averageLong = (long)(average * 100);
        average = averageLong/100.0;

        //Output - Print the average result
        System.out.println();
        System.out.println("The average of " + firstNumber + 
        ", " + secondNumber + ", and " + thirdNumber + " is " + average);
        
    }

}