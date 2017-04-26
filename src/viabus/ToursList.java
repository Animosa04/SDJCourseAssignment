package viabus;

import java.util.ArrayList;

public class ToursList {
	private ArrayList<Tour> toursList;

	/**
	 * Constructor of ToursList
	 */
	public ToursList() {
		toursList = new ArrayList<Tour>();
	}

	/**
	 * Adding a tour to the ToursList
	 * @param tour
	 */
	public void add(Tour tour) {
		toursList.add(tour);
	}

	/**
	 * Remove a tour from the ToursList
	 * @param tour
	 */
	public void remove(Tour tour) {
		toursList.remove(tour);
	}

	/**
	 * Get the list of tours within a date interval
	 * @param date interval
	 * @return list of tours
	 */
	public ArrayList<Tour> getTourByDateInterval(DateInterval interval) {
		ArrayList<Tour> overlappingTours = new ArrayList<>();
		for (Tour tour : toursList) {
			if (tour.getDateInterval().checkOverlap(interval))
				overlappingTours.add(tour);
		}
		return overlappingTours;
	}
}
