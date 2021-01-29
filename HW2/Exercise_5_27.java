// Lina Kang
// 1072568
// 09/05/2020
// HW2 5.27 - Calculate leap years from 101 to 2100

package HW2;

public class Exercise_5_27 {
    public static void main(String[]args)
    {
        //It is a leap year if...
        // - the year is evenly divisible by 4 but not by 100
        // - the year is evenly divisible by 100 && 400

        System.out.println("Leap Years: ");

        int year      = 101;    // starting year to count from
        int leapCount = 0;      // to print the total number of leap years 
        int tenCount  = 0;      // to keep count of 10 leap years in one line

        while(year < 2100)
        {
            // if the conditions meet, print the leap year
            if((year % 4 == 0 && year % 100 != 0)||(year % 100 == 0 && year % 400 == 0))
            {
                System.out.print(year + " ");
                leapCount++;
                tenCount++;
            }
            // go to the next line if 10 leap years have been found and printed
            if(tenCount == 10)
            {
                System.out.println();
                tenCount = 0;
            }
            year++;
        }

        System.out.println("\n\nBetween 101 - 2100, there were " + leapCount + " many leap years");
    }
    
}
