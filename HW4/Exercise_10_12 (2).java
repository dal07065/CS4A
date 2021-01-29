// Lina Kang
// 1072568
// CS4A TTH 7:30 - 9:50
// Exercise 10.12 - Design and Test Triangle2D Class



package HW4;
import HW4.MyPoint;

public class Exercise_10_12 {
    public static void main(String[]args)
    {
        MyPoint p1 = new MyPoint(0,0);
        MyPoint p2 = new MyPoint(0,1);
        MyPoint p3 = new MyPoint(1,0);
        
        MyPoint q1 = new MyPoint(2,0);
        MyPoint q2 = new MyPoint(2,1);
        MyPoint q3 = new MyPoint(3,0);

        Triangle2D tri = new Triangle2D(p1, p2, p3);
        Triangle2D tri2 = new Triangle2D(q1, q2, q3);

        tri.contains(tri2);
    }
}

class Triangle2D
{
    private MyPoint p1 = new MyPoint();
    private MyPoint p2 = new MyPoint();
    private MyPoint p3 = new MyPoint();

    Triangle2D()
    {
        p1 = new MyPoint(0,0);
        p2 = new MyPoint(1,1);
        p3 = new MyPoint(2,5);
    }
    Triangle2D(MyPoint q1, MyPoint q2, MyPoint q3)
    {
        p1 = q1;
        p2 = q2;
        p3 = q3;
    }
    double getArea()
    {
        // double a = p1.distance(p2);
        // double b = p2.distance(p3);
        // double c = p3.distance(p1);
        // double s = 0.5 * (a + b + c);
        // return Math.sqrt(s*(s-a)*(s-b)*(s-c));

        return (p1.getx()*(p2.gety()-p3.gety()) + 
                p2.getx()*(p3.gety()-p1.gety()) + 
                p3.getx()*(p1.gety()-p2.gety()) ) /2;
    }
    double getPerimeter()
    {
        return p1.distance(p2) + p2.distance(p3) + p3.distance(p1);
    }
    boolean contains(MyPoint p)
    {
        Triangle2D area1 = new Triangle2D(p, p1, p2);
        Triangle2D area2 = new Triangle2D(p, p2, p3);
        Triangle2D area3 = new Triangle2D(p, p1, p3);

        if(area1.getArea()+area2.getArea()+area3.getArea() == getArea())
        {
            return true;
        }
        return false;
    }
    boolean contains(Triangle2D t)
    {
        //427
        // (y1 - y2)x - (x1 - x2)y = (y1 - y2)x1 - (x1 - x2)y1
        // (y3 - y4)x - (x3 - x4)y = (y3 - y4)x3 - (x3 - x4)y3

        // double a = (y1 - y2)
        // double b = (-1)*(x1 - x2);
        // double c = (y3 - y4);
        // double e = (y1 - y2)x1 - (x1 - x2)y1;
        // double d = (-1)*(x3 - x4);
        // double f = (y3 - y4)x3 - (x3 - x4)y3;

        double a = (p1.gety() - p2.gety());
        double b = (-1)*(p1.getx() - p2.getx());
        double c = (t.getp1().gety() - t.getp2().gety());
        double e = (a)*(p1.getx()) + (b)*(p2.getx());
        double d = (-1)*(t.getp1().getx() - t.getp2().getx());
        double f = (c)*t.getp1().getx() - (d)*t.getp2().getx();

        double bisectX = (e*d - b*f)/(a*d - b*c);
        double bisectY = (a*f - e*c)/(a*d - b*c);

        System.out.println("bisectx: " + bisectX +"\nbisecty: " + bisectY);
        return true;
    }
    boolean overlaps(Triangle2D t)
    {
        return false;
    }
    MyPoint getp1()
    {
        return p1;
    }
    MyPoint getp2()
    {
        return p2;
    }
    MyPoint getp3()
    {
        return p3;
    }
}