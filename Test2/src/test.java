import gmat.gma;

import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.io.UnsupportedEncodingException;


public class test {
	
	static String std(int x)
	{if(x/10==0)
		return "00"+x;
	if(x/100==0)
		return "0"+x;
	
	return ""+x;}
public static void main(String args[]) throws FileNotFoundException, UnsupportedEncodingException
{
	PrintWriter writer = new PrintWriter("the-file-name.txt", "UTF-8");
	
	
new gma();
	int i=0;
	for(i=135;i<=900;i++)
	{
		
		writer.println("f2010"+std(i)+"@pilani.bits-pilani.ac.in,");
		writer.println("f2011"+std(i)+"@pilani.bits-pilani.ac.in,");
		writer.println("f2012"+std(i)+"@pilani.bits-pilani.ac.in,");
		writer.println("f2013"+std(i)+"@pilani.bits-pilani.ac.in,");
		writer.println("f2014"+std(i)+"@pilani.bits-pilani.ac.in,");
		
		
		System.out.println(i);
	}
	writer.close();

}}
