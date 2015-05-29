import javax.xml.parsers.DocumentBuilderFactory;

import javax.xml.parsers.DocumentBuilder;
import org.w3c.dom.Document;
import org.w3c.dom.NodeList;
import org.w3c.dom.Node;
import org.w3c.dom.Element;
import java.io.*;

public class ParseXML {

    public static void main(String argv[])throws IOException {

         try {     
             BufferedWriter writer = new BufferedWriter(new FileWriter("results/staff.txt")); 
             File fXmlFile = new File("data/hardware-info.xml");  

             DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();  
             DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();      
             Document doc = dBuilder.parse(fXmlFile);      
             doc.getDocumentElement().normalize();    
             NodeList nList = doc.getElementsByTagName("md:record");     
             for (int i = 0; i < nList.getLength(); i++) 
             {      
                 Node node = nList.item(i);    
                 if (node.getNodeType() == Node.ELEMENT_NODE)    
                 {         
                      Element eElement = (Element) node; 
                     if(eElement.hasChildNodes())    
                     {               
                         NodeList nl = node.getChildNodes();      
                         for(int j=0; j<nl.getLength(); j++)  
                         {                   
                             Node nd = nl.item(j);   
                             String name= nd.getTextContent();
                                f (name != null && !name.trim().equals(""))                                 {
                                    System.out.print(name.trim()+",");   
                                    //System.out.print(" ");
                                    writer.write(nd.getTextContent().trim() + " ");
                                }

                         } 
                         System.out.println("");
                         writer.write("\n");
                         }        
                         } }  
             writer.close();
             } 
         catch (Exception e) {       
                         e.printStackTrace();     } } 
    @SuppressWarnings("unused")
    private static String getTagValue(String sTag, Element eElement)
    {        
        NodeList nlList = eElement.getElementsByTagName(sTag).item(0).getChildNodes();  
        Node nValue = (Node) nlList.item(0);       
        return nValue.getNodeValue();     
        } 
}