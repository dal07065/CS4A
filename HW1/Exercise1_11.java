// Lina Kang
// CS4A
// Homework 1 - Exercise 1.11
// Due date : 08/27/20

// Display the population for each of the next five years
// in consideration of the changes due to birth, death, and immigrations

public class Exercise1_11 {
    public static void main (String[]args)
    {
        int population = 312_032_486;
        int days = 365;
        int yearInSeconds = days * 24 * 60 * 60;

        // number of births, deaths, immigrants in 1 year
        float births = yearInSeconds / 7;
        float deaths = yearInSeconds / 13;
        float immigrants = yearInSeconds / 45;

        System.out.println("Starting Population : " + population + " people.");
        System.out.println();

        // iterate through 5 years, changing the population by birth, death, and immigration
        for(int i = 0; i < 5; i++)
        {
            population = population + (int)(births - deaths + immigrants);

            System.out.println("Year " + (i+1) + " - Population : " + population + " people.");
        }
    }
}