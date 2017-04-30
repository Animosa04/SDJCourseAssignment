package viabus;

import java.rmi.RemoteException;

public class RemoveState extends CliState {

	@Override
	public void processCommand(CliController cli, String command) {
		try {
			cli.toursList.remove(Integer.parseInt(command));
			cli.show("Successfully removed tour\n");
			cli.setState(MAIN_MENU);
		} catch (NumberFormatException e) {
			cli.show("Your input is not a valid id, please try again\n");
		} catch (IllegalArgumentException e) {
			cli.show("No tour matches that id, please try again\n");
		} catch (RemoteException e) {
			cli.show("Error connecting to the server, please try again later\n");
		}
	}

	@Override
	public CliState init(CliController cli) {
		cli.show("Please enter a reservation id to remove: ");
		return this;
	}

}
