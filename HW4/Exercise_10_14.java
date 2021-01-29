// Lina Kang
// 1072568
// CS4A TTH 7:30 - 9:50
// Exercise 10.14 - Design a Date class which holds information about
// a certain day, month, and year

import java.util.Calendar;
import java.util.GregorianCalendar;

public class Exercise_10_14 {

	public static void main(String[] args) {
		MyDate date1 = new MyDate();
		MyDate date2 = new MyDate(34355555133101L);
		
		
		System.out.println("*Month is 0-based (0 is January)");
		System.out.println("Date of \"new MyDate()\"(DD/MM/YYYY): " + 
							date1.getDay() +"/"+ 
							date1.getMonth() +"/"+ 
							date1.getYear());
		
		System.out.println("Date of \"new MyDate(34355555133101L)\"(DD/MM/YYYY): " + 
							date2.getDay() +"/"+ 
							date2.getMonth() +"/"+ 
							date2.getYear());
	}

}
// MyDate Class
class MyDate
{
	private int year;
	private int month; // 0 is January
	private int day;

	MyDate()
	{
		Calendar calendar = new GregorianCalendar();
		year = calendar.get(Calendar.YEAR);
		month = calendar.get(Calendar.MONTH);
		day = calendar.get(Calendar.DAY_OF_MONTH);
	}
	MyDate(long elapsedTime)
	{
		setDate(elapsedTime);
	}
	MyDate(int yr, int m, int d)
	{
		year = yr;
		month = m;
		day = d;
	}
	int getYear()
	{
		return year;
	}
	int getMonth()
	{
		return month;
	}
	int getDay()
	{
		return day;
	}
	
	// *setDate algorithm*
	// 76 - receives the super long elapsed time in milliseconds
	// 78 - divide it up until you have # of years (that have passed after 1970)
	// 79 -set year
	// 80 - get the fraction bit from the division -> for month & day
	// 81 - set month 
	// 82 - get the fraction bit from THAT division
	// 83 - set day
	
	void setDate(long elapsedTime)
	{
		double time = (elapsedTime/1000.0/60.0/60.0/24.0/365.0);
		year = 1970 + (int)time;
		time = time - (int)time;
		month = (int)(time * 12);
		time = time - (int)time;
		day = (int)(time * 31);
	}
}