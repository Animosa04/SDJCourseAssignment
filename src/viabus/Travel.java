package viabus;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class Travel extends Tour {
	DateInterval interval;

	public Travel(String destination, Date departureDate, String bus,
			String chauffeur) {
		super(destination, departureDate, bus, chauffeur);
		Calendar cal = Calendar.getInstance();
		cal.setTime(departureDate);
		cal.add(Calendar.DATE, 7);
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
