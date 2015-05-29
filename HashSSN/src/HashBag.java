
import java.lang.*;
import java.io.*;

/**
 * class HashBag: use open-address Hashing.
 * HW-03, CS3
 */
public class HashBag
{
    // instance variables 
    private final int M=100;
    private long[] t = new long[M];
    private boolean[] w = new boolean[M]; // true means there used to be an element at t[i]
    private int size;
  
    /**
     * Constructor for class HashBag
     * @param  integer "N" 
     * @return a Hash table with size N
     */
    public HashBag(int N)
    {
        // also initialize w[] to False, meaning nothing was there
        // put your code here
    	int i=0;
    	for(i=0;i<M;i++)
    		{w[i]=false;t[i]=0;}
    }


   /**
     * method hashValue: calculate Hash value of an element key
     * @param  key,   a SSN
     * @return the Hash value = HashFunction(key)
     */ 
    private int hashValue(long key)
    {
    	int hashedkey=(int) (key%100);
    	int i=0;int newkey=(int) (key%100);
    	
    	if(t[newkey]==0)
    	{

    		return newkey;	
    	}
    	else
    	{	newkey++;
    		int calkey=newkey%100;
    		while(t[newkey%100]!=0)
    			{newkey++;
    			if(newkey%100==hashedkey) {System.out.println("BBB");return -1;}
    			}
    		return newkey%100;
    	}
        // put your code here (define your Hash function here)
		//return newkey;

    }

   /**
     * method readData: get/read the element content of a Hash Table
     * @param  "i" is the Hash value (index)
     * @return the content of "i" index or the Data whose Hash value = i
     */     
    public long readData (int i)
    {
    	
		return  t[i];
        // put your code here

    }
    
    public void printgivenvalue(long key)
    {
    	int hkey=(int) (key%100);
    	int flag=0;
    	
    	int store=hkey;
    	if(t[hkey%100]==key)
		{System.out.println("Found at "+hkey%100);flag=1;return;}
    	
    	hkey++;
    	while(hkey%100!=store)
    	{
    		if(t[hkey%100]==key)
    		{System.out.println("Found at "+hkey%100);flag=1;}
        	
    		hkey++;
    	}
    	if(flag==0)
    		System.out.println("Not found.");
    	//return hkey;
    }

    /**
     *  method PUT: add a new element "key" to this HashBag
     * @param  "key",   a SSN, value of the new element to be added 
     * @return -1 (if can't add, i.e. full) or index "i" where key is placed (if added)
     */     
    public int put(long key)
    {
    	int i=0;int hashedkey=hashValue(key);
    	//System.out.println("Hashed Key is : "+t[hashedkey]);
    	t[hashedkey]=key;
    	w[hashedkey]=true;
    	//System.out.println("Hashed Key is : "+ t[hashedkey]);
		return hashedkey;
		
        // put your code here
     
    }
    
    /**
     *  method hasKey: search for an element key in this HashBag
     * @param  key,   a SSN, value of the element to search for 
     * @return -1 (if not found) or index i where key is placed (if found)
     */     
    public int hasKey (long key)
    {
    	int hkey=(int) (key%100);
    	int flag=0;
    	
    	int store=hkey;
    	if(t[hkey%100]==key)
		{//System.out.println("Found at "+hkey%100);
		flag=1;return hkey%100;}
    	
    	hkey++;
    	while(hkey%100!=store)
    	{
    		if(t[hkey%100]==key)
    		{//System.out.println("Found at "+hkey%100);
    			flag=1;
    			return hkey%100;}
    		
        	
    		hkey++;
    	}
    	//if(flag==0)
    		//System.out.println("Not found.");
    	return -1;
         // put your code here
      }
    
    /**
     *  method remove: delete an element key in this HashBag
     * @param  key,   a SSN, value of the element to be removed
     * @return -1 (if not deleted or not found) or index i where key was deleted (if found)
     */     
    public int remove(long key)
    {
    	int foundkey=hasKey(key);
    	if(foundkey==-1)
		return -1;
    	t[foundkey]=0;
    	w[foundkey]=false;
    	return foundkey;
        // put your code here

    }   
}
