// *****************************************************************************
// File name  : Tour.java.
// Start date : 24/04/2017
// Programmer : Victor Ronfaut
// Java       : 8
// Description: Tour is an abstract class which is extended in Trip and Travel to do the factory.
// *****************************************************************************

package viabus;

import java.io.Serializable;
import java.util.Date;

public abstract class Tour implements Serializable {
	private static final long serialVersionUID = 449645308350699325L;
	protected String destination;
	protected String bus;
	protected String chauffeur;
	protected Date departureDate;

	/**
	 * Constructor of Tour
	 * 
	 * @param destination
	 *            of the tour
	 * @param departueDate
	 *            when the tour will be going
	 * @param bus
	 *            used for the tour
	 * @param chauffeur
	 *            who will drive the bus
	 */

	public Tour(String destination, Date departureDate, String bus,
			String chauffeur) {

		this.destination = destination;
		this.bus = bus;
		this.chauffeur = chauffeur;
		this.departureDate = departureDate;
	}

	/**
	 * empty constructor
	 */
	public Tour() {
	}

	/**
	 * Getting bus variable
	 * 
	 * @return bus
	 */
	public String getBus() {
		return this.bus;
	}

	/**
	 * Setting bus variable
	 * 
	 * @param bus
	 */
	public void setBus(String b) {
		bus = b;
	}

	/**
	 * Getting chauffeur variable
	 * 
	 * @return chauffeur
	 */
	public String getChauffeur() {
		return chauffeur;
	}

	/**
	 * Setting chauffeur variable
	 * 
	 * @param chauffeur
	 */
	public void setChauffeur(String c) {
		this.chauffeur = c;
	}

	/**
	 * Getting the destination
	 * 
	 * @return destination
	 */
	public String getDestination() {
		return destination;
	}

	/**
	 * Setting the destination
	 * 
	 * @param place
	 *            of destination
	 */
	public void setDestination(String place) {
		destination = place;
	}

	/**
	 * Getting departure date
	 * 
	 * @return departure date
	 */
	public Date getDepartureDate() {
		return departureDate;
	}

	/**
	 * Sets the departure date
	 * 
	 * @param departureDate
	 */
	public abstract void setDepartureDate(Date departureDate);

	/**
	 * Getting the date interval
	 * 
	 * @return dateInterval
	 */
	public abstract DateInterval getDateInterval();

	@Override
	public String toString() {
		return "Destination: " + destination + "\nChauffeur: " + chauffeur
				+ "\nBus: " + bus;
	}

}
