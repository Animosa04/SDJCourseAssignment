package viabus;

import java.rmi.Remote;
import java.rmi.RemoteException;
import java.util.ArrayList;

public interface RemoteToursList extends Remote {
	public ArrayList<Tour> getListByDate(DateInterval interval)
			throws RemoteException;
}
