// Lina Kang
// 1072568
// CS4A TTH 7:30 - 9:50
// Exercise 10.15 - Determine the bounding rectangle from a given set of points

import java.util.Scanner;

public class Exercise_10_15 {
	public static void main(String[]args)
	{
		Scanner input = new Scanner(System.in);
		System.out.print("Enter five points: ");
		double[][] points = new double[5][2];
		for(int i = 0; i < points.length; i++)
		{
			points[i][0] = input.nextDouble();
			points[i][1] = input.nextDouble();
		}
		MyRectangle2D rect = getRectangle(points);
		
		System.out.println("The bounding rectangle's center (" + rect.getX() + 
							", " + rect.getY() + "), width " + rect.getWidth() + 
							", height " + rect.getHeight());
	}
	/*
		function: getRectangle()
		purpose: return the bounding rectangle
		algorithm:
		- traverse through the points 2D array
		- if a point has an x-value or y-value that exceeds the current min/max value
			- set the point's x-value/y-value as the left/right/top/bottom min or max number
		- when all the leftmost, rightmost, top, and bottom limits have been found,
			- determine the width/height/x/y values of the bounding box rectangle
	*/
	public static MyRectangle2D getRectangle(double[][] points)
	{	
		double leftx = points[0][0], rightx = points[0][0], boty = points[0][1], topy = points[0][1];
		for(int i = 1; i < points.length; i++)
		{
			if(points[i][0] < leftx)
			{
				leftx = points[i][0];
			}
			else if(points[i][0] > rightx)
			{
				rightx = points[i][0];
			}
			if(points[i][1] < boty)
			{
				boty = points[i][1];
			}
			else if(points[i][1] > topy)
			{
				topy = points[i][1];
			}
		}
		double width = rightx - leftx;
		double height = topy - boty;
		double x = (rightx + leftx)/2;
		double y = (topy + boty)/2;
		
		MyRectangle2D rect = new MyRectangle2D(x, y, width, height);
		return rect;
	}
}
class MyRectangle2D
{
	private double x;
	private double y;
	private double width;
	private double height;
	
	public MyRectangle2D()
	{
		x = 0;
		y = 0;
		width = 1;
		height = 1;
	}
	public MyRectangle2D(double x, double y, double width, double height)
	{
		this.x = x;
		this.y = y;
		this.width = width;
		this.height = height;
	}
	public double getArea()
	{
		return width*height;
	}
	public double getPerimeter()
	{
		return width*2 + height*2;
	}
	public boolean contains(double x, double y)
	{
		double leftx  = this.x - width/2;
		double rightx = this.x + width/2;
		double boty   = this.y - height/2;
		double topy   = this.y + height/2;
		
		if(x >= leftx && x <= rightx && y >= boty && y <= topy)
		{
			return true;
		}
		
		return false;
	}
	public boolean contains(MyRectangle2D r)
	{
		double leftx  = this.x - width/2;
		double rightx = this.x + width/2;
		double boty   = this.y - height/2;
		double topy   = this.y + height/2;
		
		double leftxr  = r.x - width/2;
		double rightxr = r.x + width/2;
		double botyr   = r.y - height/2;
		double topyr   = r.y + height/2;
		
		if(leftxr > leftx && rightxr < rightx && botyr > boty && topyr < topy)
		{
			return true;
		}
		return false;
	}
	public boolean overlaps(MyRectangle2D r)
	{
		double leftx  = this.x - width/2;
		double rightx = this.x + width/2;
		double boty   = this.y - height/2;
		double topy   = this.y + height/2;
		
		double leftxr  = r.x - width/2;
		double rightxr = r.x + width/2;
		double botyr   = r.y - height/2;
		double topyr   = r.y + height/2;
		
		if(rightxr < leftx || botyr > topy || leftxr > rightx || topyr < boty)
		{
			return false;
		}
		return true;
	}
	public double getX()
	{
		return x;
	}
	public double getY()
	{
		return y;
	}
	public double getWidth()
	{
		return width;
	}
	public double getHeight()
	{
		return height;
	}

}