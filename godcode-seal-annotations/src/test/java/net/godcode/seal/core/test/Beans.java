package net.godcode.seal.core.test;

import net.godcode.seal.annotations.Sealed;
import net.godcode.seal.annotations.SealedBean;

/**
 * Beans
 * 
 * $Id$
 * 
 * @author clewis Mar 22, 2010
 * 
 */
public class Beans {
	
	public static final Account ACCOUNT = new Account("124", "personal");
	
	public static final Customer CUSTOMER = new Customer("John", "Doe", "911", ACCOUNT);
	
	public static final String SECRET = "SECRET!!";
	
	private Beans() {}
	
	@SealedBean(secret = SECRET)
	public static class Customer {
		private String firstName;
		private String lastName;
		@Sealed
		private String customerNo;
		@Sealed(path = "accountNo")
		private Account account;

		public Customer(String firstName, String lastName, String customerNo,
				Account account) {
			this.firstName = firstName;
			this.lastName = lastName;
			this.customerNo = customerNo;
			this.account = account;
		}

		public String getFirstName() {
			return firstName;
		}

		public String getLastName() {
			return lastName;
		}

		public String getCustomerNo() {
			return customerNo;
		}

		public Account getAccount() {
			return account;
		}

	}

	public static class Account {
		private String accountNo;
		private String name;

		public Account(String accountNo, String name) {
			this.accountNo = accountNo;
			this.name = name;
		}

		public String getAccountNo() {
			return accountNo;
		}

		public String getName() {
			return name;
		}

	}
	
}
