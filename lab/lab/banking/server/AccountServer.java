package banking.server;

import java.util.List;

import banking.interfaces.Iaccount;


public interface AccountServer {

	/** Create a new account object in the server.  Type is either
		"Checking" or "Savings".  Throws IllegalArgumentException otherwise.
	*/
	public void		newAccount(String type, String name, float balance);

	/** Replace the already existing account.  Throws IllegalStateException
		if Account does not exist (this is a stretch, BTW).
	*/
	public void		update(Iaccount account);

	/** Returns Account object or null if not found. */
	public Iaccount	getAccount(String name);

	/** Returns a list of all Accounts inside the server */
	public List<Iaccount>		getAllAccounts();

	/** Returns a list of Accounts whose balance is less than 0 */
	public List<Iaccount>		getOverdrawnAccounts();

	/** Saves the state of the server and terminates the program */
	public void		shutdown();
}
