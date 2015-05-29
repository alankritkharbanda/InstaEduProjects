import java.io.BufferedReader;
import java.io.DataInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Scanner;

class SortedLinkedList{
	String word;
	int count;
	SortedLinkedList next;
	String getword(){return word;}
	public SortedLinkedList(String w) {
		word=w;
		count=1;next=null;
		// TODO Auto-generated constructor stub
	}
	SortedLinkedList insert(SortedLinkedList sll,String w)//insert into linkedlist
	{	
		 if(sll.word.compareTo(w)==0)
    	 {
    		 sll.count++;
    		 return sll;
    		 
    	 }
    	 
	     if(sll==null)
	    	 return new SortedLinkedList(w);
	     else
	     {
	    	 if(sll.word.compareTo(w)>0)
	    	 {
	    		 SortedLinkedList sll2=new SortedLinkedList(w);
	    		 sll2.next=sll;
	    		 return sll2;
	    		 
	    	 }
	    	 else
	    	 {
	    		 if(sll.next==null)
	    		 {
	    			 SortedLinkedList sll2=new SortedLinkedList(w);
		    		 sll.next=sll2;
		    		 return sll;
	    			 
	    		 }
	    		 else
	    		 {
	    			 if(sll.next.word.compareTo(w)>0)
	    			 {
	    			 SortedLinkedList sll2=new SortedLinkedList(w);
		    		 sll2.next=sll.next;
		    		 sll.next=sll2;
		    		 return sll;
	    			 }
	    			 else
	    			 {
	    				 sll.next=insert(sll.next,w);
	    				 return sll;
	    				 
	    			 }
	    			 
	    		 }
	    		 
	    		 
	    	 }
	    	
	    	 
	    	 
	     }
		
	}
	void print(SortedLinkedList sll)
	{
		if(sll==null)
			return;
		System.out.println(sll.count);
		print(sll.next);
		
	}
	int numnodes(SortedLinkedList sll)//calculate unique words
	{
		if(sll==null)
			return 0;
		return 1+numnodes(sll.next);
	}
	public int pruner(SortedLinkedList sll,int wordcount) {//check words fitting wordcount
		// TODO Auto-generated method stub
		SortedLinkedList sll2=sll;
		int a=0;
		while(sll2!=null)
		{
			if(sll2.count>=wordcount)
				a++;
			sll2=sll2.next;
			
		}
		
		return a;
	}
	
}
class BST{
	String word;
	int count;
	BST left;
	BST right;static int i=0,j=0;
	BST(String w)//, BST l, BST, r)
	{
		word=w;count=1;
		left=right=null;
	}
	void insert(BST bst,String s)
	{	if(s==null)
		return ;
	
		
		
			if(bst.word.equals(s))
				{
				count++;return ;}
			if(bst.word.compareTo(s)<0)
			{
				if(bst.right==null)
					{
					bst.right=new BST(s);
					return ;}
				else
					{
					insert(bst.right,s);
					return ;
					
					}
			}
			if(bst.word.compareTo(s)>0)
			{
				if(bst.left==null)
					{bst.left=new BST(s);return ;}
				else
					{insert(bst.left,s);return ;}
			}
			
			
		

	}
	int numnodes(BST bst)
	{
		if(bst==null)
			return 0;
		return 1+numnodes(bst.left)+numnodes(bst.right);
		
	}
	void print(BST bst)
	{
		if(bst==null)
			return;
		print(bst.left);
		System.out.println(word+ " "+ count);
		print(bst.right);
		
		
	}
	public int pruner(BST bst,int wordcount) {//calculate words fitting wordcount
		// TODO Auto-generated method stub
		if(bst==null)
			return 0;
		if(bst.count>wordcount)
		return 1+numnodes(bst.left)+numnodes(bst.right);
		else
			return numnodes(bst.left)+numnodes(bst.right);
	}
}

public class MostFrequentWord{
	
	static ArrayList<String> list;
	static BST bst;
	static SortedLinkedList sll;
	int readarraylist(String filename) throws FileNotFoundException//reads from file
	{
		
		Scanner s = new Scanner(new File(filename));
		list = new ArrayList<String>();
		while (s.hasNext()){
		    
			list.add(s.next());
		}
		bst=new BST(list.get(0));
		sll=new SortedLinkedList(list.get(0));
		//System.out.print("hello :"+sll.getword());
		s.close();
		return list.size();
	}
	
	int wordsbst()//populatesbst with words
	{
		for(int i=1;i<list.size();i++)
		{
			
			if(list.get(i)!=null)
			bst.insert(bst,list.get(i));
			
		}
		//System.out.println(list.size());
		return 0;
		
		
	}
	int numnodesbst(BST bst)
	{
		return bst.numnodes(bst);
	}
	static int numnodesll()
	{
		return sll.numnodes(sll);
	}
	int wordslinkedlist()//populates linkedlist with words
	{	int i;
		for( i=1;i<list.size();i++)
		{
			if(list.get(i)!=null)
			sll=sll.insert(sll,list.get(i));
			
		}
		//System.out.println("Read words upto : "+i);
		return 0;
		
	}
	public static void main(String args[]) throws IOException
	{int wordcount=100;
		long startTime = System.nanoTime();
		if (args.length > 0) {
		    try {
		    	 wordcount=Integer.parseInt(args[1]);
		    } catch (NumberFormatException e) {
		        System.err.println("Argument" + args[0] + " must be an integer.");
		        System.exit(1);
		    }
		}
		
		
		PrintWriter writer = new PrintWriter(args[2], "UTF-8");
		//System.out.println(wordcount);
		MostFrequentWord mfw=new MostFrequentWord();
		mfw.readarraylist(args[0]);
		long endTime = System.nanoTime();
		long duration = (endTime - startTime)/1000000 ; 
		writer.println("INFO: Reading file took " +duration+" ms");
		writer.println("INFO: "+ list.size()+" words read.");
		 
		writer.println("Processing using Sorted Linked List:");
		startTime=System.nanoTime();
		mfw.wordslinkedlist();
		endTime = System.nanoTime();
		duration = (endTime - startTime)/1000000 ; 
		writer.println("INFO: Creating index took "+ duration+" ms.");
		writer.println("INFO: "+ sll.numnodes(sll)+" words stored in index.");
		
		startTime=System.nanoTime();
		int x=sll.pruner(sll,wordcount);
		endTime = System.nanoTime();
		duration = (endTime - startTime)/100000 ; 
		writer.println("INFO: Pruning index took "+duration +" ms.");	

		writer.println("INFO: "+x +" words remaining after pruning.");
		
		writer.println("Processing using Recursive BST");
		startTime=System.nanoTime();
		mfw.wordsbst();
		endTime = System.nanoTime();
		duration=endTime-startTime;
		writer.println("INFO: Creating index took "+ duration+" ms ");
		writer.println("INFO: "+bst.numnodes(bst)+" words stored in index.");
		startTime=System.nanoTime();
		int y=bst.pruner(bst, wordcount);
		endTime = System.nanoTime();
		duration=endTime-startTime;
		writer.println("INFO: Pruning index took "+ duration+" ms.");
		writer.println("INFO: "+x +" words remaining after pruning.");
		writer.close();
		
			
		
		
	
	}
	
}


