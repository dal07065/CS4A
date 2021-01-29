// Lina Kang
// 1072568
// CS4A TTH 7:30 - 9:50
// Exercise 10.12 - Design and Test MyPoint Class

/*

    I could not get these to fully work in time...
    - contains(Triangle2D t)
    - overlaps(Triangled2D t)

*/

public class Exercise_10_12 {
	public static void main(String[] args) {
		MyPoint p1 = new MyPoint(2.5, 2);
		MyPoint p2 = new MyPoint(4.2, 3);
		MyPoint p3 = new MyPoint(5, 3.5);

        Triangle2D t1 = new Triangle2D(p1,p2,p3);

        System.out.println("Created a new triangle: \"t1\"\n");

        System.out.println("Checking if the triangle contains (3,3)...\n");

        if(t1.contains(3,3))
            System.out.println("Yes, it does contain the point");
        else
            System.out.println("No, it does NOT contain the point");

        // t1.contains(new Triangle2D(new MyPoint(2.9, 2), new MyPoint(4, 1), MyPoint(1, 3.4)));
        // t1.overlaps(new Triangle2D(new MyPoint(2, 5.5), new MyPoint(4,-3), MyPoint(2, 6.5)));
			
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
class Triangle2D {
	private MyPoint p1 = new MyPoint();
	private MyPoint p2 = new MyPoint();
	private MyPoint p3 = new MyPoint();

	Triangle2D() {
		p1 = new MyPoint(0, 0);
		p2 = new MyPoint(1, 1);
		p3 = new MyPoint(2, 5);
	}

	Triangle2D(MyPoint q1, MyPoint q2, MyPoint q3) {
		p1 = q1;
		p2 = q2;
		p3 = q3;
	}

	double getArea() {
		// double a = p1.distance(p2);
		// double b = p2.distance(p3);
		// double c = p3.distance(p1);
		// double s = 0.5 * (a + b + c);
		// return Math.sqrt(s*(s-a)*(s-b)*(s-c));

		return (p1.getx() * (p2.gety() - p3.gety()) + p2.getx() * (p3.gety() - p1.gety())
				+ p3.getx() * (p1.gety() - p2.gety())) / 2;
	}

	double getPerimeter() {
		return p1.distance(p2) + p2.distance(p3) + p3.distance(p1);
	}

	boolean contains(MyPoint p) {
		Triangle2D area1 = new Triangle2D(p, p1, p2);
		Triangle2D area2 = new Triangle2D(p, p2, p3);
		Triangle2D area3 = new Triangle2D(p, p1, p3);

		if (area1.getArea() + area2.getArea() + area3.getArea() == getArea()) {
			return true;
		}
		return false;
	}
	boolean contains(double x, double y) {
        MyPoint p = new MyPoint(x,y);
		Triangle2D area1 = new Triangle2D(p, p1, p2);
		Triangle2D area2 = new Triangle2D(p, p2, p3);
		Triangle2D area3 = new Triangle2D(p, p1, p3);

		if (area1.getArea() + area2.getArea() + area3.getArea() == getArea()) {
			return true;
		}
		return false;
	}
	boolean contains(Triangle2D t) {
		// double a,b,c,d,e,f,bisectX, bisectY;

		if (check(p1, p2, t.getp1(), t.getp2()) || 
			check(p2, p3, t.getp1(), t.getp2())	|| 
			check(p1, p3, t.getp1(), t.getp2()))
			return true;

		if (check(p1, p2, t.getp2(), t.getp3()) || 
			check(p2, p3, t.getp2(), t.getp3()) || 
			check(p1, p3, t.getp2(), t.getp3()))
			return true;

		if (check(p1, p2, t.getp3(), t.getp1()) || check(p2, p3, t.getp3(), t.getp1())
				|| check(p1, p3, t.getp3(), t.getp1()))
			return true;

		return false;

		// 427
		// (y1 - y2)x - (x1 - x2)y = (y1 - y2)x1 - (x1 - x2)y1
		// (y3 - y4)x - (x3 - x4)y = (y3 - y4)x3 - (x3 - x4)y3

		// double a = (y1 - y2)
		// double b = (-1)*(x1 - x2);
		// double c = (y3 - y4);
		// double e = (y1 - y2)x1 - (x1 - x2)y1;
		// double d = (-1)*(x3 - x4);
		// double f = (y3 - y4)x3 - (x3 - x4)y3;

		// --------------------- START of q1 and q2 check --------------------//

		// checks for line p2-p3 bisecting q1 and q2

		/*
		 * a = (p2.gety() - p3.gety()); b = (-1)*(p2.getx() - p3.getx()); c =
		 * (t.getp1().gety() - t.getp2().gety()); e = (a)*(p2.getx()) +
		 * (b)*(p3.getx()); d = (-1)*(t.getp1().getx() - t.getp2().getx()); f =
		 * (c)*t.getp1().getx() - (d)*t.getp2().getx();
		 * 
		 * bisectX = (e*d - b*f)/(a*d - b*c); bisectY = (a*f - e*c)/(a*d - b*c);
		 * 
		 * if(!Double.isNaN(bisectX) && !Double.isInfinite(bisectY)) return
		 * true;
		 * 
		 * // checks for line p1-p2 bisecting q1 and q2
		 * 
		 * a = (p1.gety() - p2.gety()); b = (-1)*(p1.getx() - p2.getx()); c =
		 * (t.getp1().gety() - t.getp2().gety()); d = (-1)*(t.getp1().getx() -
		 * t.getp2().getx()); e = (a)*(p1.getx()) + (b)*(p2.getx()); f =
		 * (c)*t.getp1().getx() - (d)*t.getp2().getx();
		 * 
		 * bisectX = (e*d - b*f)/(a*d - b*c); bisectY = (a*f - e*c)/(a*d - b*c);
		 * 
		 * if(!Double.isNaN(bisectX) && !Double.isInfinite(bisectY)) return
		 * true;
		 * 
		 * // checks for line p1-p3 bisecting q1 and q2
		 * 
		 * a = (p1.gety() - p3.gety()); b = (-1)*(p1.getx() - p3.getx()); c =
		 * (t.getp1().gety() - t.getp2().gety()); e = (a)*(p1.getx()) +
		 * (b)*(p3.getx()); d = (-1)*(t.getp1().getx() - t.getp2().getx()); f =
		 * (c)*t.getp1().getx() - (d)*t.getp2().getx();
		 * 
		 * bisectX = (e*d - b*f)/(a*d - b*c); bisectY = (a*f - e*c)/(a*d - b*c);
		 * 
		 * if(!Double.isNaN(bisectX) && !Double.isInfinite(bisectY)) return
		 * true;
		 */

		// --------------------- END of q1 and q2 check --------------------//

		// return false;
	}

	//					  x1y1         x2,y2,      x4,y4        x4,y4
	boolean check(MyPoint pt1, MyPoint pt2, MyPoint pt3, MyPoint pt4) {

		double a, b, c, d, e, f, x, y;
		
//		double x1 = pt1.getx();
		
//		a = (pt1.gety() - pt2.gety());
//		b = (-1) * (pt1.getx() - pt2.getx());
//		c = (pt3.gety() - pt4.gety());
//		d = (-1) * (pt3.getx() - pt4.getx());
//		e = (pt1.gety() - pt2.gety()) * pt1.getx() - (pt1.getx() - pt2.getx()) * pt1.gety();
//		f = (pt3.gety() - pt4.gety()) * pt3.getx() - (pt3.getx() - pt4.getx()) * pt3.gety();
//
//		bisectX = (e * d - b * f) / (a * d - b * c);
//		bisectY = (a * f - e * c) / (a * d - b * c);

//		a = pt1.gety() - pt2.gety();
//		b = pt1.getx() - pt2.getx();
//		c = pt3.gety() - pt4.gety();
//		d = pt3.getx() - pt4.getx();
//		
//
//		if(a != 0 && (d - (c*b)/a) != 0)
//		{
//			y = ((c*pt1.getx()) - (((c*b)/a)*pt1.gety()) - (c*pt3.getx()) + (d*pt3.gety()))/(d-((c*b)/a));
//			x = (b/a)*y + pt1.getx() - ((b/a)*pt1.gety());
//		}
//		else
//		{
//			return false;
//		}
		
//		if (!Double.isNaN(x) && !Double.isInfinite(y))
//			return true;
		return false;
		// --------------------- END of q1 and q2 check --------------------//
	}

	boolean overlaps(Triangle2D t) {
		return false;
	}

	MyPoint getp1() {
		return p1;
	}

	MyPoint getp2() {
		return p2;
	}

	MyPoint getp3() {
		return p3;
	}
}
