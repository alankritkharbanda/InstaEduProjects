package banking.primitive.core;
import banking.interfaces.Iaccount;
import banking.interfaces.AInterestBearing;
import banking.primitive.*;
@SuppressWarnings("serial")
public class Savings extends Iaccount implements AInterestBearing {
	/**
	 * @uml.property  name="numWithdraws"
	 */
	private int numWithdraws = 0;

	public Savings(String name) {
		super(name);
	}

	public Savings(String name, float balance) {
		super(name, balance);
	}

	public void display() {
		super.display();
	}

	public void deposit(DepositParameter parameterObject) {
		account_Balance = account_Balance + parameterObject.amount - 0.50F;
	}

	public void withdraw(float amount) {
		account_Balance = account_Balance - amount;
		numWithdraws++;
		if (numWithdraws > 3)
			account_Balance = account_Balance - 1;
	}

	public void accrueInterest() {
		account_Balance = account_Balance * 1.001F;
	}


	public String toString() {
		return "Sav:" + getName() + ":" + getBalance();
	}
}
