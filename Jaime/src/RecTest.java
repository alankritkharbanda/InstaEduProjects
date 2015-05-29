import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;


public class RecTest {

	static void rec(int n)
	{
		if(n>0)
		{
			int rem=n%2;
			rec(n/2);
			System.out.print(rem);
			
		}
		
	}
	
	public static void main(String args[]) throws IOException
	{
		int n;
		String str;
		BufferedReader br= new BufferedReader(new InputStreamReader(System.in));
		System.out.println("Enter the number");
		str=br.readLine();
		n=Integer.parseInt(str);
		rec(n);
		System.out.println(" ");
		
		
	}
	
	
}
