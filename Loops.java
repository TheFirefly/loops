import java.util.Scanner;

public class Loops {

	private static int[] numbers = new int[1000];
	private static int amountInSequence = 1;
	private static long lastNumberChecked = 2;
	
	public static void main(String[] args) {
		
		for (int i = 0 ; i < 1000 ; i++) {
			numbers[i] = i;
		}

		Scanner input = new Scanner(System.in);
		// System.out.print("Enter n: ");
		// long n = input.nextLong();
		
		// calculateHailsoneSequence(n);
		
		findNumbersNotInHailstoneSequence();

		//calculateE(x);
		// calculateDrugPotency(0.04, 50.0);
	}


	public static void calculateDrugPotency(double percentLoss, double minEffective) {
		double effectiveness = 100.0;
		int month = 0;
		System.out.println("Month: " + month + "\t effectiveness: " + effectiveness);
		while (effectiveness > minEffective) {
			effectiveness = effectiveness - (effectiveness * percentLoss);
			month++;
			String suffix = "";
			if (effectiveness < minEffective) {
				suffix = " DISCARDED";
			}
			System.out.println("Month: " + month + "\t effectiveness: " + effectiveness + suffix);

		}
	}

	public static void calculateE(int x) {
		int n = 1;
		long nFact = n;
		double sum = 1.0;
		double term = Math.pow(x, n)/nFact;
		while (term > (Math.pow(10.0, -12.0))) {
			term = Math.pow(x, n)/nFact;
			sum += term;

			System.out.println("n:" + n + "\t term:" + term + "\t sum:" + sum);

			n++;
			nFact *= n;
		}
		System.out.println("");
		System.out.println("My \t e^x: \t" + sum);
		System.out.println("Real \t e^x: \t" + Math.exp(x));
	}

	public static void calculateHailstoneSequence(long n) {
		long originalN = n;
		long sequenceLength = 0;
		long max = n;
		long newN = n;
		System.out.println("Calculating sequence for n = " + originalN + "..." + "Found: " + amountInSequence + " numbers in at least 1 sequence.");
		while (n != 1) {
			if (isEven(n)) {
				newN = n / 2;
			} else {
				newN = (3 * n) + 1;
			}
			sequenceLength++;
			max = Math.max(max, newN);
			n = newN;
			lastNumberChecked = originalN;

			if (newN <= 1000) {
				if (numbers[((int)newN - 1)] != 0) {
					numbers[((int)newN - 1)] = 0;
					System.out.println(newN + " is located in the hailstone sequence for: " + originalN);
					amountInSequence++;
				}
			}
		}

		System.out.println("Sequence length: " + sequenceLength++);
		System.out.println("Max number: " + max);
	}

	public static void findNumbersNotInHailstoneSequence() {
		long x = 2;
		while (x <= 1000 && amountInSequence < 1000) {
			calculateHailstoneSequence(x);
			x++;
		}

		System.out.println("================");
		System.out.println("RESULT");
		System.out.println("================");


		boolean none = true;
		for (int i = 0 ; i < 1000 ; i++) {
			if (numbers[i] != 0) {
				System.out.println("Not in any hailstone sequence: " + (i + 1));
				none = false;
			}
		}
		if (none) {
			System.out.println("All numbers between 1 and 1000 are in atleast 1 hailstone sequence.");
		}

	}

	private static boolean isEven(long x) {
		return x % 2 == 0;
	}
}