import java.awt.List;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;

public class ListNode {
	public char data;
	public ListNode next;
	ListNode()
	{
		
	}
	
	ListNode(char x) {
		this.data = x;
		this.next = null;

	}
	
	public static ListNode reverse(ListNode LinkedList1)
	{
		ListNode l=new ListNode();
		ListNode temp=LinkedList1;
		
		while(temp!=null)
		{
			l=insert(l, temp.data);
			
			temp=temp.next;
			
			
		}
		
		return l;
		
	}
	
	public static ListNode sort(ListNode LinkedList1)
	{
		//System.out.println("TEST");
		ListNode l=reverse(LinkedList1);
		int n=0;
		ListNode temp=l;
		while(temp!=null)
		{
			n++;
			temp=temp.next;
		}
		temp=l;
	
		
		for(int i=0;i<=n;i++)
		{temp=l;
		while(temp!=null && temp.next!=null)
		{
			
				if(temp.data>temp.next.data)
				{
					char ch=temp.data;
					temp.data=temp.next.data;
					temp.next.data=ch;
				}
				
			
			temp=temp.next;
		}
		}
		

		
		
		
		
		return l;
	}

	public static void main(String args[]) throws IOException,
			CloneNotSupportedException {

		//ListNode LinkedList1;
		System.out.println("Enter characters such that last character is head of linked list");
		char[] ch = new char[100];
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String str = br.readLine();
//		List<Character> list = new ArrayList<Character>();
		ListNode LinkedList1=null;
		for(int i=0;i<str.length();i++)
		{
			LinkedList1=insert(LinkedList1,str.charAt(i));
			
		}
		System.out.println("List :");
		print(LinkedList1);
		System.out.println("Reversed List :");
		print(reverse(LinkedList1));
		System.out.println("Sorted List :");
		print(sort(LinkedList1));
		
	}

	private static void print(ListNode linkedList1) {
		// TODO Auto-generated method stub
		if(linkedList1==null)
		{	System.out.println("");return;}
		System.out.print(linkedList1.data);
		print(linkedList1.next);
		
	}

	private static ListNode insert(ListNode LinkedList1, char charAt) {
		// TODO Auto-generated method stub
		ListNode l=new ListNode(charAt);
		l.next=LinkedList1;
		return l;
	}

}