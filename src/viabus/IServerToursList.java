package viabus;

import java.rmi.Remote;
import java.rmi.RemoteException;
import java.util.ArrayList;

public interface IServerToursList extends Remote {
	ArrayList<Tour> init(IClientToursList client) throws RemoteException;

	void update(ToursList.ACTION a, Tour t, IClientToursList client) throws RemoteException;

	void disconnect(IClientToursList client) throws RemoteException;
}
