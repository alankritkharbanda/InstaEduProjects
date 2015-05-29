import java.io.*;


public class Test {
	static String std(int x)
	{
		if(x/10==0)
			return "00"+x;
		if(x/100==0)
			return "0"+x;
		
		return ""+x;
		
		
	}
	public static void main(String args[])
	{
		int i=0;
		for(i=1;i<=900;i++)
		{
			
			System.out.println("f2010"+std(i)+"@pilani.bits-pilani.ac.in");
			System.out.println("f2011"+std(i)+"@pilani.bits-pilani.ac.in");
			System.out.println("f2012"+std(i)+"@pilani.bits-pilani.ac.in");
			System.out.println("f2013"+std(i)+"@pilani.bits-pilani.ac.in");
			System.out.println("f2014"+std(i)+"@pilani.bits-pilani.ac.in");
			System.out.println("h2014"+std(i)+"@pilani.bits-pilani.ac.in");
			System.out.println("h2013"+std(i)+"@pilani.bits-pilani.ac.in");
			
			
		}
		
		
	}
}
