import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;


public class ThreadsDemo {

	String name; int age;
	public ThreadsDemo(String name, int age){
		
		this.name=name;
		this.age=age;
		
		
	}
	public static void main(String args[]) throws IOException 
	{
		
		System.out.println("Enter Name, Age");
		String name; int age;
		
		BufferedReader br= new BufferedReader(new InputStreamReader(System.in));
		name= br.readLine();
		String str=br.readLine();
		age=Integer.parseInt(str);
		Thread2 td=new Thread2(name,age);
		//System.out.println("Main");
		Thread t=new Thread(td,"alankrit");
		int i=100;
		t.start();
		while(i>0)
			System.out.println("Main");
		
		
		
	}
	
	/*public void run()
	{
	//	Thread tt=Thread.currentThread();
		
		//if(age>0)
		//System.out.println("Thread is "+tt.getName()+"  age is   "+age);
		
//	}
	
	
}*/}
class Thread2 implements Runnable{
	
	
	String name; int age;
	public Thread2(String name, int age){
		
		this.name=name;
		this.age=age;
		//run();
	}
		public void run()
		{			
			int i=10;
			while(i>0)
				System.out.println("alankrit");		
		}
}	
	
