import java.io.PrintWriter;


/**
 * @version 1.0
 * @author
 * 
 * This class acts as one of the data structures that the data will be held into. 
 * This class is for the Sorted Linked List data structure.
 * 
 *
 */
/**
 * Acts as a node for the Sorted Linked List Algorithm. 
 * @author 
 * @version 1.0
 * @param <T>
 */
 class SLLnode <T extends Comparable <T> > {
	
	T data;
	SLLnode <T> link;
	int count;
	
	//Constructor for node class
	public SLLnode()
	{
		link = null;
		data = null;
		count=0;
	}
	
	//Constructor for node class
	public SLLnode (T d, SLLnode<T> n)
	{
		data = d;
		link = n;
		count=1;
	}
	
	//method to set link to the next node
	public void incrementcount()
	{
		count++;
	}
	public int getcount()
	{
		return count;
	}
	public void setLink(SLLnode<T> n)
	{
		link = n;
	}
	
	//method to set data to the current node
	public void setData(T d)
	{
		data = d;
	}
	
	//method to get the link;
	public SLLnode <T> getLink()
	{
		return link;
	}
	
	public T getData()
	{
		return data;
	}

}

public class SortedLinkedList <T extends Comparable <T>> {
	
	public SLLnode<T> start;
	public int size;
	
	//Constructor
	public SortedLinkedList()
	{
		start = null;
		size = 0;
	}
	
	//Method that checks if the list is empty.
	public SLLnode<T> isEmpty()
	{
		return start = null;
	}
	
	//Method that checks the size of the list.
	public int getSize()
	{
		return size;
	}
	public int numnodes()
	{
		int i=0;
		SLLnode<T> sll=start;
		while(sll!=null)
		{
			i++;
			sll=sll.getLink();
		}
		return i;
		
	}
	public void insert(T value)
	{
		SLLnode<T> nptr = null;
		SLLnode<T> ptr = null;
		SLLnode<T> tmp = null;
		
		nptr = new SLLnode<T>(value, null);
		
		boolean ins = false;
		
		if (start == null)
		{
			start = nptr;
			size++;
			return;
		}
		
		else if( value.compareTo(start.getData()) < 0)
		{
			nptr.setLink(start);
			start = nptr;
			size++;
			return;
		}
		else if(value.compareTo(start.getData()) == 0)
		{
			start.incrementcount();
			
			return;
			
		}
		
		else
		{
			tmp = start;
			ptr = start.getLink();
			while(ptr != null)
			{
				if(value.compareTo(tmp.getData()) ==0 )
				{
					tmp.incrementcount();
					break;
				}
				if ( value.compareTo(tmp.getData()) > 0 && value.compareTo(ptr.getData()) < 0 )
				{
					tmp.setLink(nptr);
					nptr.setLink(ptr);
					ins = true;
					size ++;
					break;
				}
				else if(value.compareTo(tmp.getData()) > 0 && value.compareTo(ptr.getData()) == 0 )
				{
					ptr.incrementcount();
					ins=true;
					break;
					
				}
				else
				{
					tmp = ptr;
					ptr = ptr.getLink();
					
				}
			}
			
			if (ins == false)
			{
				tmp.setLink(nptr);
				size ++;
			}
		}
		
	}
	
	
	public int numnodescutoff(SortedLinkedList<T> sll, int t )
	{
		SLLnode<T> start=sll.start;
		int i=0;
		while(start!=null)
		{	if(start.getcount()>t)
			i++;
			start=start.getLink();
		}
		return i;
		
	}
	public void display(PrintWriter p,int cutoff)
	{
		p.println("Cut off= "+cutoff);
		if (size == 0)
		{
			System.out.println("Empty");
			return;
		}
		
		if(start.getLink() == null)
		{
			System.out.println(start.getData());
			return;
		}
		SLLnode<T> ptr = start;
		if(start.count>cutoff)
		{
		p.println(start.count+" "+start.getData());
		}
		ptr = start.getLink();
		
		while(ptr != null)
		{	if(ptr.count>cutoff)
			{p.println(ptr.getcount()+" "+ptr.getData());
			
			}
		ptr = ptr.getLink();
		}
		
		//System.out.println(ptr.getData() + "\n" );

	}
	

}
