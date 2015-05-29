package LanguagePredictor;

import java.util.HashMap;
import java.util.Scanner;
import java.io.*;

public class LanguagePredictor{
  
  /**
   * Add comment here
 * @throws FileNotFoundException 
   */
  public static void main(String[] args) throws FileNotFoundException {
	  
    // TODO
	  HashMap<String,Integer> engVocab=new HashMap<String, Integer>();
	  HashMap<String,Integer> freVocab=new HashMap<String, Integer>();
	  engVocab=readVocabulary("eng_vocab.txt");
	  freVocab=readVocabulary("fre_vocab.txt");
	  
	  classifyDocuments(engVocab, freVocab,"docs/test",20);
	  
	  
  }
  
  /**
   * Add comment here
 * @throws FileNotFoundException 
   */
  public static HashMap<String,Integer> readVocabulary(String fileName) throws FileNotFoundException {
    // TODO
	  HashMap<String,Integer> h= new HashMap<String, Integer>();
	  Scanner sc2 =  new Scanner(new File(fileName));
	    try {
	        sc2 = new Scanner(new File(fileName));
	    } catch (FileNotFoundException e) {
	        e.printStackTrace();  
	    }
	    sc2.nextLine();
	    while (sc2.hasNextLine()) {
	            Scanner s2 = new Scanner(sc2.nextLine());
	        boolean b;
	       // s2=s2.next();
	        //String imm=s2.next();
	        //System.out.println("Hello");
	        //String s = s2.next();
	        while (b = s2.hasNext()) {
	        	String s = s2.next();
	            int x=Integer.parseInt(s2.next());
	            //String[] words = instring.replaceAll("[^a-zA-Z ]", "").toLowerCase().split("\\s+");
	             	h.put(s,x);
	             	
	            //System.out.println("Hello");
	        
	        }
	    
	    }
	  
	    
	    
    return h;
  }
  
  /**
   * Add comment here
   */
  public static void classifyDocuments(HashMap<String,Integer> engVocab, HashMap<String,Integer> freVocab, 
                                       String directory, int nFiles) {
	  
	  for(int i=1;i<=nFiles;i++)
	  {
		  int engcount=0,frecount=0;
		  Scanner sc2 = null;
		    try {
		        sc2 = new Scanner(new File(directory+"/"+i+".txt"));
		    } catch (FileNotFoundException e) {
		        e.printStackTrace();  
		    }
		    while (sc2.hasNextLine()) {
		            Scanner s2 = new Scanner(sc2.nextLine());
		        boolean b;
		        while (b = s2.hasNext()) {
		            String s = s2.next().replaceAll("[^a-zA-Z ]", "").toLowerCase();
		            //String[] words = instring.replaceAll("[^a-zA-Z ]", "").toLowerCase().split("\\s+");
		            if(engVocab.containsKey(s))
		            {
		            	engcount++;
		            }
		            if(freVocab.containsKey(s))
		            {
		            	frecount++;
		            }
		            	
		        }
		    }
		    
		    String decision=null;
		    if(engcount>frecount)
		    	decision="English";
		    if(engcount<frecount)
		    	decision="French";
		    if(engcount==frecount)
		    	decision="NA";
		    
		    System.out.println(i+". English :"+engcount+" French : "+frecount+" Decision : "+decision);
			    
			    
		    
		  
		  
		  
	  }
    // TODO
  }
  
  /*****************************************************************************
   Put the output of classifyDocuments here, and a sentence to describe whether
   your program worked.
   
   
   
   
   
   
   
   
   
   

   *****************************************************************************/
}