// Lina Kang
// 1072568
// 09/12/2020
// Exercise 7.18 - Bubble Sort Algorithm

import java.util.Scanner;

public class Exercise_7_18{
    public static void main(String[]args)
    {
        Scanner input = new Scanner(System.in);

        double[] array = new double[10];

        // Input - Get input numbers one by one from a single line of numbers entered
        System.out.print("Enter ten DOUBLE numbers: ");

        for(int i = 0; i < 10; i++)
        {
            array[i] = input.nextDouble();
        }

        System.out.println("The UNSORTED array: " + java.util.Arrays.toString(array));

        // Processing
        bubbleSort(array);

        // Output
        System.out.println("The SORTED array:   " + java.util.Arrays.toString(array));

    }
    // Sort the array using Bubble Sort algorithm
    public static void bubbleSort(double[] array)
    {
        double temp;
        boolean checked = false;

        // Loop until check REMAINS false throughout the whole for loop iteration
        while(!checked)
        {
            for(int i = 0; i < array.length-1; i++)
            {
                if(array[i+1] < array[i])
                {
                    // Swap
                    temp = array[i];
                    array[i] = array[i+1];
                    array[i+1] = temp;
                    checked = true;
                }
            }
            // If checked changed to true, keep looping. If not, exit.
            checked = checked == true? false : true;
        }
    }
}