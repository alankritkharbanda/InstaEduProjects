package curltest;

import java.io.*;
import java.io.InputStreamReader;

import java.util.StringTokenizer;


public class Curltester {

	public static boolean checkipv4(String str)
	{
		
		//System.out.println(str);
		try{int t=Integer.parseInt(str);
		if(t>=0 && t<256)
		{	
			
			return true;
			
		}
			return false;
		
		}
		catch(Exception e){return false;}
		
	}
	private static boolean isNumeric(String cadena) {
	    if ( cadena.length() == 0 || 
	         (cadena.charAt(0) != '-' && Character.digit(cadena.charAt(0), 16) == -1))
	        return false;
	    if ( cadena.length() == 1 && cadena.charAt(0) == '-' )
	        return false;

	    for ( int i = 1 ; i < cadena.length() ; i++ )
	        if ( Character.digit(cadena.charAt(i), 16) == -1 )
	            return false;
	    return true;
	}
	public static boolean checkipv6(String str)
	{
		
			return isNumeric(str);
		
		
	}
	public static void main(String args[]) throws Exception
	{	
			BufferedReader br= new BufferedReader(new InputStreamReader(System.in));
			String str=br.readLine();
			
			int t=Integer.parseInt(str);
			while(t!=0)
			{
				str=br.readLine();
				boolean isipv4=true,isipv6=true;
				if(str.length()>15)
					isipv4=false;
			
		  StringTokenizer st = new StringTokenizer(str,".");  
		     while (isipv4 && st.hasMoreTokens()) {  
		    	 
		           isipv4=checkipv4(st.nextToken());
		           
		     }  
		     //System.out.println(isipv4);
		     if(str.length()!=39)
		    	 isipv6=false;
		     st = new StringTokenizer(str,":");  
		     while (isipv6 && st.hasMoreTokens()) {  
		    	 
		           isipv6=checkipv6(st.nextToken());
		     }  
		     if(isipv4)
		     {
		    	 System.out.println("IPv4");
		    	 break;
		     }
		     if(isipv6)
		     {
		    	 System.out.println("IPv6");
		    	 break;
		     }
		     System.out.println("Neither"); 
			
			t--;
			}
	}
}
