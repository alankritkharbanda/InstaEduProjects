package banking.primitive.core;

import banking.interfaces.Iaccount;

@SuppressWarnings("serial")
public class Checking extends Iaccount {
	/**
	 * @uml.property  name="numWithdraws"
	 */
	private int numWithdraws = 0;

	private Checking(String name) {
		super(name);
	}

    public static Checking createChecking(String name) {
        return new Checking(name);
    }

	public Checking(String name, float balance) {
		super(name, balance);
	}


	public void display() {
		System.out.print("Checking ");
		super.display();
	}

	public void deposit(DepositParameter parameterObject) {
		account_Balance = account_Balance + parameterObject.amount;
	}

	public void withdraw(float amount) {
		account_Balance = account_Balance - amount;
		numWithdraws++;
		if (numWithdraws > 10)
			account_Balance = account_Balance - 2;
	}
	
   //private applyPeriodicFee(){
	   
   //}
 
	public String toString() {
		return "Chk:" + getName() + ":" + getBalance();
	}

    public char charAt(int i) {
        return name.charAt(i);
    }
}
