// Lina Kang
// 1072568
// 09/12/2020
// Exercise 7.19 - Checks if list is sorted

import java.util.Scanner;
public class Exercise_7_19{
    public static void main(String[]args)
    {
        Scanner input = new Scanner(System.in);
        
        int[] array = new int[25];
        int size = 0;

        // Input - Get input numbers one by one from a single line of numbers entered
        System.out.print("Enter list: ");
        size = input.nextInt();

        for(int i = 0; i < size; i++)
        {
            array[i] = input.nextInt();
        }

        // Output - Checks if its sorted or not and print output
        if(isSorted(array, size))
        {
            System.out.println("The list is already sorted.");
        }
        else
        {
            System.out.println("The list is not sorted.");
        }
        
    }

    // Checks whether list is sorted
    // - Compares one value to another value in front in list
    // - If previous value is greater than next value, it is NOT sorted
    public static boolean isSorted(int[] list, int size)
    {
        boolean returnValue = true;
        for(int i = 0; i < size-1; i++)
        {
            if(list[i+1] < list[i])
            {
                returnValue = false;
                i = size;
            }
        }
        return returnValue;
    }
}