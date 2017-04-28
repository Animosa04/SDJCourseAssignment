package viabus;

public class TourFactory {

	/**
	 * @param typeOfTour
	 * @return a trip or travel depending on the boolean isTrip
	 * @throws Exception
	 */
	public Tour getTour(String typeOfTour) throws IllegalArgumentException {
		if (typeOfTour.equalsIgnoreCase("Trip"))
			return new Trip();
		else if (typeOfTour.equalsIgnoreCase("Travel"))
			return new Travel();
		else
			throw new IllegalArgumentException("Please enter a valid tour type");
	}
}
