package airport;

import java.util.ArrayList;

import org.joda.money.Money;
import org.joda.time.DateTime;

public class ExpressParkingLot implements Parkable {

	public ExpressParkingLot(String string, int i) {
		// TODO Auto-generated constructor stub
		
		
	}

	public Money computeCharge(DateTime from, DateTime to) {
		// TODO Auto-generated method stub
		Money m=Money.parse("USD 0");
		
		
		
		
		return null;
	}

	public void admit(Vehicle v) {
		// TODO Auto-generated method stub
		
	}

	public void release(Vehicle v) {
		// TODO Auto-generated method stub
		
	}

	public int capacity() {
		// TODO Auto-generated method stub
		return 0;
	}

	public int occupancy() {
		// TODO Auto-generated method stub
		return 0;
	}

	public ArrayList<Vehicle> occupants() {
		// TODO Auto-generated method stub
		return null;
	}

}
