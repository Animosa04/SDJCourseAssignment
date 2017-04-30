package viabus;

import java.util.Calendar;
import java.util.Date;

public class Trip extends Tour {
	private static final long serialVersionUID = 6407725940834372591L;
	DateInterval interval;

	/**
	 * empty constructor
	 */
	public Trip() {
		super();
	}

	/**
	 * Constructor of Trip
	 * 
	 * @param destination
	 * @param departureDate
	 * @param bus
	 * @param chauffeur
	 */
	public Trip(String destination, Date departureDate, String bus, String chauffeur) {
		super(destination, departureDate, bus, chauffeur);
		Calendar cal = Calendar.getInstance();
		cal.setTime(departureDate);
		cal.add(Calendar.DATE, 1);
		Date arrivalDate = cal.getTime();
		interval = new DateInterval(departureDate, arrivalDate);
	}

	/**
	 * sets the departure date and calculates the arrival date and the date
	 * interval
	 * 
	 * @param depDate
	 */
	@Override
	public void setDepartureDate(Date depDate) {
		super.departureDate = depDate;
		Calendar cal = Calendar.getInstance();
		cal.setTime(departureDate);
		cal.add(Calendar.DATE, 1);
		Date arrivalDate = cal.getTime();
		interval = new DateInterval(departureDate, arrivalDate);
	}

	/**
	 * @return date interval of the trip
	 */
	@Override
	public DateInterval getDateInterval() {
		return interval;
	}

	/**
	 * overrides the toString method in its superclass
	 * 
	 * @return a string representation of a trip
	 */
	@Override
	public String toString() {
		return "Trip" + super.toString();
	}
}
