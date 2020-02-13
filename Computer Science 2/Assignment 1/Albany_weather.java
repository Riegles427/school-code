package spring_2020;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

/**
 * @author Owen A. Riegle
 *
 */
public class Albany_weather {

	/**
	 * @param args
	 */
	public static void main(String[] args) throws FileNotFoundException {

		ArrayList<String> data = new ArrayList<>();

		File fileReader = new File("D:\\CompSci\\EclipseJavaWorkspace\\spring_2020\\spring_2020\\AlbanyWeather.txt");

		Scanner inputFile = new Scanner(fileReader);
		Scanner keyboard = new Scanner(System.in);

		int index = 0;
		int numOfDate = 0;
		double averageHigh = 0;
		double averageLow = 0;
		double averageTemp = 0;
		double averageRainfall = 0;
		double averageSnowfall = 0;

		String date = "MM/DD";

		// enters file data into data arrayList
		while (inputFile.hasNext()) {
			date = inputFile.nextLine();
			data.add(date);
			index++;
		}

		System.out.println(
				"Enter the month and day of a date in 'M/DD' format to see weather data for that date in Albany, NY");
		date = keyboard.next();

		// checks if the month value is less than 1 or more than 12
		String[] inputList = date.split("/");
		if (Integer.parseInt(inputList[0]) < 1 || Integer.parseInt(inputList[0]) > 12) {
			System.out.println(
					"Incorrect date. Enter the month and day of a date in 'M/DD' format to see weather data for that date in Albany, NY");
			date = keyboard.next();
		}

		// checks if month equals 1,3,5,7,8,10,12 then checks to see if day is more than
		// 31
		if (Integer.parseInt(inputList[0]) == 1 || Integer.parseInt(inputList[0]) == 3
				|| Integer.parseInt(inputList[0]) == 5 || Integer.parseInt(inputList[0]) == 7
				|| Integer.parseInt(inputList[0]) == 8 || Integer.parseInt(inputList[0]) == 10
				|| Integer.parseInt(inputList[0]) == 12) {
			if (Integer.parseInt(inputList[1]) > 31) {
				System.out.println(
						"Incorrect date. Enter the month and day of a date in 'M/DD' format to see weather data for that date in Albany, NY");
				date = keyboard.next();
			}
		}

		// checks if month equals 4,6,9,11 then checks if day is more than 30
		if (Integer.parseInt(inputList[0]) == 4 || Integer.parseInt(inputList[0]) == 6
				|| Integer.parseInt(inputList[0]) == 9 || Integer.parseInt(inputList[0]) == 11) {
			if (Integer.parseInt(inputList[1]) > 30) {
				System.out.println(
						"Incorrect date. Enter the month and day of a date in 'M/DD' format to see weather data for that date in Albany, NY");
				date = keyboard.next();
			}
		}

		// checks if month is 2 then checks if day is more than 29
		if (Integer.parseInt(inputList[0]) == 2) {
			if (Integer.parseInt(inputList[1]) > 29) {
				System.out.println(
						"Incorrect date. Enter the month and day of a date in 'M/DD' format to see weather data for that date in Albany, NY");
				date = keyboard.next();
			}
		}

		// Searches data arraylist for entered date, if found date is split and
		// processed for computation
		for (index = 0; index < data.size(); index++) {
			if (data.get(index).startsWith(date)) {
				String[] itemList = data.get(index).split(",");
				averageHigh += Double.parseDouble(itemList[1]);
				averageLow += Double.parseDouble(itemList[2]);
				averageTemp += Double.parseDouble(itemList[3]);
				averageRainfall += Double.parseDouble(itemList[4]);
				averageSnowfall += Double.parseDouble(itemList[5]);
				numOfDate++;
			}
		}

		// computes averages
		averageHigh /= numOfDate;
		averageLow /= numOfDate;
		averageTemp /= numOfDate;
		averageRainfall /= numOfDate;
		averageSnowfall /= numOfDate;

		System.out.println("Average High Temperature: " + String.format("%.1f", averageHigh) + " F");
		System.out.println("Average Low Temperature: " + String.format("%.1f", averageLow) + " F");
		System.out.println("Average Temperature: " + String.format("%.1f", averageTemp) + " F");
		System.out.println("Average Rainfall: " + String.format("%.1f", averageRainfall) + " In.");
		System.out.println("Average Snowfall: " + String.format("%.1f", averageSnowfall) + " In.");
		System.out.println("Number of Occurrences: " + numOfDate);

		keyboard.close();
		inputFile.close();
	}

}
