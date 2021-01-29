// Class - Square
// - child class of Shape

package shapes;

public class Square extends Shape 
{
	public Square()
	{
		super(1);
	}
	public Square(double s)
	{
		super(s);
	}
	public double calcArea()
	{
		return getSide() * getSide();
	}
	public double calcPerim()
	{
		return 4 * getSide();
	}
}
