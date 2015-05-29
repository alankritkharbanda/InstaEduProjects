import java.io.IOException;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import java.sql.*;
 
public class GetNotice {
	
	GetNotice()
	{
		
		
		
	}
	
	void noticeupdate()
	{
		Document doc;
		while(true)
		{
		try {
	 
			// need http protocol
			doc = Jsoup.connect("http://pu/notices_open.php").get();
	 
			// get page title
			//String title = doc.title();
//			System.out.println("title : " + title);
	 
			// get all links
			Elements links = doc.select("a[href]");
			for (Element link : links) {
	 
				// get the value from href attribute
				System.out.println("\nlink : " + link.attr("href"));
				System.out.println("text : " + link.text());
	 
			}
	 
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
		
	}
	
public static void main(String args[])
{
	
	
}
}