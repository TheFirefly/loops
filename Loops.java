import java.util.Scanner;

public class Loops {
	
	public static void main(String[] args) {
		
		Scanner input = new Scanner(System.in);
		System.out.print("Enter x: \t");
		int x = input.nextInt();
		calculateE(x);

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
}