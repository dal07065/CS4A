// Lina Kang
// 1072568
// CS4A TTH 7:30 - 9:50
// Exercise 13.17 - Create a Complex class and test out its functions

import java.util.Scanner;

public class Exercise_13_17 {

	public static void main(String[] args) {

		Scanner input = new Scanner(System.in);
		
		System.out.print("Enter the first complex number: ");
		
		Complex num1 = new Complex(input.nextDouble(),input.nextDouble());
		
		System.out.print("Enter the second complex number: ");
		
		Complex num2 = new Complex(input.nextDouble(),input.nextDouble());
		
		// Performing add, subtract, multiply, divide, and abs
		num1.add(num2);
		num1.subtract(num2);
		num1.multiply(num2);
		num1.divide(num2);
		num1.abs(num2);
	}

}

class Complex implements Cloneable
{
	double number = 0;
	double a= 0;
	double b = 0;
	public Complex()
	{
		number = 0;
	}
	public Complex(double a, double b)
	{
		this.a = a;
		this.b = b;
	}
	public Complex(double a)
	{
		this.a = a;
		this.b = 0;
	}
	public String toString()
	{
		if(b != 0)
			return "(" + a + " + " + b + "i)";
		else
			return "(" + a + ")";
	}
	public void add(Complex num)
	{
		double a_add = num.a + this.a;
		double b_add = num.b + this.b;
		
		System.out.println(this.toString() + " + " + num.toString() + " = " +
						   a_add + " + " + b_add + "i");
	}
	public void subtract(Complex num)
	{
		double a_sub = this.a - num.a;
		double b_sub = this.b - num.b;
		
		System.out.println(this.toString() + " - " + num.toString() + " = " +
				a_sub + " + " + b_sub + "i");	
	}
	public void multiply(Complex num)
	{
		double a1 = (this.a * num.a);
		double b1 = (this.b * num.b);
		double a_result = a1 - b1;
		double a2 = this.a * num.b;
		double b2 = this.b * num.a;
		double b_result = a2 + b2;
		
		System.out.println(this.toString() + " * " + num.toString() + " = " +
				a_result + " + " + b_result + "i");		
	}
	public void divide(Complex num)
	{
		double a_div = this.a * num.a + this.b * num.b;
		double b_div = this.b * num.a - this.a*num.b;
		double denom = num.a*num.a + num.b*num.b;
		
		a_div /= denom;
		b_div /= denom;
		
		System.out.printf(this.toString() + " / " + num.toString() + " = %.3f + %.3fi%n"
						   , a_div, b_div);	}
	public void abs(Complex num)
	{		
		System.out.println("|(" + a + " + " + b + "i)| = " + Math.sqrt((a*a) + (b*b)));
	}
	public double getRealPart()
	{
		return a;
	}
	public double getImaginaryPart()
	{
		return b;
	}
	public Object clone() throws CloneNotSupportedException
	{
		return super.clone();
	}
	
}