package HappyPrimeNumbers;

import java.util.InputMismatchException;
import java.util.Scanner;

public class MainApp {

	public static void main(String[] args) {
		
		System.out.print("Enter a positive integer: ");
		
		Scanner scan = new Scanner(System.in);
		
		try {
			
			int userIn = scan.nextInt();
			boolean h = HappyNumber.isHappy(userIn);
			boolean p = PrimeNumber.isPrime(userIn);
			
			
			
			// check if userIn is happy-prime
			// 0 and 1 cannot be happy-prime
			// if happy-prime the program ends
			if ( ((h == true) && (p == true)) && ((userIn != 1) && (userIn != 0)) ) {
				System.out.println("happy-prime");
			}
			
			
			// if userIn is not 0 or 1
			else {
				
		// determine if userIn is happy or not
		if (h == true) {
			System.out.println("happy");
		}
		else {
			System.out.println("not happy");
		}
				
				
		// if userIn is 0 or 1 it is neither prime nor composite
		// and the program ends
		if ( (userIn == 0) || (userIn == 1) ) {
			System.out.println("neither prime nor composite");
		}
				
				
		// if userIn is not 0 or 1
		else {
			// determine if userIn is prime or composite
			if (p == true) {
				System.out.println("prime");
			}
			else {
				System.out.println("composite");
				
				// if userIn is composite
				// calculate / make array of prime factors
				int c[] = PrimeNumber.primeFactors(userIn);
						
				// list the prime factors and whether they are happy or not 
				System.out.print("prime factors:  ");
						
				for (int f: c) {
							
					// determine whether each prime factor is happy or not
					if (f != 0) {
								
						boolean hFactor = HappyNumber.isHappy(f);
								
						if (hFactor == true) {
							System.out.print(f + " (happy)  ");
						}
						else {
							System.out.print(f + " (not happy)  ");
						}
					}
				}
			}
		}
		
		
		}		
	}
		
		
		catch (InputMismatchException e){
			System.out.println("Input is not an integer");
		}
		catch (IllegalArgumentException e) {
			System.out.println("Input must be a positive integer");
		}
		
	
		
		

	}

}
