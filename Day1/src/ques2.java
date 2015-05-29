import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;


public class ques2 {

	 static float determineprice(String str)
	{
		 float f=(float) 22.5;
		 
		if(str.compareToIgnoreCase("A")==0||str.compareToIgnoreCase("1")==0)
			return f;
		if(str.compareToIgnoreCase("B")==0||str.compareToIgnoreCase("2")==0)
			return (float) 44.5;
		if(str.compareToIgnoreCase("c")==0||str.compareToIgnoreCase("3")==0)
			return (float) 9.98;
		
		return -1;
		
	}
	
	public static void main(String args[]) throws IOException
	{
		String str;
		BufferedReader br= new BufferedReader(new InputStreamReader(System.in));
		str=br.readLine();
		int pdtno;String pdtcode;float price;
		float total=0;
		price= determineprice(str);
		if(price!=-1)
		{
			System.out.println("Net Quantity ?");
			str=br.readLine();
			int q= Integer.parseInt(str);
			System.out.print("Net amount is "+q*price);
			
		}
		else
		{
			System.out.println("Bhag");
			
		}
		
		
	}
	
}
