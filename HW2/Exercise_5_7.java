// Lina Kang
// 1072568
// 09/05/2020
// HW2 5.7 - Compute the growing interest of tuition

package HW2;

public class Exercise_5_7 {
    public static void main(String[]args)
    {
        final double currentTuition = 10_000;

        double tuition = currentTuition;

        // Calculate - For 10 years, calculate and add 5% annual interest
        for(int i = 0; i < 10; i++)
            tuition *= 1.05;

        // Output - Current tuition and calculated tuition in 10 years
        System.out.printf("Current Tuition: $%.2f\n", currentTuition);
        System.out.printf("Tuition in 10 years: $%.2f\n", tuition);

        // Calculate - After 10 years, calculate 4 year's worth of tuition
        double sum4Years = 0;

        for(int i = 0; i < 4; i++)
        {
            tuition *= 1.05;
            sum4Years += tuition;
        }

        // Output - Output 4 year's worth of tuition after 10 years
        System.out.printf("Total Cost of 4 year's worth of tuition: $%.2f",sum4Years);

    }
    
}
