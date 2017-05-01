package viabus;

import java.rmi.Naming;
import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.ArrayList;

public class ToursList extends UnicastRemoteObject implements IClientToursList {
	private static final long serialVersionUID = -117814961353305424L;
	IServerToursList server;
	private ArrayList<Tour> toursList;

	public enum ACTION {
		ADD, REMOVE
	}

	/**
	 * Constructor of ToursList
	 */
	public ToursList() throws RemoteException {
		toursList = new ArrayList<Tour>();
		try {
			server = (IServerToursList) Naming
					.lookup("rmi://localhost:6666/server");
			toursList = server.init(this);
		} catch (Exception ex) {
			ex.printStackTrace();
		}
	}

	/**
	 * Update tourList with changes from the server
	 */
	@Override
	public void update(ACTION a, Tour t) {
		switch (a) {
		case ADD:
			toursList.add(t);
			break;
		case REMOVE:
			toursList.remove(t);
			break;
		}
	}

	/**
	 * Adding a tour to the ToursList
	 * 
	 * @param tour
	 * @throws RemoteException
	 */
	public void add(Tour tour) throws RemoteException {
		toursList.add(tour);
		server.update(ACTION.ADD, tour, this);
	}

	/**
	 * Remove a tour from the ToursList
	 * 
	 * @param tour
	 * @throws RemoteException
	 */
	public void remove(Tour tour) throws RemoteException {
		toursList.remove(tour);
		server.update(ACTION.REMOVE, tour, this);
	}

	/**
	 * Remove a tour from the ToursList by id
	 * 
	 * @param id
	 * @throws RemoteException
	 */
	public void remove(int id) throws RemoteException {
		for (Tour t : toursList) {
			if (id == t.id) {
				remove(t);
				return;
			}
		}
		throw new IllegalArgumentException("No tour corresponds to id " + id);
	}

	/**
	 * Get the list of tours within a date interval
	 * 
	 * @param date
	 *            interval
	 * @return list of tours
	 */
	public ArrayList<Tour> getTourByDateInterval(DateInterval interval) {
		ArrayList<Tour> overlappingTours = new ArrayList<>();
		for (Tour tour : toursList) {
			if (interval.checkOverlap(tour.getDepartureDate()))
				overlappingTours.add(tour);
		}
		return overlappingTours;
	}

	/**
	 * Disconnect from the server when the program closes
	 */
	@Override
	protected void finalize() throws Throwable {
		super.finalize();
		server.disconnect(this);
	}
}
