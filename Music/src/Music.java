import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;
class Songs implements Comparable<Songs>{
	
	public int length;
	public String name;
	public String artist;
	Songs(int x,String n, String a)
	{
		length=x;name=n;artist=a;
		
	}
	Songs()
	{
		length=0;
		name=null;artist=null;
		
	}
	
	
	public int compareTo(Songs arg0) {
		// TODO Auto-generated method stub
		return this.name.compareTo(arg0.name);
	}
	
	
	
}
public class Music {

	public static Songs s[];static int n;
	public static void readfile() throws IOException
	{
		FileInputStream fis = new FileInputStream("Music.txt");
		 
		//Construct BufferedReader from InputStreamReader
		BufferedReader br = new BufferedReader(new InputStreamReader(fis));

		String line = null;
		line=br.readLine();
		n=Integer.parseInt(line);
		int i=0;
		while ((line = br.readLine()) != null) {
			String []str=line.split( ":");
			s[i]=new Songs(Integer.parseInt(str[0]),str[1],str[2]);
			i++;
		}
		
		br.close();
		
	}
	public static void output()
	{
		for (int i=0;i<n;i++)
		{
			System.out.println(s[i].name+" "+s[i].artist+" "+s[i].length);
			
		}
		
	}
	public static void totaltime()
	{
		int sum=0;
		for (int i=0;i<n;i++)
		{
			sum+=s[i].length;
		}
		System.out.println("Total time : "+sum);
	}
	public static void longestshortest()
	{
		int min=0,max=0;
		for (int i=0;i<n;i++)
		{
			if(s[i].length>s[max].length)
				max=i;
			if(s[i].length<s[max].length)
				min=i;
			
		}
		System.out.println("Longest Song : "+s[max].name+" "+s[max].length);
		System.out.println("Shortest Song : "+s[min].name+" "+s[min].length);
		
		
	}
	public static void output(Music sort)
	{
		for (int i=0;i<n;i++)
		{
			System.out.println(sort.s[i].name+" "+sort.s[i].artist+" "+sort.s[i].length);
			
		}
		
	}
	public static void sortedoutput()
	{
		Songs[] sorted=new Songs[n];
		for(int i=0;i<n;i++)
			sorted[i]=s[i];
		Arrays.sort(sorted);
		//System.out.println()
		output();
		
		
	}
	public static void main(String args[]) throws IOException
	{
	s=new Songs[100];
	
	readfile();
	output();
	totaltime();
	longestshortest();sortedoutput();
	
	}
}
