package viabus;

import java.io.Serializable;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

public class DateInterval implements Serializable {
	private static final long serialVersionUID = 1L;
	private Date departureDate;
	private Date arrivalDate;

	/**
	 * sets the departure date and the arrival date of the date interval
	 * 
	 * @param departureDate
	 * @param arrivalDate
	 */
	public DateInterval(Date departureDate, Date arrivalDate) {
		this.departureDate = departureDate;
		this.arrivalDate = arrivalDate;
	}

	/**
	 * @param departureDate
	 *            to set the departureDate
	 */
	public void setDepartureDate(Date departureDate) {
		this.departureDate = departureDate;
	}

	/**
	 * @return the departureDate
	 */
	public Date getDepartureDate() {
		return departureDate;
	}

	/**
	 * @param arrivalDate
	 *            to set the arrivalDate
	 */
	public void setArrivalDate(Date arrivalDate) {
		this.arrivalDate = arrivalDate;
	}

	/**
	 * @return the arrivalDate
	 */
	public Date getArrivalDate() {
		return arrivalDate;
	}

	/**
	 * 
	 * @param other
	 *            date
	 * @return if date overlaps the interval
	 */
	public boolean checkOverlap(Date other) {
		return (this.departureDate.before(other) && this.arrivalDate.after(other));
	}

	/**
	 * @return the duration of a service in days
	 */
	public int durationOfService() {
		int duration = (int) ((arrivalDate.getTime() - departureDate.getTime()) / (1000 * 60 * 60 * 24));
		return duration;
	}

	/**
	 * @return a string with the departure and arrival date
	 */
	@Override
	public String toString() {
		DateFormat format = new SimpleDateFormat("dd/MM/yy");
		return "Departure date: " + format.format(departureDate) + "\nArrival date: " + format.format(arrivalDate);
	}
}