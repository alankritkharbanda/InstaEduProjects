import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Set;

public class LHMP {

	static void evenElements(LinkedHashMap lhm)
	{
		Set set = lhm.entrySet();
	      Iterator i = set.iterator();
	      while(i.hasNext()) {
	         Map.Entry me = (Map.Entry)i.next();
	        int x=(Integer) me.getKey();
	        if(x%2==0)
	         System.out.println(me.getKey()+ "  : "+ me.getValue());
	      }
	      System.out.println();
		
	}
	   public static void main(String args[]) {
		   
	      LinkedHashMap<Integer,Object> lhm = new LinkedHashMap();
	      lhm.put(1, new Integer(34342));
	      lhm.put(2, new Double(123.22));
	      lhm.put(3, new Double(1378.00));
	      lhm.put(4, new Double(99.22));
	      lhm.put(5, new Double(-19.08));
	      evenElements(lhm);
	      
	    
	   }
	}
