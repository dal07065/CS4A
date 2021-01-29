// Lina Kang
// 1072568
// CS4A TTH 7:30 - 9:50
// Exercise 13.5 - Modify the GeometricObject to implement Comparable interface

public class Exercise_13_5 {
	public static void main(String[]args)
	{
		// Comparing areas of 2 different circles...
		
		GeometricObject circleDefault    = new Circle();
		GeometricObject circleBlue       = new Circle("blue", false, 2.5);
		
		System.out.println("Created circleDefault: radius = 1");
		System.out.println("Created circleBlue: radius = 2.5");
		
		System.out.println("\nComparing circleDefault and circleBlue...\n");	
		
		int comparedCircle    = GeometricObject.max(circleDefault, circleBlue);
		
		if(comparedCircle > 0)
			System.out.println("*circleDefault is larger than circleBlue.*");
		else if(comparedCircle < 0)
			System.out.println("*circleBlue is larger than circleDefault*");
		else
			System.out.println("*circleDefault is as big as circleBlue*");
		
		System.out.println();
		
		// Comparing areas of 2 different rectangles...
		
		GeometricObject rectangleDefault = new Rectangle();
		GeometricObject rectangleOrange  = new Rectangle("orange", false, 2, 5);
		
		System.out.println("Created rectangleDefault: length = 1, width = 1");
		System.out.println("Created rectangleOrange: length = 2, width = 5");
		
		System.out.println("\nComparing rectangleDefault and rectangleOrange...\n");
		
		int comparedRectangle = GeometricObject.max(rectangleDefault, rectangleOrange);
	
		if(comparedRectangle > 0)
			System.out.println("*rectangleDefault is larger than rectangleOrange.*");
		else if(comparedRectangle < 0)
			System.out.println("*rectangleOrange is larger than rectangleDefault*");
		else
			System.out.println("*rectangleDefault is as big as rectangleOrange*");
		
		System.out.println();
	}
}

abstract class GeometricObject implements Comparable<GeometricObject>
{
	private String color = "white";
	private boolean filled;
	private java.util.Date dateCreated;
	
	protected GeometricObject() 
	{
		dateCreated = new java.util.Date();
	}
	
	protected GeometricObject(String color, boolean filled)
	{
		dateCreated = new java.util.Date();
		this.color = color;
		this.filled = filled;
	}
	
	public String getColor()
	{
		return color;
	}
	
	public void setColor(String color)
	{
		this.color = color;
	}
	public boolean isFilled(){
		return filled;
	}
	public void setFilled(boolean filled) {
		this.filled = filled;
	}
	public java.util.Date getDateCreated() {
		return dateCreated;
	}
	@Override
	public String toString()
	{
		return "created on " + dateCreated + "\ncolor: " + color +
				" and filled: " + filled;
	}
	
	// ----------- MODIFICATIONS --------------
	
	@Override
	public int compareTo(GeometricObject o) {
		if(getArea() > o.getArea())
			return 1;
		else if(getArea() < o.getArea())
			return -1;
		else
			return 0;
	}
	
	public static int max(GeometricObject o, GeometricObject o2)
	{
		return o.compareTo(o2);
	}
	
	// ---------- END MODIFICATIONS ------------
	
	public abstract double getArea();
	public abstract double getPerimeter();
}

// --- Created "Circle" and "Rectangle" classes extending GeometricObject

class Circle extends GeometricObject
{
	private double radius;
	
	public Circle()
	{
		radius = 1;
	}
	public Circle(String color, boolean filled, double radius)
	{
		super(color, filled);
		this.radius = radius;
	}
	@Override
	public double getArea() {
		// TODO Auto-generated method stub
		return Math.PI * radius * radius;
	}

	@Override
	public double getPerimeter() {
		// TODO Auto-generated method stub
		return Math.PI * radius * 2;
	}
	
}
class Rectangle extends GeometricObject
{
	private double length;
	private double width;
	
	public Rectangle()
	{
		length = 1;
		width = 1;
	}
	public Rectangle(String color, boolean filled, double length, double width)
	{
		super(color, filled);
		this.length = length;
		this.width = width;
	}
	@Override
	public double getArea() {

		return length * width;
	}

	@Override
	public double getPerimeter() {

		return 2 * length + 2 * width;
	}
	
}