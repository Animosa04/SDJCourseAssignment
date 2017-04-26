package factoryPattern;

import java.util.Date;

public abstract class Tour {
	protected String destination;
	protected String bus;
	protected String chauffeur;
	protected Date departureDate;

	public Tour(String destination, Date departureDate, String bus,
			String chauffeur) {
		this.destination = destination;
		this.bus = bus;
		this.chauffeur = chauffeur;
		this.departureDate = departureDate;
	}

	public String getBus() {
		return this.bus;
	}

	public void setBus(String b) {
		bus = b;
	}

	public String getChauffeur() {
		return chauffeur;
	}

	public void setChauffeur(String c) {
		this.chauffeur = c;
	}

	public String getDestination() {
		return destination;
	}

	public void setDestination(String place) {
		destination = place;
	}

	public Date getDepartureDate() {
		return departureDate;
	}

	public DateInterval getDateInterval() {
		return null;
	}

	@Override
	public String toString() {
		return "Destination: " + destination + "\nChauffeur: " + chauffeur
				+ "\nBus: " + bus;
	}
}
