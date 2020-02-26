package spring_2020;

/**
 * @author Owen A. Riegle
 *
 */
public abstract class AbstractRentalItem {

	String title;
	private int yearOfRelease;
	private int slot;
	private int quantity;

	/**
	 * @param title         name of the rental item
	 * @param yearOfRelease year rental item was released
	 * @param slot          position within rental machine
	 * @param quantity      number of rental item in rental machine
	 */
	public AbstractRentalItem(String title, int yearOfRelease, int slot, int quantity) {
		this.title = title;
		this.yearOfRelease = yearOfRelease;
		this.slot = slot;
		this.quantity = quantity;
	}

	/**
	 * @return the title
	 */
	public String getTitle() {
		return title;
	}

	/**
	 * @param title the title to set
	 */
	public void setTitle(String title) {
		this.title = title;
	}

	/**
	 * @return the yearOfRelease
	 */
	public int getYearOfRelease() {
		return yearOfRelease;
	}

	/**
	 * @param yearOfRelease the yearOfRelease to set
	 */
	public void setYearOfRelease(int yearOfRelease) {
		this.yearOfRelease = yearOfRelease;
	}

	/**
	 * @return the slot
	 */
	public int getSlot() {
		return slot;
	}

	/**
	 * @param slot the slot to set
	 */
	public void setSlot(int slot) {
		this.slot = slot;
	}

	/**
	 * @return the quantity
	 */
	public int getQuantity() {
		return quantity;
	}

	/**
	 * @param quantity the quantity to set
	 */
	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}

	/**
	 * @return values of data members
	 */
	@Override
	public String toString() {
		return "AbstractRentalItem [title=" + title + ", yearOfRelease=" + yearOfRelease + ", slot=" + slot
				+ ", quantity=" + quantity + "]";
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		AbstractRentalItem other = (AbstractRentalItem) obj;
		if (quantity != other.quantity)
			return false;
		if (slot != other.slot)
			return false;
		if (title == null) {
			if (other.title != null)
				return false;
		} else if (!title.equals(other.title))
			return false;
		if (yearOfRelease != other.yearOfRelease)
			return false;
		return true;
	}

	/**
	 * @param rentalFee
	 * @return daily rental fee
	 */
	public abstract double dailyRentalFee(double rentalFee);

	/**
	 * @throws IllegalStateException if quantity of item retrieved is less than or
	 *                               equal to zero
	 * @param quantity subtracts one from quantity for item retrieved
	 */
	public int itemQuantity() {
		if (quantity <= 0)
			throw new IllegalStateException();
		else
			quantity -= 1;
		return quantity;
	}

}
