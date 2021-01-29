// Class - Circle
// - child class of Shape
// - depending on how specific calculations need to be, 
//   separate constant PI has been made (instead of using Math.PI)

package shapes;

public class Circle extends Shape
{	
	private final double PI = 3.14159;
	
	public Circle()
	{
		super(1);
	}
	public Circle(double s)
	{
		super(s);
	}
	public double calcArea()
	{
		return PI * getSide() * getSide();
	}
	public double calcPerim()
	{
		return 2 * PI * getSide();
	}
}
