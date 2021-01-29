// Lina Kang
// 1072568
// CS4A TTH 7:30 - 9:50
// Exercise 13.7 - Design interface "Colorable" and its method "howToColor()"

public class Exercise_13_7 {

	public static void main(String[] args) 
	{
		// Initialize Geometric Objects array and its elements
		
		GeometricObject[] objs = new GeometricObject[5];
		
		objs[0] = new Circle("pink", false, 1.5);
		objs[1] = new Rectangle("gold", false, 5, 10);
		objs[2] = new Square("grey", true, 3.1415);
		objs[3] = new Circle("turquoise", false, 1.99);
		objs[4] = new Square("blue", true, 25);
		
		// Display each obj's area and invoke howToColor method IF it is Colorable
		
		for(int i = 0; i < 5; i++)
		{
			System.out.printf("Area of this GeometricObject: %6.2f%n", objs[i].getArea());
			
			if(objs[i] instanceof Colorable)
			{
				System.out.print("This object is colorable. How to color: ");
				((Colorable)objs[i]).howToColor();
			}
			
			System.out.println();
				
		}
	}

}

interface Colorable
{
	void howToColor();
}

class Square extends GeometricObject implements Colorable
{

	private double length;
	
	public Square()
	{
		length = 1;
	}
	public Square(String color, boolean filled, double length)
	{
		super(color, filled);
		this.length = length;
	}
	
	@Override
	public void howToColor() {
		System.out.println("Color all four sides.");
	}

	@Override
	public double getArea() {
		return length * length;
	}

	@Override
	public double getPerimeter() {
		return 4 * length;
	}
	
}
