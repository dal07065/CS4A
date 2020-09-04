// Lina Kang  09/03/2020  1072568

// This program serves to calculate multiple mortgages regarding
// monthly payment and the interest amount.
// (I think I heard that documentation was not needed...? But just in case...)

import java.util.Scanner;

public class Quiz2 {
    public static void main(String[]args)
    {
        Scanner input = new Scanner(System.in);

        int    loanAmount     = 0;
        double annualInterest = 0;
        int    loanYears      = 0;

        double monthlyPayment = 0;
        double totalAmount    = 0;
        double totalInterest  = 0;

        // ---------------- INPUT -------------------

        // Input - Very first input that will control the loop
        System.out.print("Please enter a positive integer for the loan amount: ");
        loanAmount = input.nextInt();
        while(loanAmount < 0)
        {
            System.out.print("RETRY: Please enter a positive integer for the loan amount: ");
            loanAmount = input.nextInt();
        }

        // Multiple Mortgage Calculating Loop
        while(loanAmount != 0)
        {
            // Additional Input
            System.out.print("Please enter a positive number for the annual interest rate: ");
            annualInterest = input.nextDouble();
            while(annualInterest < 0)
            {
                System.out.print("RETRY: Please enter a positive number for the annual interest rate: ");
                annualInterest = input.nextDouble();
            }

            System.out.print("Please enter a positive integer for the term in years: ");
            loanYears = input.nextInt();
            while(loanYears < 0)
            {
                System.out.print("RETRY: Please enter a positive integer for the term in years: ");
                loanYears = input.nextInt();
            }

            System.out.println();

            System.out.println("For a loan with these characteristics:");
            System.out.printf("       $%8d\n", loanAmount);
            System.out.printf("       %4.2f annual interest rate\n", annualInterest);
            System.out.printf("       %d year term\n", loanYears);

            //----------------- CALCULATION -------------------

            // Calculation - Monthly Payment

            double monthlyInterest = (annualInterest / 12) / 100;
            double loanMonths = loanYears * 12;
            double onePlusCpowN = Math.pow(monthlyInterest + 1, loanMonths);

            monthlyPayment = loanAmount * (monthlyInterest * onePlusCpowN);
            monthlyPayment /= onePlusCpowN - 1;

            // Calculation - Total Amount Paid

            totalAmount = monthlyPayment * loanMonths;

            // Calculation - Total Interest Paid

            totalInterest = totalAmount - loanAmount;
            
            //------------------- OUTPUT ----------------------

            // Output - monthly payment, total amount paid, and total interest paid

            System.out.println();
            System.out.printf("The Monthly Payment = $%8.2f\n", monthlyPayment);
            System.out.printf("The Total Amount Paid = $%8.2f\n", totalAmount);
            System.out.printf("The Total Interest Paid = $%8.2f\n", totalInterest);

            System.out.println("\n");

            //------------------- INPUT ----------------------

            // Input - if user wishes to continue looping or wishes to stop
            System.out.print("Please enter a positive integer for the loan amount: ");
            loanAmount = input.nextInt();
            while(loanAmount < 0)
            {
                System.out.print("RETRY: Please enter a positive integer for the loan amount: ");
                loanAmount = input.nextInt();
            }

        }
        System.out.print("THANK YOU FOR USING THE MORTGAGE CALCULATOR!!");

    }
}