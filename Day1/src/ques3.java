import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;


public class ques3 {

	public static void main(String args[]) throws IOException
	{
		int x;
		BufferedReader br= new BufferedReader(new InputStreamReader(System.in));
		String str=br.readLine();
		x=Integer.parseInt(str);
		
		int i=2;int flag=0;
		for(i=2;i<=x/2;i++)
		{
			if(x%i==0)
			{
				flag=1;
				break;
			}
		}
		
		if (flag==0)
			System.out.println("Prime");
		else
			System.out.println("Composite");
		
	}
	
}
