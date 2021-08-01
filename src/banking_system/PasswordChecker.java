package banking_system;

public class PasswordChecker {
	
	/**
	 	Static Function to check uppercase character in Password 
	 	@param password  user entered password
	 	@return isValid Boolean based on string check
	*/
	private static boolean isContainUppercase(String password) {
		boolean isValid = false;
		int i = 0;
				
		while (i < password.length()){
			if(Character.isUpperCase(password.charAt(i))){
				isValid = true;
		        break;
		    }
			i++;
		}
		return isValid;
	}
	
	/**
	 	Static Function to check lowercase character in Password 
	 	@param password  user entered password
	 	@return isValid Boolean based on lowercase check
	*/
	private static boolean isContainLowercase(String password) {
		boolean isValid = false;
		int i = 0;
		while (i < password.length()){
			if(Character.isLowerCase(password.charAt(i))){
				isValid = true;
		        break;
		    }
			i++;
		}
		return isValid;
	}
	
	/**
	 	Static Function to check Number in Password 
	 	@param password  user entered password
	 	@return isValid Boolean based on number check
	*/
	private static boolean isContainNumber(String password) {
		boolean isValid = false;
		int i = 0;
		while (i < password.length()){
			if(Character.isDigit(password.charAt(i))){
				isValid = true;
		        break;
		    }
			i++;
		}
		return isValid;
	}
	
	public boolean passwordChecker(String password) {
		if (password.length() >= 6 && isContainLowercase(password) && isContainUppercase(password) && isContainNumber(password)) {
			return true;
		}
		return false;
	}
}
