import java.awt.print.Printable;

import java.util.ArrayList;
import java.util.TreeMap;
import java.util.TreeSet;

class HelperNode{
	String name;
	//public LanguagefamilyNode treeobj[];
	int numtreeobjects;
	ArrayList <HelperNode> treeobj;
	HelperNode(String s,int n)
	{	name=s;
		numtreeobjects=n;
		treeobj= new ArrayList<HelperNode>();
	}
	int numchildren()
	{return numtreeobjects;}
	void addchildren(HelperNode lfn)
	{
		//if(lfn!=null)
		treeobj.add(lfn);
		//System.out.println("Hello, World !");
		
	}
	String getname()
	{
		return name;
	}
	
	
}

public class LanguageFamilyNode {

	
	static void printAllDescendants(HelperNode lfn, int space)
	{
		String spc="";
		for (int i=0;i<space;i++)
			spc=spc+" ";
		//HelperNode obj= new HelperNode(null,0);
		if(lfn.numchildren()==0)
			System.out.println(spc+lfn.getname());
		else
		{
			int i=0;
			System.out.println(spc+lfn.getname());
			for(HelperNode obj : lfn.treeobj)
			{
				
			printAllDescendants(lfn.treeobj.get(i), space+1);
			i++;
			}
			}
		
	}
	
	
	public static void main(String[]args) throws NullPointerException
	{
		/*
		 * This is a list of languages as given in the instruction manual, hard-coded as there was noo readily available tree
		 * One could change the languages and yet obtain the same result.
		 * 
		 * 
		 */
		HelperNode to= new HelperNode("Germanic Languages",3);
		HelperNode t1= new HelperNode("West Germanic", 3);
		HelperNode t2= new HelperNode("East Germanic", 1);
		HelperNode t3= new HelperNode("North Germanic", 3);
		to.addchildren(t1);
		to.addchildren(t2);
		to.addchildren(t3);
		t1.addchildren(new HelperNode("German", 0));
		t1.addchildren(new HelperNode("English", 0));
		HelperNode t11= new HelperNode("Low Frankonian" , 2);
		t11.addchildren(new HelperNode("Dutch", 0));
		t11.addchildren(new HelperNode("Afrikaan", 0));
		t2.addchildren(new HelperNode("Gothic", 0));
		t3.addchildren(new HelperNode("Norwegian", 0));
		t3.addchildren(new HelperNode("Icelandic", 0));
		t3.addchildren(new HelperNode("Swedish", 0));
		
		printAllDescendants(to,0);
		
		
		
	}
}
