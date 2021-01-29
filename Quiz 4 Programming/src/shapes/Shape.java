// Class - Shape
// - base class for implementing more specific classes such as Circle or Square
// - serves primarily for its inheriting classes

package shapes;

public class Shape 
{
	private double side;
	
	public Shape()	
	{
		side = 1;
	}
	public Shape(double s)
	{
		side = s;
	}
	public double getSide()
	{
		return side;
	}
}
