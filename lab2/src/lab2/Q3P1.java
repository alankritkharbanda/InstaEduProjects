package lab2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.Set;

public class Q3P1 {
	public static void main(String args[]) throws IOException
	{
		Set S=new HashSet();
		//S.add("A");
		BufferedReader br= new BufferedReader(new InputStreamReader(System.in));
		//while(strcmp(str))
		int x;
		
		while(true)
		{System.out.println("1.Enter\n2.Search\n3.Exit");
		String str= br.readLine();
		x=Integer.parseInt(str);
		if(x==1)
		{
			str= br.readLine();
			S.add(str);
		}
		if(x==2)
		{
			str= br.readLine();
			if(S.contains(str))
				System.out.println("Yes");
			else
				System.out.println("no");
		}
		if(x==3)
		{
			break;
		}
		
		
		}
			
		
		
	}

}
