import java.util.Scanner;

import java.io.*;
import java.io.FileNotFoundException;

import java.util.ArrayList;

/**
 * Searches through a file of the most common surnames in the US according to
 * the US Census.
 * 
 * @author Owen A. Riegle
 *
 */
public class LastNames {

	/**
	 * @param args
	 */
	public static void main(String[] args) throws FileNotFoundException {

		ArrayList<String> surnames = new ArrayList<>();
		ArrayList<String> targets = new ArrayList<>();

		File fileReader = new File("D:\\EclipseJavaWorspace\\Assignments\\src\\LastNames.txt");

		Scanner inputFile = new Scanner(fileReader);
		Scanner keyboard = new Scanner(System.in);

		int position = 0;
		String surname = "";

		while (inputFile.hasNext()) {
			surname = inputFile.nextLine();
			surnames.add(surname);
			position++;
		}

		System.out.println("Enter a surname to see if it is one of the most common in the US, done when finished");

		while (!"done".equalsIgnoreCase(surname = keyboard.nextLine()))
			targets.add(surname.toUpperCase());

		for (position = 0; position < targets.size(); position++) {
			if (surnames.indexOf(targets.get(position)) >= 0)
				System.out
						.println(targets.get(position) + " is ranked " + (surnames.indexOf(targets.get(position)) + 1));
			else
				System.out.println("Surname " + targets.get(position) + " not found");
		}

		keyboard.close();
		inputFile.close();
	}

}
