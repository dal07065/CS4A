// Lina Kang
// CS4A
// Homework 1 - Exercise 2.11
// Due date : 08/27/20

// (UPDATE of Exercise 1.11)
// Allow the user to enter the number of years and display population

import java.util.Scanner;

public class Exercise2_11 {
    public static void main (String[]args)
    {
        Scanner input = new Scanner(System.in);

        System.out.print("Enter the number of years: ");
        int years = input.nextInt();

        int population = 312_032_486;
        int days = 365;
        int yearInSeconds = days * 24 * 60 * 60;

        float births = yearInSeconds / 7;
        float deaths = yearInSeconds / 13;
        float immigrants = yearInSeconds / 45;

        population = population + (int)((births - deaths + immigrants) * years);
        
        System.out.println("The population in " + years + " years is " + population);
    }
}