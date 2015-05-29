package banking.server;

import java.util.*;
import java.io.*;

import banking.interfaces.Iaccount;
import banking.primitive.core.*;

class ServerSolution implements AccountServer {

	static String fileName = "accounts.ser";
	/**
	 * @uml.property  name="accountList"
	 * @uml.associationEnd  multiplicity="(0 -1)" elementType="banking.primitive.core.Account"
	 */
	List<Iaccount> accountList = new ArrayList<Iaccount>();

	public ServerSolution() {
		File file = new File(fileName);
		try {
			if (file.exists()) {
				System.out.println("Reading from file " + fileName + "...");
				ObjectInputStream in = new ObjectInputStream(
						new FileInputStream(file));

				Integer sizeI = (Integer) in.readObject();
				int size = sizeI.intValue();
				for (int i=0; i < size; i++) {
					Iaccount acc = (Iaccount) in.readObject();
					accountList.add(acc);
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	//
	public void newAccount(String type, String name, float balance) {
		Iaccount acc;
		if ("Checking".equals(type) ) {
			acc = new Checking(name, balance);

		} else if ("Savings".equals(type)) {
			acc = new Savings(name, balance);

		} else {
			throw new IllegalArgumentException("Bad account type:" + type);
		}
		accountList.add(acc);
	}

	public void update(Iaccount account) {
		int index = findIndex(account.getName());
		if (index < 0) {
			throw new IllegalStateException("Account not found:" + account);
		}

		accountList.remove(index);
		accountList.add(account);
	}

	public Iaccount getAccount(String name) {
		int index = findIndex(name);
		if (index < 0)
			return null;

		return accountList.get(index);
	}

	public List<Iaccount> getAllAccounts() {
		return accountList;
	}

	public List<Iaccount> getOverdrawnAccounts() {
		List<Iaccount> result = new ArrayList<Iaccount>();

		for (int i=0; i < accountList.size(); i++) {
			Iaccount acc = accountList.get(i);
			if (acc.getBalance() < 0) {
				result.add(acc);
			}
		}

		return result;
	}

	public void shutdown() {
		try {
			ObjectOutputStream out = new ObjectOutputStream(
					new FileOutputStream(fileName));

			out.writeObject(Integer.valueOf(accountList.size()));
			for (int i=0; i < accountList.size(); i++) {
				out.writeObject(accountList.get(i));
			}
		} catch (Exception e) {
			System.out.println("Could not write file:" + fileName);
			e.printStackTrace();
		}
	}

	protected int findIndex(String name) {

		for (int i=0; i < accountList.size(); i++) {
			Iaccount acc = accountList.get(i);
			if (name.equals(acc.getName())) {
				return i;
			}
		}
		return -1;
	}
}
