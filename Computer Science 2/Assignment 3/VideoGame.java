package spring_2020;

/**
 * @author Owen A. Riegle
 *
 */
public class VideoGame extends AbstractRentalItem {

	public String console;

	/**
	 * @param title
	 * @param yearOfRelease
	 * @param slot
	 * @param quantity
	 * @param console
	 */
	public VideoGame(String title, int yearOfRelease, int slot, int quantity, String console) {
		super(title, yearOfRelease, slot, quantity);
		this.console = console;
	}

	/**
	 * @return the console
	 */
	public String getConsole() {
		return console;
	}

	/**
	 * @param console the console to set
	 */
	public void setConsole(String console) {
		this.console = console;
	}

	/**
	 * @return values of data members
	 */
	@Override
	public String toString() {
		return quantity + " copies of " + title;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (!super.equals(obj))
			return false;
		if (getClass() != obj.getClass())
			return false;
		VideoGame other = (VideoGame) obj;
		if (console == null) {
			if (other.console != null)
				return false;
		} else if (!console.equals(other.console))
			return false;
		return true;
	}

	@Override
	public double dailyRentalFee(double rentalFee) {
		if (console.equalsIgnoreCase("XBOX"))
			return 3.00;
		if (console.equalsIgnoreCase("PS4"))
			return 2.50;
		else
			return 0;
	}

}
