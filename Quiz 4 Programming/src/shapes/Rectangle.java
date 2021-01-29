// Class - Rectangle
// - child class of Shape
// - takes in another variable, "side2", in order to 
//   calculate the area/perimeter of a rectangle

package shapes;

public class Rectangle extends Shape
{
	private double side2;
	
	public Rectangle()
	{
		super();
		side2 = 1;
	}
	public Rectangle(double s1, double s2)
	{
		super(s1);
		side2 = s2;
	}
	public double calcArea()
	{
		return getSide() * side2;
	}
	public double calcPerim()
	{
		return 2 * getSide() + 2 * side2;
	}
	public double getSide2()
	{
		return getSide();
	}
}
