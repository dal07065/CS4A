// Lina Kang
// 1072568
// 09/12/2020
// Exercise 7.5 - Determines the distinct numbers from 10 given numbers

import java.util.Scanner;
public class Exercise_7_5{
    public static void main(String[]args)
    {
        Scanner input = new Scanner(System.in);

        int[] array = new int[10];
        
        // array to keep track of distinct numbers
        int[] arrayDistinct = {0, 0, 0, 0, 0, 0, 0, 0, 0, 0};
        int arrayDistinctSize = 0;

        // Input
        System.out.print("Enter ten numbers: " );   

        array[0] = input.nextInt();     //Add the first number to BOTH arrays first
        arrayDistinct[0] = array[0];
        arrayDistinctSize++;

        // Input + Check if it is already in arrayDistinct
        for(int i = 1; i < 10; i++)
        {
            array[i] = input.nextInt();

            for(int j = 0; j < 10; j++)
            {
                //if the number EXISTS
                if(arrayDistinct[j] == array[i])
                {
                    j = 10; //break for loop
                }
                //if the number is NEW
                else if(arrayDistinct[j] == 0)
                {
                    arrayDistinct[j] = array[i];
                    arrayDistinctSize++;
                    j = 10; //break for loop
                }
            }
        }

        // Output
        System.out.println("The number of distinct number is " + arrayDistinctSize);
        System.out.print("The distinct numbers are: ");

        for(int i = 0; i < arrayDistinctSize; i++)
        {
            System.out.print(arrayDistinct[i] + " ");
        }

    }
}