package viabus;

import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.rmi.server.UnicastRemoteObject;
import java.util.ArrayList;

import viabus.ToursList.ACTION;

public class RMServerList extends UnicastRemoteObject implements
		IServerToursList {

	private static final long serialVersionUID = -334630550756398481L;
	private ArrayList<Tour> toursList;
	private ArrayList<IClientToursList> observers;

	protected RMServerList() throws RemoteException {
		super();
		toursList = new ArrayList<>();
		observers = new ArrayList<>();
	}

	public static void main(String[] args) {
		Registry registry;
		try {
			registry = LocateRegistry.createRegistry(6666);
			IServerToursList rmiServer = new RMServerList();
			registry.bind("server", rmiServer);
			System.out.println("Starting Server...");
		} catch (Exception ex) {
			ex.printStackTrace();
		}
	}

	/**
	 * Add a client to the list of clients
	 */
	@Override
	public ArrayList<Tour> init(IClientToursList client) {
		observers.add(client);
		return toursList;
	}

	/**
	 * Add or remove a tour from the list of tours
	 */
	@Override
	public void update(ACTION a, Tour t, IClientToursList client) {
		switch (a) {
		case ADD:
			System.out.println("added tour");
			toursList.add(t);
			break;
		case REMOVE:
			System.out.println("removed tour");
			toursList.remove(t);
			break;
		}
		notify(a, t, client);
	}

	/**
	 * Update the tour list on each client, that is not the client who
	 * added/removed a tour
	 * 
	 * @param a
	 * @param t
	 * @param client
	 */
	private void notify(ACTION a, Tour t, IClientToursList client) {
		for (IClientToursList c : observers) {
			try {
				if (!c.equals(client))
					c.update(a, t);
			} catch (RemoteException e) {
				disconnect(c);
			}
		}
	}

	/**
	 * Disconnect from the server when the program closes
	 */
	@Override
	public void disconnect(IClientToursList client) {
		observers.remove(client);
	}

}
