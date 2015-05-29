import java.util.ArrayList;
import java.util.StringTokenizer;

// A correct implementation of a producer and consumer. 

class Q { 
int n; String string=testclass.s;int waitnum=1;long t1=System.currentTimeMillis(),t2=System.currentTimeMillis(),t3=System.currentTimeMillis(),t4=System.currentTimeMillis();
public long sumtime=0,sumtime2=0;

String presentstring;
boolean valueSet = false; 
boolean var;
synchronized String get() { 
	t2 = System.currentTimeMillis();
	sumtime+= t2-t1;
	
if(!valueSet) 
try { 
wait(); 
} catch(InterruptedException e) { 
System.out.println("InterruptedException caught"); 
} 
if(presentstring.equals(testclass.laststring))
	var=true;
if("@@@".equals(presentstring))
	System.out.println("Consumer Reads: " + presentstring);
else
System.out.println("Consumer Reads: " + presentstring+ "\n"+"Consumer waits #"+ ++waitnum+"\t"+presentstring+"\t"+var); 
valueSet = false; 
t1 = System.currentTimeMillis();
//sumtime+=(endTime - startTime);
if("@@@".equals(presentstring))
{
	System.out.println("Consumer Summary: " + testclass.s);
	System.out.println("Total wait time: " + sumtime+" milliseconds");
	

}
notify(); 
return presentstring; 
} 
synchronized void put(String string) { 
	boolean prod;t4 = System.currentTimeMillis();
	sumtime2+=t4-t3;
if(valueSet) 
try { 
wait(); 
} catch(InterruptedException e) { 
System.out.println("InterruptedException caught"); 
} 
//this.n = string;
presentstring=string;
valueSet = true; 
System.out.println("Producer writes: " + string);
t3 = System.currentTimeMillis();

if("@@@".equals(string))
{
	System.out.println("Producer Summary: " + testclass.s);
	System.out.println("Total wait time: " + sumtime2 +" milliseconds");
	

}


notify(); 
} 
}

class Producer implements Runnable { 
Q q; 
Producer(Q q) { 
this.q = q; 
new Thread(this, "Producer").start(); 
} 
public void run() { 
	StringTokenizer defaultTokenizer = new StringTokenizer(testclass.s);
	System.out.println("Total number of tokens found : " + defaultTokenizer.countTokens());
	while (defaultTokenizer.hasMoreTokens())
	{
		
		q.put(defaultTokenizer.nextToken());
	}
} 
}

class Consumer implements Runnable { 
Q q; 
Consumer(Q q) { 
this.q = q; 
new Thread(this, "Consumer").start(); 
} 
public void run() { 
while(true) { 
q.get(); 
} 
} 
}

public class testclass { 
	public static String s;
	public static String laststring,ultistring;
public static void main(String args[]) { 
	s="The quick brwon fox jumped @@@";
	int i=0;
	StringTokenizer defaultTokenizer = new StringTokenizer(testclass.s);
	System.out.println("Total number of tokens found : " + defaultTokenizer.countTokens());
	String str[]=new String[100];
	while (defaultTokenizer.hasMoreTokens())
	{
		str[i]=defaultTokenizer.nextToken();
		i++;
		
	}
	laststring=str[i-2];
	ultistring=str[i-1];
	
	
System.out.println("Consumer Wait #1\tNIL\tfalse" );
	Q q = new Q(); 

new Producer(q); 
new Consumer(q); 
} 
}