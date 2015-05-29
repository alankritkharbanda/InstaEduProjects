import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

 class Automobile//superclass with accessor,toString, mutator and data fields
 
 {
int year;
Automobile(int y)
{year=y;}
Automobile()
{year=0;
	}

int getyear() {
	return year;
}
public String toString(){return "Year : "+year;}
void setyear(int x){ year=x;}
	 
 } 
interface onroadvehicle{//interface with abstract methods{
	
	void printtype();
	void printyear();
	
}
//Inheritence
public class Cars extends Automobile implements onroadvehicle//superclass with accessor,toString, mutator and data fields
{
	String name; int year;
	static String manufacturinglocation="Germany";//static field
	Cars(String n,int y)
	{
		this.name=n;
		this.year=y;
		
	}
	Cars(String n)//Method overloading
	{
		name=n;
		year=0;
		
	}
	public String toString(){
		
		
		
		return "Name : "+name+" Year:"+year+" Manufactured at : "+manufacturinglocation;
		
		
	}
	//static method
	static void printmanulocation(){System.out.println("Manufactured at : "+manufacturinglocation);}
	public void printtype() {
		
		System.out.println("Cars");
	}
	public void printyear() 
	{
		System.out.println("Year :"+year);
		
	}
	int getyear(){return year;}//method overriding
	public static void main(String args[])
	{
		Cars c=new Cars("Vento",1999);
		Automobile d=new Cars("Honda City",2001);
		//Aggregation and superclass object reference of subclass type
		System.out.println("1.Print Year\n2.Print Manufacturing Location\n3.Print complete data\n4.Print class Type for Automobile ");
		String str;
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		//Exception handling
		try {
			str=br.readLine();
			int x=Integer.parseInt(str);
			if(x==1)
			{c.printyear();}
			if(x==2)
			{
				printmanulocation();
			}
			if(x==3)
			{
				System.out.println(c.toString());
			}
			if(x==4)
			{
				System.out.println(d.getClass());
			}
			
			
		} catch (IOException e) {
			
			e.printStackTrace();
		}
		
		
	}
	

}
