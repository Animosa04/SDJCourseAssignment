package viabus;

public class TourFactory {

	/**
	 * @param isTrip
	 * @return a trip or travel depending on the boolean isTrip
	 */
	public Tour getTour(boolean isTrip) {
		if (isTrip)
			return new Trip();
		else
			return new Travel();
	}
}
