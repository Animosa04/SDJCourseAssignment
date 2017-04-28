package viabus;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class Trip extends Tour {
	private static final long serialVersionUID = 6407725940834372591L;
	DateInterval interval;

	/**
	 * Constructor of Trip
	 * 
	 * @param destination
	 * @param departureDate
	 * @param bus
	 * @param chauffeur
	 */
	public Trip(String destination, Date departureDate, String bus,
			String chauffeur) {
		super(destination, departureDate, bus, chauffeur);
		Calendar cal = Calendar.getInstance();
		cal.setTime(departureDate);
		cal.add(Calendar.DATE, 1);
		Date arrivalDate = cal.getTime();
		interval = new DateInterval(departureDate, arrivalDate);
	}

	public Trip() {
		super();
	}

	/**
	 * sets the departure date and calculates the arrival date and the date
	 * interval
	 * 
	 * @param depDate
	 */
	@Override
	public void setDepartureDate(Date depDate) {
		super.setDepartureDate(depDate);
		Calendar cal = Calendar.getInstance();
		cal.setTime(departureDate);
		cal.add(Calendar.DATE, 1);
		Date arrivalDate = cal.getTime();
		interval = new DateInterval(departureDate, arrivalDate);
	}

	@Override
	public DateInterval getDateInterval() {
		return interval;
	}

	@Override
	public String toString() {
		DateFormat df = new SimpleDateFormat("dd/MM/yyyy");
		return getClass().getName() + "\nDeparture date: "
				+ df.format(getDateInterval().getDepartureDate())
				+ "\nArrival date: "
				+ df.format(getDateInterval().getArrivalDate())
				+ super.toString();
	}
}
