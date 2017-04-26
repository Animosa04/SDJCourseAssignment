package viabus;

import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.rmi.server.UnicastRemoteObject;
import java.util.ArrayList;

import viabus.ToursList.ACTION;

public class RMServerList extends UnicastRemoteObject implements IServerToursList {

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

	@Override
	public ArrayList<Tour> init(IClientToursList client) {
		observers.add(client);
		return toursList;
	}

	@Override
	public void update(ACTION a, Tour t, IClientToursList client) throws RemoteException {
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
		for (IClientToursList c : observers) {
			if (c != client)
				c.update(a, t);
		}
	}

	@Override
	public void disconnect(IClientToursList client) {
		observers.remove(client);
	}

}
