import java.util.*;
class Point{
	int x;int y;
	Point(int a,int b)
	{
		x=a;
		y=b;
		
	}
	Point()
	{
		x=y=0;
		
	}
	void printPoint()
	{
		System.out.println("Point is :"+ x+","+y);
		
	}
	void setPoint(int a,int b)
	{
		x=a;y=b;
		
	}
	int getx()
	{return x;}

	int gety()
	{return y;}
	void makeCopy(Point p)
	{
		this.x=p.getx();
		this.y=p.gety();
	}
}

public class driver {
public static void main(String[] args) {
Point myPoint = new Point(5, 4);
Point yourPoint = new Point();
myPoint.printPoint();
yourPoint.setPoint(5, 45);
/*
 if you wish to input the point from the user, remove the line just above this one and take input from the user regarding
 the X and Y coordinates of the point 
 */
yourPoint.printPoint();
if (myPoint.equals(yourPoint))
System.out.println("Both times " + "are equal.");
else
System.out.println("The two points " + "are not equal");
yourPoint.makeCopy(myPoint);
System.out.print("After copying " + "myPoint: into yourPoint; \n"
+ "yourPoint: ");
yourPoint.printPoint();
}
}