package viabus;

import java.rmi.Remote;
import java.rmi.RemoteException;

public interface IClientToursList extends Remote {
	void update(ToursList.ACTION a, Tour t) throws RemoteException;
}
