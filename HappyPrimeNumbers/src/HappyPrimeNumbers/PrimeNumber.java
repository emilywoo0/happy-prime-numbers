package HappyPrimeNumbers;

public class PrimeNumber {	
	
	int primNum;
	int primFact;
	
	// constructors
	public PrimeNumber() {
	}
	
	public PrimeNumber(int pNum) {
		primNum = pNum;
	}
	
	// checks if n is prime or not
	// note 1 is not a prime number
	public static boolean isPrime(int n) throws IllegalArgumentException {
		
		if (n < 0) {
			throw new IllegalArgumentException("Input must be a positive integer");
		}
		
		// 2 and 3 are prime numbers that do not fit the formula
		// 0 and 1 are neither prime nor composite
		if ( (n == 2) || (n == 3) ) {
			return true;
		}
		else if ( (n == 1) || (n == 0) ) {
			return true;
		}
		// 6n + 1
		else if ( (n % 6) == 1 ) {
			return true;
		}
		// 6n - 1
		else if ( ((n + 1) % 6) == 0) {
			return true;
		}
		else {
			return false;
		}
		
	}
	
	
	// returns array of prime factors of n
	public static int[] primeFactors(int n) throws IllegalArgumentException {
		
		if (n < 0) {
			throw new IllegalArgumentException("Input must be a positive integer");
		}
		
		int num = n;
		int index = 0;
		int pFactor[] = new int[10];
		
// https://www.geeksforgeeks.org/java-program-for-efficiently-print-all-prime-factors-of-a-given-number/
		
		// while num is even
		while ( ((num % 2) == 0) && (num != 2) ) {
						
			num = num / 2;			
		}
		
		
		// if n is even then add 2 to the list of prime factors
		if ( (n % 2) == 0 ) {
			pFactor[index] = 2;
			index++;
		}
		// num is already prime add it to array
		
		if ( (isPrime(num) == true) && (num != 2) ) {
			
			pFactor[index] = num;
			index++;
		}
		// else decrease num to prime by odd numbers
			
			// search for lowest odd number that divides num
			for (int i = 3; i <= Math.sqrt(n); i+=2) {
				
				// while num is divisible by i and is not 1
				while ( ((num % i) == 0) && (num != i)) {
					
					// do the math
					num /= i;
					
					// if the number is now prime add to array
					if ( isPrime(num) == true ) {
						
						pFactor[index] = num;
						index++;
					}
					
					if ( isPrime(i) == true ) {
						
						pFactor[index] = i;
						index++;
					}
				}	
			}
			
		return pFactor;
	}
		
}
