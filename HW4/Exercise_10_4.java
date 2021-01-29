// Lina Kang
// 1072568
// CS4A TTH 7:30 - 9:50
// Exercise 10.4 - Design and Test MyPoint Class

package HW4;

public class Exercise_10_4 {
    public static void main(String[]args)
    {
        MyPoint point1 = new MyPoint(0,0);
        MyPoint point2 = new MyPoint(10, 30.5);

        System.out.printf("The distance of between point1 and point2: %.2f", point1.distance(point2));
    }
}

class MyPoint
{
    private double x;
    private double y;
    public MyPoint()
    {
        x = 0;
        y = 0;
    }
    public MyPoint(double xP, double yP)
    {
        x = xP;
        y = yP;
    }
    double distance(MyPoint pt)
    {
        return Math.sqrt(Math.pow(x-pt.x, 2) + Math.pow(y-pt.y, 2));
    }
    double distance(double xp, double yp)
    {
        return Math.sqrt(Math.pow(x-xp, 2) + Math.pow(y-yp, 2));
    }
    double getx()
    {
        return x;
    }
    double gety()
    {
        return y;
    }
}