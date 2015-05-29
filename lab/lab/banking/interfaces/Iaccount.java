package banking.interfaces;
// 
import banking.primitive.*;
import banking.primitive.core.DepositParameter;

import javax.swing.JOptionPane;

@SuppressWarnings("serial")
public abstract class Iaccount implements Aasset
{
	/**
	 * @uml.property  name="balance"
	 */
	// CST316 ACTIVITY 1.4
	protected float account_Balance =0.0F;
	/**
	 * @uml.property  name="name"
	 */
	protected String name;

	
	public Iaccount(String n)
	{
		name = n;
	}

	public Iaccount(String n, float b)
	{
		name = n;
		account_Balance = b;
	}

	public void display()
	{
	    //System.out.println("Account " + name + " has $" + balance);
	    JOptionPane.showMessageDialog(null, "Account " + name + " has $" + account_Balance);
	}

	/**
	 * @return
	 * @uml.property  name="name"
	 */
	public String getName()
	{
		return name;
	}

	/**
	 * @return
	 * @uml.property  name="balance"
	 */
	public float getBalance()
	{
		return account_Balance;
	}
	public abstract void deposit(DepositParameter parameterObject);
	public abstract void withdraw(float amount);

    public String toString() {
	return "Account " + name + " has $" + account_Balance +"\n";
    }
}
