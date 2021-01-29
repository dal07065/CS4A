// Lina Kang
// 1072568
// CS4A TTH 7:30 - 9:50
// Exercise 13.6 - Create a new class called ComparableCircle and
//				   implement the "compareTo" method

public class Exercise_13_6 {
	public static void main(String[]args)
	{
		ComparableCircle circle1 = new ComparableCircle("yellow", false, 4.5);
		ComparableCircle circle2 = new ComparableCircle("green", false, 1.5);
		
		System.out.println("Created circle1: radius = 4.5");
		System.out.println("Created circle2: radius = 1.5");
		
		System.out.println("\nComparing circle1 and circle2...\n");
		
		int compared = circle1.compareTo(circle2);
		
		if(compared > 0)
			System.out.println("circle1 is larger than circle2.");
		else if(compared < 0)
			System.out.println("circle2 is larger than circle1");
		else
			System.out.println("circle1 is as big as circle2");
	}
}

// GeometricObject and Circle class defined in Exercise_13_5.java

class ComparableCircle extends Circle //Circle already implements Comparable<GeometricObject>
{
	public ComparableCircle()
	{
		super();
	}
	public ComparableCircle(String color, boolean filled, double radius)
	{
		super(color, filled, radius);
	}
	@Override
	public int compareTo(GeometricObject o) {
		if(getArea() > o.getArea())
			return 1;
		else if(getArea() < o.getArea())
			return -1;
		else
			return 0;
	}
}

