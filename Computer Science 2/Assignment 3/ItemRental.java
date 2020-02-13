package spring_2020;

import java.util.Scanner;

/**
 * @author Owen A. Riegle
 *
 */
public class ItemRental {

	/**
	 * @param args
	 */
	public static void main(String[] args) {

		AbstractRentalItem[] itemList = new AbstractRentalItem[9];
		Scanner keyboard = new Scanner(System.in);
		int slot = 0;
		int i = 0;

		itemList[0] = (new VideoGame("Anthem", 2019, 1, 2, "XBOX"));
		itemList[1] = (new VideoGame("Madden 20", 2020, 2, 6, "PS4"));
		itemList[2] = (new VideoGame("Jumanji", 2019, 3, 9, "PS4"));
		itemList[3] = (new VideoGame("Gears 5", 2019, 4, 2, "XBOX"));
		itemList[4] = (new Movie("Joker", 2019, 5, 0, "BluRay"));
		itemList[5] = (new Movie("Hustlers", 2019, 6, 1, "DVD"));
		itemList[6] = (new Movie("Oceans 8", 2019, 7, 6, "DVD"));
		itemList[7] = (new Movie("Venom", 2019, 8, 8, "BluRay"));
		itemList[8] = (new Movie("Tag", 2019, 9, 3, "BluRay"));

		System.out.println("Enter the slot number of an item to rent it. Enter 0 stop renting.");
		slot = keyboard.nextInt();

		while (slot > 0) {
			try {
				for (i = 0; i < itemList.length; i++) {
					if (itemList[i].getSlot() == slot) {
						if (itemList[i].itemQuantity() >= 0) {
							System.out.println("Item " + itemList[i].getTitle() + " rented with a daily fee of $"
									+ String.format("%.2f", itemList[i].dailyRentalFee(i)));
						}
					}
					if (slot > 9 ) {
						System.out.println("Slot " + slot + " does not exist");
						System.out.println("Enter the slot number of an item to rent it. Enter 0 stop renting.");
						slot = keyboard.nextInt();
					}
				}
				System.out.println("Enter the slot number of an item to rent it. Enter 0 stop renting.");
				slot = keyboard.nextInt();
			} catch (IllegalStateException e) {
				System.out.println(itemList[i].getTitle() + " is out of stock");
				System.out.println("Enter the slot number of an item to rent it. Enter 0 stop renting.");
				slot = keyboard.nextInt();
			}
		}

		for (i = 0; i < itemList.length; i++)
			System.out.println(itemList[i]);

		keyboard.close();
	}
}
