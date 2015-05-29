import java.io.BufferedWriter;
import java.io.*;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintStream;


public class FileDemo {

	public static void main(String args[]) throws IOException
	{
		
		File file2= new File("abc.doc");
		File file= new File("abcdef.txt");
		if(!file.exists())
		{
			file.createNewFile();
			System.out.println(file.getAbsolutePath());
			
		}
		FileInputStream fis= new FileInputStream(file2);
		FileReader fr= new FileReader(file2);
		FileWriter fw= new FileWriter(file);
		BufferedReader br=new BufferedReader(fr);
		BufferedWriter bw= new BufferedWriter(fw);
		
		String data=br.readLine();
		while(data!=null)
		{
			bw.write(data);
			data=br.readLine();
		}
		br.close();bw.close();
		try {}
		finally{}
		
		
		
		//String str=file.;
		
		
	}
	
}
