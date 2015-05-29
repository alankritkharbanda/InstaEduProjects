import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;


public class MostFrequentWord {

	public static void main(String[] args) {
		String inputFileName, outputFileName;
		int cuttoffCount;
		
		try{
		    inputFileName = args[0];
		    cuttoffCount = Integer.parseInt(args[1]);
		    outputFileName = args[2];
		    
		    //System.out.println(inputFileName);
		    //System.out.println(cuttoffCount);
		    //System.out.println(outputFileName);
		    long startTime = System.nanoTime();
		    FileParser newObject = new FileParser(inputFileName);
		    ArrayList<String> words = newObject.getAllWords();
		    long endTime = System.nanoTime();
			long duration = (endTime - startTime)/1000000 ; 
			System.out.println("INFO: Reading file took " +duration+" ms");
			System.out.println("INFO: "+ words.size()+" words read.");
		    SortedLinkedList<String> SLLString = new SortedLinkedList<String>();
		    BST<String> bst = null;
		    System.out.println("Processing using Recursive BST");
			startTime=System.nanoTime();
			
		//	startTime=System.nanoTime();
			for(String S : words){
			if(bst == null){
		    	    // first time running initialize the binarySearchTree
		    		bst = new BST<String>(S);
		    	}
		    	else{
		    	    bst.insert(S);
		    	}
		    }
			endTime = System.nanoTime();
			
			duration=endTime-startTime;
			System.out.println("INFO: Creating index took "+ duration+" ms ");
			System.out.println("INFO: "+ bst.CountNodes()+" words stored in index.");
			
			startTime=System.nanoTime();
			int x=bst.numnodescutoff(bst.root,cuttoffCount );
			endTime = System.nanoTime();
			duration=endTime-startTime;
			System.out.println("INFO: Pruning index took "+ duration+" ms.");
			System.out.println("INFO: "+x+" words remaining after pruning.");
			
			System.out.println("Processing using Sorted Linked List:");
			startTime=System.nanoTime();
		    for(String S : words){
		    	SLLString.insert(S);}
		    endTime = System.nanoTime();
			duration=endTime-startTime;
			System.out.println("INFO: Creating index took "+ duration+" ms ");
			System.out.println("INFO: "+ SLLString.numnodes()+" words stored in index.");
			startTime=System.nanoTime();
		    int y=SLLString.numnodescutoff(SLLString, cuttoffCount);
		    endTime = System.nanoTime();
			duration=endTime-startTime;
			System.out.println("INFO: Pruning index took "+ duration+" ms.");
			System.out.println("INFO: "+y+" words remaining after pruning.");
			try {
				PrintWriter p = new PrintWriter(new BufferedWriter(new FileWriter(args[2])));
				SLLString.display(p, cuttoffCount);
				p.close();
				
			} catch (IOException e) {
			    //exception handling left as an exercise for the reader
			}
			
		    //System.out.println(SLLString.size);
		    //bst.postorder();
		    //SLLString.display();
		}
		catch(Exception ex){
		    System.out.println(ex.getMessage());
		}
		
	}

}

