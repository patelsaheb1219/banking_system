package banking_system;
/**
 * 
 * @author Kishankumar Patel C0810869
 *
 */

// Account Detail Class
public class AccountDetail {
	
	// variable declaration	
	private int accountNumber; // User's account number  
	private String accountHolderName; // User's name in particular account 
	private String accountType; // User's account type
	private int amount; // User's amount in the a particular account
	private String accountStatus; // User's account status
	
	
	/**
	 * Constructor to create object of AccountDetail Class
	 * @param accountNumber
	 * @param accountHolderName
	 * @param accountType
	 * @param amount
	 * @param accountStatus
	 */
	public AccountDetail(
			int accountNumber,
			String accountHolderName,
			String accountType,
			int amount,
			String accountStatus
		) {
		this.accountNumber = accountNumber;
		this.accountHolderName = accountHolderName;
		this.accountType = accountType;
		this.amount = amount;
		this.accountStatus = accountStatus;
	}
	
	/**
	 * Method:- Get Account Number
	 * @return accountNumber 
	*/
	public int getAccountNumber() {
		return accountNumber;
	}
	
	/**
	 * Method:- Get Account holder name
	 * @return accountHolderName 
	*/
	public String getAccountHolderName() {
		return accountHolderName;
	}
	
	/**
	 * Method:- Get Account Type
	 * @return accountType 
	*/
	public String getAccountType() {
		return accountType;
	}
	
	/**
	 * Method:- Get Account amount
	 * @return amount 
	*/
	public int getAmount() {
		return amount;
	}
	
	/**
	 * Method:- Get Account status
	 * @return accountStatus 
	*/
	public String getAccountStatus() {
		return accountStatus;
	}
 }
