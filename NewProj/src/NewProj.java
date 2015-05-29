import java.io.*;
import java.util.*;

class employee implements Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	String name;String id; 
	public employee(String name, String id){
		
		this.name=name;
		this.id=id;
		
	}
	
	public static void changename(employee emp, String name)
	{
		emp.name=name;
	}
	
	public String getname(){return name;}
	public String getid(){return id;}
	
		
}

public class NewProj implements Serializable {
	public static void serialize(String str)
	{
		
		if(!arr.isEmpty())
			{
			try{
				File file=new File(str);
				if(!file.exists())
				{
					file.createNewFile();
					
				}
				FileOutputStream fos= new FileOutputStream(str);
		         ObjectOutputStream oos= new ObjectOutputStream(fos);
		         oos.writeObject(arr);
		         oos.close();
		         fos.close();
		       }catch(IOException ioe){
		            ioe.printStackTrace();
		        }
			}
			else
			{
				System.err.println("List is empty!");
			}

				
			
		
	}
	public static void serialize2(String str) throws ClassNotFoundException
	{
		
		if(!arr.isEmpty())
			{
			try{
				
				FileInputStream fos= new FileInputStream(str);
		         ObjectInputStream oos= new ObjectInputStream(fos);
		         arr=(ArrayList)oos.readObject();
		         oos.close();
		         fos.close();
		       }catch(IOException ioe){
		            ioe.printStackTrace();
		        }
			
			
			}
			else
			{
				System.err.println("List is empty!");
			}

				
		
	}
	static ArrayList <employee> arr = new  ArrayList<employee>();
	static void  add(String name, String id){
		
		
		arr.add(new employee(name,id));
		
	}
	public static void main(String args[]) throws IOException{
	System.out.println("Welcome Mortal !! \n Enter\n0.Exit\n 1.Add employee \n 2.Display Employee \n 3.Edit employee \n4.Delete\n5.Serialize\n6.Deserialize");
	int x;
	String   str;
	
	
	BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	str=br.readLine();
	x=Integer.parseInt(str);
	String name,id;
	while(x!=0){
	switch(x)
	{
	case 0 : break;
	case 1 : System.out.println("Enter name and id.");
	
		name=br.readLine();
		id=br.readLine();
		add(name,id);
		break;
	case 2 : int i=0;
		for(i=0;i<arr.size();i++)
		{
			System.out.println(arr.get(i).getname()+"\t"+arr.get(i).getid());
			
			
		} break;
	case 3: System.out.println("Enter id who's name has to be changed : ");
		str=br.readLine();
		int j=0;
		for(j=0;j<arr.size();j++)
		{
			if((arr.get(j).getid()).compareTo(str)==0)
				{	
				System.out.println("Enter name ");
				str=br.readLine();
				employee.changename(arr.get(j), str);

				System.out.println("New name for id : "+arr.get(j).getid()+" is "+arr.get(j).getname());
				
				}
			
			if(j>arr.size())
				System.out.println("Invalid id");
			
			
		}
		break;
	case 4 : System.out.println("Enter id to be deleted :  ");
	str=br.readLine();
	int k=0;
	for(k=0;k<arr.size();k++)
	{
		if((arr.get(k).getid()).compareTo(str)==0)
			{	
				employee emp= arr.remove(k);
				System.out.println(emp.getname()+"  has been removed");
				
			
			}
		
		
		
	}
	if(k>arr.size())
		System.out.println("Invalid id");
	break;
	case 5 : 
		System.out.println(" Enter File path");
		str=br.readLine();
		serialize(str);
		
		break;
	case 6 : 
		System.out.println(" Enter File path");
		str=br.readLine();
		try {
			serialize2(str); System.out.println("Values Restored !1");
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}break;
		
	default : System.out.println("Wrong option, reenter please......");
		
	}
	System.out.println("Welcome Mortal !! \n Enter\n0.Exit\n 1.Add employee \n 2.Display Employee \n 3.Edit employee \n4.Delete\n5.Serialize\n6.Deserialize");
	str=br.readLine();
	x=Integer.parseInt(str);
	}
	
	
	
	}
	
	
	}
