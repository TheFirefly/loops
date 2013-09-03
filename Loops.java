import java.util.Scanner;

public class Loops {
	
	public static void main(String[] args) {
		
		Scanner input = new Scanner(System.in);
		System.out.print("Enter x: \t");
		int x = input.nextInt();
		calculateE(x);

		// calculateDrugPotency(0.04, 50.0);
	}

	// public static int findLength(String str) {
		
	// 	int length = 0;

	// 	for (int i = 0 ; i < str.length() ; i++) {
	// 		length++;
	// 	}

	// 	return length;

	// }

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
		double sum = 1.0;
		double term = 1.0;
		while (sum > (1.0 * Math.pow(10.0, -12.0))) {
			sum += term * (x / n);

			sum += term;
			System.out.println("n:" + n + "\t term:" + term + "\t sum:" + sum);
			n++;

			if (n > 10) {
				return;
			}
		}
	}
}