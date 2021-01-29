import java.util.Scanner;

public class PrintDay {
    public static void main(String[]args)
    {
        Scanner input = new Scanner(System.in);
        int monthInput;
        int yearInput;
        int dayInput;

        System.out.println("Welcome to the Day of Week calcuator. This awesome program will tell you\n" + 
                            "what day of the week you were born on! \n" +
                            "The program will allow you to find the day of the week for multiple dates." +
                            "When you want to exit the program enter a 0 for the month, day, or year.\n");
        do
        {
            System.out.print("Enter a date in MM DD YYYY format (example: 11 1 1970 or 6 21 2011)");
            monthInput = input.nextInt();
            dayInput = input.nextInt();
            yearInput = input.nextInt();

            String dayOfWeek = figureOutWhichDay(monthInput, dayInput, yearInput);

            System.out.println("The date you entered was a " + dayOfWeek);
            System.out.println();

        }while(monthInput != 0 && dayInput != 0 && yearInput != 0);
        
        System.out.println("THANK YOU FOR USING THE DAY OF WEEK CALCULATOR");
    }
    public static String figureOutWhichDay(int month, int day, int year)
    {
        // Figure out what day to START from
        // ? - How many days have passed since START_DAY_FOR_JAN_1_1800 to start of input month?
        // % those days by 7 => remaining days => before the start of input month

        int dayOfWeek = 0;

        final int START_DAY_FOR_JAN_1_1800 = 3;
        int daysPassed = 0;
        for(int i = 1800; i < year; i++)
        {
            if(isLeapYear(i))
                daysPassed += 366;
            else
                daysPassed += 365;
        }
        for (int i = 1; i < month; i++)
            daysPassed += getNumberOfDaysInMonth(year, i);

        daysPassed += START_DAY_FOR_JAN_1_1800;

        int daysPreviousMonth = daysPassed % 7;

        for(int i = 0; i < daysPreviousMonth; i++)
            dayOfWeek++;

        for(int i = 1; i <= day; i++)
        {
            dayOfWeek++;

            if((i + daysPreviousMonth)%8 == 0)
                dayOfWeek = 1;
        }

        String dayOfWeekStr = figureOutWhichDayOfWeek(dayOfWeek);
        return dayOfWeekStr;
    }
    public static String figureOutWhichDayOfWeek(int dayOfWeek)

    {
        String dayOfWeekString = "";

        switch(dayOfWeek)
        {
            case 1:  
            dayOfWeekString = "Sunday";
                break;
            case 2:  
                dayOfWeekString = "Monday";
                break;
            case 3:  
                dayOfWeekString = "Tuesday";
                break;
            case 4:  
            dayOfWeekString = "Wednesday";
                break;
            case 5:  
            dayOfWeekString = "Thursday";
                break;
            case 6:  
            dayOfWeekString = "Friday";
                break;
            case 7:  
            dayOfWeekString = "Saturday";
                break;
        }
        return dayOfWeekString;
    }
    public static int getNumberOfDaysInMonth(int month, int year)
    {
        int days = 0;
        switch(month)
        {
            case 1:  
                days = 31;
                break;
            case 2:  
                days = (isLeapYear(year)? 29 : 28);
                break;
            case 3:  
                days = 31;
                break;
            case 4:  
                days = 30;
                break;
            case 5:  
                days = 31;
                break;
            case 6:  
                days = 30;
                break;
            case 7:  
                days = 31;
                break;
            case 8:  
                days = 31;
                break;
            case 9:  
                days = 30;
                break;
            case 10: 
                days = 31;
                break;
            case 11: 
                days = 30;
                break;
            case 12: 
                days = 31;
                break;
        }
        return days;
    }
    public static boolean isLeapYear(int year)
    {
        if(year % 400 == 0 || (year % 4 == 0 && year % 100 != 0))
            return true;
        return false;
    }
}

