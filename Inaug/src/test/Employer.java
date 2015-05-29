package test;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Scanner;

class employee {
	int id, salary;
	String name;
	void gem()
	{
		int id;
		id=1;
		this.id=2;
		System.out.println(id);
		System.out.println(this.id);
		
	}
	
	
}
public class Employer {
	
	
	public Employer(){
		
		
	}
	public static void doWork(String  s){
		
		
		System.out.println("Employee busy !" +  s);
	}
	
	
	
	public static void main (String args[]) throws IOException
	{
		System.out.print("Enter Your name Mortal !");
		String str;
		Scanner scanner = new Scanner(System.in);
		int x=scanner.nextInt();
		//BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		//str=br.readLine();
		//doWork(str);
		System.out.println(x);
		
		
		
	}
	
}
