import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.Reader;
import java.util.Date;

class A {public A(){System.out.println("This is A");} }
class B extends A{public B(){System.out.println("This is B");}public static void  D(){System.out.println("D");}}
class C{public static void print(){System.out.println("Bolo");}}
interface abc{
	int abc=99;
	void printabc();

}
public class ques4 implements abc {
static int i=5;
int j;
public int geti()
{return i;}

public void seti()
{
i=0;;	
}
public static void main(String args[]) throws IOException
	{		
		String s1="ABC";
		String s2="ABC";
		s2="DEF";
		System.out.println(s1.equals(s2));
	}
public static void aaa(int i)

{
	for(int j=0;j<10;j++)
	while(i!=0)
	{
		System.out.println(i);
		i--;
		if(i==5)
			break;
	}
	System.out.println("POST LOOP");
	return;
}
public void printabc() {
	System.out.println(abc);
	// TODO Auto-generated method stub
	
}
	
}
