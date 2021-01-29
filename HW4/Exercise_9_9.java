// Lina Kang
// 1072568
// CS4A TTH 7:30 - 9:50
// Exercise 9.9 - Design and Test RegularPolygon Class

package HW4;

public class Exercise_9_9 {
    public static void main(String[]args)
    {
        RegularPolygon polygon1 = new RegularPolygon();
        RegularPolygon polygon2 = new RegularPolygon(6,4);
        RegularPolygon polygon3 = new RegularPolygon(10, 4, 5.6, 7.8);

        System.out.println("Polygon 1 : no-arg constructor");
        System.out.println("Perimeter: " + polygon1.getPerimeter());
        System.out.println("Area: " + polygon1.getArea()+"\n");
    
        System.out.println("Polygon 2 : 2-arg constructor");
        System.out.println("Perimeter: " + polygon2.getPerimeter());
        System.out.println("Area: " + polygon2.getArea()+"\n");

        System.out.println("Polygon 3 : 4-arg constructor");
        System.out.println("Perimeter: " + polygon3.getPerimeter());
        System.out.println("Area: " + polygon3.getArea()+"\n");
    }
}
class RegularPolygon
{
    private int n = 3;
    private double side = 1;
    private double x = 0;
    private double y = 0;

    RegularPolygon()
    {

    }
    RegularPolygon(int nParam, double sideParam)
    {
        n = nParam;
        side = sideParam;
    }
    RegularPolygon(int nParam, double sideParam, double xParam, double yParam)
    {
        n = nParam;
        side = sideParam;
        x = xParam;
        y = yParam;
    }
    int getN()
    {
        return n;
    }
    double getSide()
    {
        return side;
    }
    double getX()
    {
        return x;
    }
    double getY()
    {
        return y;
    }
    double getPerimeter()
    {
        return n*side;
    }
    double getArea()
    {
        return (n*side*side)/(4* Math.tan(Math.PI / n));
    }

}

