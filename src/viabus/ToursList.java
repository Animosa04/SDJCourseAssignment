package viabus;

import java.util.ArrayList;

public class ToursList {
	private ArrayList<Tour> toursList;

	public ToursList() {
		toursList = new ArrayList<Tour>();
	}

	public void add(Tour tour) {
		toursList.add(tour);
	}

	public void remove(Tour tour) {
		toursList.remove(tour);
	}

	public ArrayList<Tour> getTourByDateInterval(DateInterval interval) {
		ArrayList<Tour> overlappingTours = new ArrayList<>();
		for (Tour tour : toursList) {
			if (tour.getDateInterval().checkOverlap(interval))
				overlappingTours.add(tour);
		}
		return overlappingTours;
	}
}
