// Kang, Lina
// 1072568
// Quiz 3 - Programming Exercise

// This program will calculate the day of the week based on a given date
// Ex:
//    06/16/2000 -> Friday

import java.util.Scanner;

public class Quiz3_Lina_Kang {
    public static void main(String[]args)
    {
        Scanner input = new Scanner(System.in);

        int monthInput;
        int yearInput;
        int dayInput;

        System.out.println("Welcome to the Day of Week calcuator. This awesome program will tell you\n" + 
                            "what day of the week you were born on! \n" +
                            "The program will allow you to find the day of the week for multiple dates.\n" +
                            "When you want to exit the program enter a 0 for the month, day, or year.\n");
        
        System.out.println("Enter a date in MM DD YYYY format (example: 11 1 1970 or 6 21 2011)");
        monthInput = input.nextInt();
        dayInput = input.nextInt();
        yearInput = input.nextInt();

        while(monthInput != 0 && dayInput != 0 && yearInput != 0)
        {
            String dayOfWeek = whichDayOfWeek(monthInput, dayInput, yearInput);

            System.out.println("The date you entered was a " + dayOfWeek);
            System.out.println();

            System.out.println("Enter a date in MM DD YYYY format (example: 11 1 1970 or 6 21 2011)");
            monthInput = input.nextInt();
            dayInput = input.nextInt();
            yearInput = input.nextInt();
        }
        
        System.out.println();
        System.out.println("THANK YOU FOR USING THE DAY OF WEEK CALCULATOR");
        
    }
    public static String whichDayOfWeek(int monthInput, int dayInput, int yearInput)
    {
        String dayOfTheWeek = "";
        int daysPassed = 0;

        final int START_DAY_JAN_1_1800 = 3;     // if the week started with day 1 : Sunday, 
                                                // then after Sunday, Monday, and Tuesday (3days),
                                                // it will be the day after START_DAY which is Wednesday (4th day)
        
        // **** Formula ****
        // (START_DAY + (how many days have passed ever since)) % 7 == ANSWER
        // (    3     + (365 + 366 + 31 + 28 + ... + dayInput)) % 7 == ANSWER


        daysPassed += START_DAY_JAN_1_1800;

        // Get the number of days passed by years
        daysPassed += getDaysInYears(yearInput);

        // Get the number of days passed within the months of the yearInput
        daysPassed += getDaysInMonths(monthInput, yearInput);

        // Calculate how many days have passed since the beginning of input month
        daysPassed += dayInput;

        // Remainder will show remaining days of the week which
        // results to the actual day of the week
        daysPassed %= 7;
        if(daysPassed == 0)
            daysPassed = 7;

        dayOfTheWeek = getDayOfTheWeekInString(daysPassed);

        return dayOfTheWeek;
    }
    //Calculate the number of days passed in bulks of years passed after 1800
    public static int getDaysInYears(int yearInput)
    {
        int daysPassed = 0;
        for(int i = 1800; i < yearInput; i++)
        {
            if(isLeapYear(i))
                daysPassed += 366;
            else
                daysPassed += 365;
        }
        return daysPassed;
    }
    //Calculates how many days passed in bulks of months after the beginning of the input year
    public static int getDaysInMonths(int monthInput, int yearInput)
    {
        int daysPassed = 0;

        for(int i = 1; i < monthInput; i++)
        {
            if(i == 1 || i == 3 || i == 5 || i == 7 || i == 8 || i == 10 || i == 12)
                daysPassed += 31;
            else if(i == 2)
            {
                if(isLeapYear(yearInput))
                    daysPassed += 29;
                else
                    daysPassed += 28;
            }
            else
                daysPassed += 30;
        }
        return daysPassed;
    }
    // Translates the NUMBER of day of week into its NAME in the days of the week
    public static String getDayOfTheWeekInString(int daysPassed)
    {
        String dayOfTheWeek = "";
        
        switch(daysPassed)
        {
            case 1:  
            dayOfTheWeek = "Sunday";
                break;
            case 2:  
            dayOfTheWeek = "Monday";
                break;
            case 3:  
            dayOfTheWeek = "Tuesday";
                break;
            case 4:  
            dayOfTheWeek = "Wednesday";
                break;
            case 5:  
            dayOfTheWeek = "Thursday";
                break;
            case 6:  
            dayOfTheWeek = "Friday";
                break;
            case 7:  
            dayOfTheWeek = "Saturday";
                break;
        }

        return dayOfTheWeek;
    }
    // Returns True/False based on whether given year is leap year or not
    public static boolean isLeapYear(int year)
    {
        if(year % 400 == 0 || (year % 4 == 0 && year % 100 != 0))
            return true;
        return false;
    }
    
}
