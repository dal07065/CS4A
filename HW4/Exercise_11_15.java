// Lina Kang
// 1072568
// CS4A TTH 7:30 - 9:50
// Exercise 11.15 - Determine the area of a convex polygon

import java.util.ArrayList;
import java.util.Scanner;

public class Exercise_11_15 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner input = new Scanner(System.in);
		
		ArrayList<Point> polygon = new ArrayList<Point>();
		
		System.out.print("Enter the number of the points: ");
		int points = input.nextInt();
		
		System.out.print("Enter the coordinates of the points: ");
		double x, y;
		
		for(int i = 0; i < points; i++)
		{
			x = input.nextDouble();
			y = input.nextDouble();
			polygon.add(new Point(x,y));
		}
		
		double area = 0;
		
		// area of a polygon formula used from 
		// https://www.mathopenref.com/coordpolygonarea.html
		
		for(int i = 0; i < points-1; i++)
		{
			area += (polygon.get(i).getX())*(polygon.get(i+1).getY()) - 
					(polygon.get(i).getY())*(polygon.get(i+1).getX());
		}
		
		area += (polygon.get(points-2).getX())*(polygon.get(points-1).getY()) - 
				(polygon.get(points-2).getY())*(polygon.get(points-1).getX());
		
		area /= 2;
		
		area = Math.abs(area);
		
		System.out.printf("The total area is %.2f", area);
		// The total area is 250.075 (in the book)
		// (*I could not find another way that would get this answer...)
	}

}

class Point
{
	private double x;
	private double y;
	
	public Point(double x, double y)
	{
		this.x = x;
		this.y = y;
	}
	public double getX() {return x;}
	public double getY() {return y;}
}