package spring_2020;

/**
 * @author Owen A. Riegle
 *
 */
public class Movie extends AbstractRentalItem {

	public String diskType;

	/**
	 * @param title
	 * @param yearOfRelease
	 * @param slot
	 * @param quantity
	 * @param diskType
	 */
	public Movie(String title, int yearOfRelease, int slot, int quantity, String diskType) {
		super(title, yearOfRelease, slot, quantity);
		this.diskType = diskType;
	}

	/**
	 * @return the diskType
	 */
	public String getDiskType() {
		return diskType;
	}

	/**
	 * @param diskType the diskType to set
	 */
	public void setDiskType(String diskType) {
		this.diskType = diskType;
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
		Movie other = (Movie) obj;
		if (diskType == null) {
			if (other.diskType != null)
				return false;
		} else if (!diskType.equals(other.diskType))
			return false;
		return true;
	}

	@Override
	public double dailyRentalFee(double rentalFee) {
		if (diskType.equalsIgnoreCase("DVD"))
			return 1.80;
		if (diskType.equalsIgnoreCase("BluRay"))
			return 2.00;
		else
			return 0;
	}

}
