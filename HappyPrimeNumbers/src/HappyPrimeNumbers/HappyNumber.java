package HappyPrimeNumbers;

public class HappyNumber {
	
	int userIn;
	
	// constructors
	public HappyNumber() {
	}

	public HappyNumber(int userIn) {
		this.userIn = userIn;
	}

	
	// calculate whether userIn is happy or not
	public static boolean isHappy(int userIn) throws IllegalArgumentException {
		
		if ( userIn < 0 ) {
			throw new IllegalArgumentException("Input must be a positive integer");
		}
		
		int initialNum = userIn;
		int sum = 0;
		
		while (sum != userIn) {
			
			int separateDigits[] = new int[10];
			int count = 0;
			sum = 0;
			
			// separates digits
			while (initialNum > 0) {
				
				int digit = initialNum % 10;
				
				// add digit to array (digits will be reverse order)
				separateDigits[count] = digit;
				count++;
				
				// set up the initial number to find the next digit
				initialNum = (initialNum - digit) / 10;
				
			}
			
			// calculate sum of userIn digits
			for (int j = 0; j < count; j++) {
				sum += Math.pow(separateDigits[j], 2);
			}
			
			// is userIn happy?
			if (sum == 1) {
				return true;
			}
			else if ((sum == 4) || sum == userIn) {
				return false;
			}
			
			initialNum = sum;
		
		}
		
		return false;
	}
	
}
	

