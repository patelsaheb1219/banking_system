package banking_system;

public class AccountDetail {
	private int accountNumber;
	private String accountHolderName;
	private String accountType;
	private int amount;
	private String accountStatus;
	
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
	
	public int getAccountNumber() {
		return accountNumber;
	}
	
	public String getAccountHolderName() {
		return accountHolderName;
	}
	
	public String getAccountType() {
		return accountType;
	}
	
	public int getAmount() {
		return amount;
	}
	
	public String getAccountStatus() {
		return accountStatus;
	}
 }
