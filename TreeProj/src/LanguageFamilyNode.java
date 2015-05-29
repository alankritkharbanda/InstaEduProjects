import java.awt.print.Printable;
import java.util.ArrayList;
import java.util.TreeMap;
import java.util.TreeSet;

class LanguagefamilyNode{
	String name;
	//public LanguagefamilyNode treeobj[];
	int numtreeobjects;
	ArrayList <LanguagefamilyNode> treeobj;
	LanguagefamilyNode(String s,int n)
	{	name=s;
		numtreeobjects=n;
		
	}
	int numchildren()
	{return numtreeobjects;}
	void addchildren(LanguagefamilyNode lfn)
	{
		this.treeobj.add(lfn);
		
	}
	String getname()
	{
		return name;
	}
	
	
}

public class LanguageFamilyNode {

	
	static void printAllDescendants(LanguagefamilyNode lfn, int space)
	{
		String spc="";
		for (int i=0;i<space;i++)
			spc=spc+" ";
		if(lfn.numchildren()==0)
			System.out.println(spc+lfn.getname());
		else
		{
			System.out.println(spc+lfn.getname());
			for(int i=0;i<lfn.numchildren();i++)
			printAllDescendants(lfn.treeobj.get(i), space+1);
		}
		
	}
	
	
	public static void main(String args[])
	{
		
		LanguagefamilyNode to= new LanguagefamilyNode("Germanic Languages",3);
		LanguagefamilyNode t1= new LanguagefamilyNode("West Germanic", 3);
		LanguagefamilyNode t2= new LanguagefamilyNode("East Germanic", 1);
		LanguagefamilyNode t3= new LanguagefamilyNode("North Germanic", 3);
		to.addchildren(t1);
		to.addchildren(t2);
		to.addchildren(t3);
		t1.addchildren(new LanguagefamilyNode("German", 0));
		t1.addchildren(new LanguagefamilyNode("English", 0));
		LanguagefamilyNode t11= new LanguagefamilyNode("Low Frankonian" , 2);
		t11.addchildren(new LanguagefamilyNode("Dutch", 0));
		t11.addchildren(new LanguagefamilyNode("Afrikaan", 0));
		t2.addchildren(new LanguagefamilyNode("Gothic", 0));
		t3.addchildren(new LanguagefamilyNode("Norwegian", 0));
		t3.addchildren(new LanguagefamilyNode("Icelandic", 0));
		t3.addchildren(new LanguagefamilyNode("Swedish", 0));
		
		printAllDescendants(to,0);
		
		
		
		
		
		
		
		
		
		
		
		
	}
}
