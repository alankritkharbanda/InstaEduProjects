package monopoly;
//This class simulates a die role giving a no. between 1 and 6
public class Die {
	public int getRoll() {
		return (int)(Math.random() * 6) + 1;
	}
}
