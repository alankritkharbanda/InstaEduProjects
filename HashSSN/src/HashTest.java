// File: HashTest.java 

import java.lang.*;
import java.io.*;
import java.util.Scanner;

/**********************************************************************
* This class is a homework assignment #03;
**********************************************************************/
// use HashBag.java; 


/**
 * class HashTest which tests HashBag class and works with Hash tables
 * HW-03, CS3
 * @author (your name) 
 * @version (a version number or a date)
 */
public class HashTest
{
    public static final int H=100;
    public static final int M=10;
  
    public static void main(String[] args) throws IOException{

    	int option;HashBag hb = new HashBag(100);
    	System.out.println("Enter what to do: ");
    	while(true)
    	{
    	System.out.println("1.Hash Table Generated \n2.Read SSN from File\n3. Print the HashTable\n4.Search\n5.Remove\n6.Add\n7.Exit");
    	String str;
    	BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
    	str=br.readLine();
    	option= Integer.parseInt(str);
    
       //******************************************************************
       // (1) Generate a HASH TABLE randomly:
       //******************************************************************
    	
    	
    	
    	switch (option)
    	{
    	
    	case 2:    
       //************************************************************       
       // 2)READ SSN from file:
       //************************************************************

    		Scanner s = new Scanner(new File("DataP.txt"));
    		//int[] array = new int[s.nextInt()];
    		int num=s.nextInt();
    		for (int i = 0; i < num; i++)
    		    hb.put(s.nextLong());
    		break;
    	case 3:    
        
        //***************************************************************
        // 3) Print the HashTable
        //***************************************************************
    	
    	int i=0;
    	for(i=0;i<100;i++)
    	{
    		
    			System.out.println("T["+i+"] "+hb.readData(i));
    		
    	}
    	break;
    	case 4:    
       
        //***************************************************************
        //  4) SEARCH: Let the user ENTER a SSN: A. Search to see if A is in T. 
        //  Print out A and the search result(if A is found or not and index of A if it is found) 
        //***************************************************************
    	{
    	System.out.println("Value to be Searched : ");
    	//String str;
    	//BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
    	str=br.readLine();
    	long key= Long.parseLong(str);
    	int j=0;
    	
    		//System.out.println("Found at "+(key));
    		hb.printgivenvalue(key);
    		
    	
    }
    	break;
    	case 5:    
       
        //****************************************************************************
        //   5)	REMOVE: Let the user enter a SSN: B. Remove B if there is B in T. 
        //      Print out B and the remove result(if B is found and removed or not and index where B is removed) 
        //*****************************************************************************        
    	{System.out.println("Value to be removed : ");
    	//String str;
    	//BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
    	str=br.readLine();
    	long key= Long.parseLong(str);
    	int j=0;
    	if(hb.hasKey(key)==-1)
    	{
    		System.out.println("Key not found");
    	}
    	else
    	{
    		
    		System.out.println("Remove at "+hb.hasKey(key));
    		hb.remove(key);
    	}
    	}
    	break;
    	case 6:    
       
        //****************************************************************************
        //   6) ADD: Let the user enter a SSN: C. Insert/add C to Hash Table/array T.  
        //*****************************************************************************        
    	{System.out.println("Value to be Added : ");
    	//String str;
    	//BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
    	str=br.readLine();
    	long key= Long.parseLong(str);
    	int j=0;
    	int k=hb.put(key);
    	if(k==-1)
    		System.out.println("Sorry, HashBag full");
    	else
    		System.out.println("Inserted at "+k);
    	}
    	break;
    	
    	case 7 : 
    		System.exit(0);
    	break;
    	default : System.out.println("Wrong option, try again");
    	break;
    	
    	}
    	
    
    }
        //***************************************************************
        //  7) Print the HashTable
        //***************************************************************

}
}