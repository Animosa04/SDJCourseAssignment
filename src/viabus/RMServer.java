package viabus;

import java.rmi.Naming;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.server.UnicastRemoteObject;
import java.util.ArrayList;

public class RMServer extends UnicastRemoteObject implements RemoteToursList {

	private ToursList toursList;

	protected RMServer() throws RemoteException {
		super();
		toursList = new ToursList();

	}

	@Override
	public ArrayList<Tour> getListByDate(DateInterval interval)
			throws RemoteException {
		ArrayList<Tour> overlappingTours = toursList
				.getTourByDateInterval(interval);
		return overlappingTours;
	}

	public static void main(String[] args) {
		try {
			LocateRegistry.createRegistry(6666);
			RemoteToursList rmiServer = new RMServer();
			Naming.rebind("server", rmiServer);
			// System.out.println("Starting Server...");
		} catch (Exception ex) {
			ex.printStackTrace();
		}
	}

}
