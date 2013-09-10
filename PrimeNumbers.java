import java.util.Set;
import java.util.HashSet;
import java.util.Scanner;

public class PrimeNumbers {
	static Set<Long> primeNumbers = new HashSet<Long>();
	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		System.out.print("Input number to find prime numbers between 1 and n: ");
		findPrimeNumbers(input.nextLong());
		String output = "";
		for (Long i : primeNumbers) {
			output += " " + i;
		}

		System.out.println("Primes:" + output);

		System.out.println("");
		System.out.println("RESULT: " + primeNumbers.size() + " prime numbers.");
	}

	public static void findPrimeNumbers(long n) {
		for (long i = 1 ; i <= n ; i++) {
			//i is the number between 1 and n we are checking as prime or not
			if (isPrime(i)) {
				primeNumbers.add(i);
				System.out.println("Added prime number: " + i + " to set.");
			}
		}
	}

	private static boolean isPrime(long x) {
		boolean prime = true;
		for (Long j : primeNumbers) {
			if (j != 1 && x % j == 0) {
				System.out.println(x + " has the prime factor: " + j + " ... not prime.");
				prime = false;
				return prime;
			}
		}

		return prime;
	}
}