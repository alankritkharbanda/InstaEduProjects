package languages;

import java.util.*;
import java.io.*;

public class LanguageLearner{
  /**
   * Add comment here
 * @throws IOException 
   */
  public static void main(String[] args) throws IOException {
    // TODO
	  HashMap<String, Integer> engmap= new HashMap<String, Integer>();
	  HashMap<String, Integer> fremap= new HashMap<String, Integer>();
	  engmap=countWords("docs/train/eng", 20);
	  fremap=countWords("docs/train/fre", 20);
	  writeVocabulary(engmap, "eng_vocab.txt");
	  writeVocabulary(fremap, "fre_vocab.txt");
	  
	  
  }
  
  /**
   * Add comment here
   */
  public static HashMap<String, Integer> countWords(String directory, int nFiles) {
	  
	  // TODO
	  int i=0;
	  HashMap<String, Integer> h= new HashMap<String, Integer>();
	  for(i=1;i<=nFiles;i++)
	  {
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
		            if(h.containsKey(s))
		            {
		            	h.put(s, h.get(s)+1);
		            }
		            else
		            	h.put(s,1);
		        }
		    }
		  
		  
	  }
	  
	  
    return h;
  }
  
  /**
   * Add comment here
 * @throws IOException 
   */
  public static void writeVocabulary(HashMap<String, Integer> vocab, String fileName) throws IOException {
    // TODO
	  File file = new File(fileName);
	  FileWriter fw = new FileWriter(file.getAbsoluteFile());
		BufferedWriter bw = new BufferedWriter(fw);
		
		
	  for (String key : vocab.keySet()) {
		  if(key!=null && key!=" ")
	        {bw.append(key + " " + vocab.get(key));
	        //System.out.println(key);
	        bw.append(System.getProperty("line.separator"));
	        }
	        //System.out.println(vocab.get(key));
	        
	    }
	  bw.close();
	 
  }
  
  
}