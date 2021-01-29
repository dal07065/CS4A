import java.util.Scanner;

public class PrintCalendar2 {
    public static void main(String[]args)
    {
        Scanner input = new Scanner(System.in);
        int monthInput;
        int yearInput;
        int days;

        System.out.println("----------- Print Calendar ------------");
        System.out.print(" Please enter month & year (e.g. 4 2010) : " );
        
        monthInput = input.nextInt();
        yearInput = input.nextInt();
        while(monthInput < 1 && monthInput > 12 && yearInput < 1800)
        {
            System.out.print(" Please enter VALID month & year (e.g. 4 2010) : " );
            monthInput = input.nextInt();
            yearInput = input.nextInt();
        }
        
        System.out.println();
        System.out.println("---------------------------------------");

        print(yearInput, monthInput);

        

    }
    public static void print(int year, int month)
    {
        int days = 0;
        switch(month)
        {
            case 1:  
                System.out.printf("%20s %4d      ", "January"   , year);
                days = 31;
                break;
            case 2:  
                System.out.printf("%20s %4d      ", "February"  , year); 
                days = (isLeapYear(year)? 29 : 28);
                break;
            case 3:  
                System.out.printf("%20s %4d      ", "March"     , year); 
                days = 31;
                break;
            case 4:  
                System.out.printf("%20s %4d      ", "April"     , year); 
                days = 30;
                break;
            case 5:  
                System.out.printf("%20s %4d      ", "May"       , year); 
                days = 31;
                break;
            case 6:  
                System.out.printf("%20s %4d      ", "June"      , year);
                days = 30;
                break;
            case 7:  
                System.out.printf("%20s %4d      ", "July"      , year); 
                days = 31;
                break;
            case 8:  
                System.out.printf("%20s %4d      ", "August"    , year); 
                days = 31;
                break;
            case 9:  
                System.out.printf("%20s %4d      ", "September" , year); 
                days = 30;
                break;
            case 10: 
                System.out.printf("%20s %4d      ", "October"   , year); 
                days = 31;
                break;
            case 11: 
                System.out.printf("%20s %4d      ", "November"  , year); 
                days = 30;
                break;
            case 12: 
                System.out.printf("%20s %4d      ", "December"  , year);
                days = 31;
                break;
        }
        System.out.println();
        System.out.println("-----------------------------");
        System.out.println(" Sun Mon Tue Wed Thu Fri Sat ");
        printDays(year, month, days);
    }
    public static void printDays(int year, int month, int days)
    {
        // Figure out what day to START from
        // ? - How many days have passed since START_DAY_FOR_JAN_1_1800 to start of input month?
        // % those days by 7 => remaining days => before the start of input month

        final int START_DAY_FOR_JAN_1_1800 = 3;
        int daysPassed = 0;
        for(int i = 1800; i < year; i++)
        {
            if(isLeapYear(i))
                daysPassed += 366;
            else
                daysPassed += 365;
        }

        daysPassed += START_DAY_FOR_JAN_1_1800;

        int daysPreviousMonth = daysPassed % 7;

        for(int i = 0; i < daysPreviousMonth; i++)
        {
            System.out.print("    ");
        }

        for(int i = 1; i <= days; i++)
        {
            System.out.printf("%4d", i);

            if((i + daysPreviousMonth)%7 == 0)
                System.out.println();
        }
    }
    public static boolean isLeapYear(int year)
    {
        if(year % 400 == 0 || (year % 4 == 0 && year % 100 != 0))
            return true;
        return false;
    }
}

