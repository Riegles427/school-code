package spring_2020;

import java.util.Scanner;

/**
 * @author Owen A. Riegle
 *
 */
public class RecursiveAddition {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		int num1;
		int num2;

		Scanner keyboard = new Scanner(System.in);

		System.out.println(
				"First enter a value to be multiplied, then enter a value for how many times to multiply the previous value");
		num1 = keyboard.nextInt();
		num2 = keyboard.nextInt();

		int product = multiplication(num1, num2);
		System.out.println("Product = " + product);

		keyboard.close();
	}

	/**
	 * 
	 * @param num1 value to be multiplied
	 * @param num2 number of multiplications
	 * @return product
	 */
	public static int multiplication(int num1, int num2) {
		if (num2 == 0 || num1 == 0)
			return 0;
		else if (num1 < num2)
			return multiplication(num2, num1);
		else if (num2 > 0)
			return num1 + multiplication(num1, num2 - 1);
		else if (num2 < 0)
			return -num1 + multiplication(num1, num2 + 1);
		else
			return num1;
	}

}
