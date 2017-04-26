package viabus;

import java.rmi.Naming;
import java.rmi.RemoteException;

public class RMClient {
	private static final long serialVersionUID = 1L;
	private RemoteToursList server;

	public RMClient() throws RemoteException {
		try {
			server = (RemoteToursList) Naming
					.lookup("rmi://localhost:6666/server");
		} catch (Exception ex) {
			ex.printStackTrace();
		}
	}

	private void main() throws RemoteException {

	}
}
