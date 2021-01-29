// Lina Kang
// 1072568
// 09/05/2020
// HW2 5.31 - Calculate how much something is worth over time with annual percentage yield

package HW2;

import java.util.Scanner;

public class Exercise_5_31 {
    public static void main(String[]args)
    {
        // Input - Get deposit amount, annual percentage yield, and maturity period

        Scanner input = new Scanner(System.in);
        
        System.out.print("Enter the initial deposit amount: ");
        double amount = input.nextDouble();

        System.out.print("Enter annual percentage yield: ");
        double yield = input.nextDouble();

        System.out.print("Enter maturity period (number of months): ");
        int months = input.nextInt();

        // Output + Calculation
        System.out.println("\nMonth  CD Value");
        for(int i = 1; i <= months; i++)
        {
            amount += amount * yield / 1200.0;
            System.out.printf("%-6d %.2f\n", i, amount);
        }


    }
    
}
