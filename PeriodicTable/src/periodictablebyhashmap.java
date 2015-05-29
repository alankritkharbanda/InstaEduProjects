import java.awt.BufferCapabilities;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;


public class periodictablebyhashmap {

	static HashMap<String,Element> elementlistbysymbol=new HashMap<String,Element>();
	static HashMap<String,Element> elementlistbyname=new HashMap<String,Element>();
	static Element elementlist[]=new Element[113];
	public periodictablebyhashmap() 
		// TODO Auto-generated constructor s()
	{
		
		elementlist[0]=  new Element("Hydrogen", 1, "H", 1.00794, 1, 1);
		elementlist[1]=new Element("Helium", 2, "He", 4.00260, 1, 18);
		elementlist[2]=new Element("Lithium", 3, "Li", 6.00260, 2, 1);
		elementlist[3]=new Element("Berillium", 4, "Be", 8.00260, 2, 2);
		elementlist[4]=new Element("Boron", 5, "B", 10, 2, 13);
		elementlist[5]=new Element("Carbon", 6, "C", 12.00260, 2, 14);
		elementlist[6]=new Element("Nitrogen",7, "N", 14.00260, 2, 15);
		elementlist[7]=new Element("Oxygen", 8, "O", 16.00260, 2, 16);
		elementlist[8]=new Element("Flourine", 9, "F", 18.00260, 2, 17);
		elementlist[9]=new Element("Neon", 10, "Ne", 20.00260, 2, 18);
		elementlist[10]=new Element("Sodium", 11, "Na", 22.00260, 3, 1);
		elementlist[11]=new Element("Magnesium", 12, "Mg", 24.00260, 3, 2);
		
		elementlist[111]=new Element(null, 112, null, 250.00260, 2, 12);
		elementlist[112]=new Element(null, 114, null, 255.00260, 2, 14);
		
		
		
		for(int i=12;i<111;i++)
			elementlist[i]=new Element();
		
		for(int i=0;i<113;i++)
		{
			elementlistbyname.put(elementlist[i].getName(), elementlist[i]);
			
			
		}
		for(int i=0;i<113;i++)
		{
			elementlistbysymbol.put(elementlist[i].getSymbol(), elementlist[i]);
			
		}
		
	}
	void searchbyname(String name)
	{
		
		if(elementlistbyname.containsKey(name))
		{
			System.out.println(elementlistbyname.get(name).toString());
			return;
		}
		System.out.println("Sorry, Element Not found.");
	}
	void searchbysymbol(String symbol)
	{
		if(elementlistbysymbol.containsKey(symbol))
		{
			System.out.println(elementlistbysymbol.get(symbol).toString());
			return;
		}
		System.out.println("Sorry, Element Not found.");
	}
	public static void main(String args[]) throws IOException
	{
		periodictablebyhashmap p=new periodictablebyhashmap();
		//System.out.println(elementlistbyname);
		int x=0;
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		
	
		
		while(x!=3)
			{	System.out.println("Warning : Enter element Name or symbol with 1st letter capital\n"
					+ "1.Search by name.\n2.Search by Symbol\n3.Quit");
				String str=br.readLine();
				
				x=Integer.parseInt(str);
				if(x==1)
				{
					System.out.println("enter name");
					str=br.readLine();
					p.searchbyname(str);
					
					
				}
				if(x==2)
				{
					System.out.println("enter symbol");
					str=br.readLine();
					p.searchbysymbol(str);
					
				}
		
				
			}
		
	}
	
}
