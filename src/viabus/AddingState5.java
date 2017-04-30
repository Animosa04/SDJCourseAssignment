package viabus;

import java.rmi.RemoteException;
import java.util.Date;

public class AddingState5 extends CliState {

	@Override
	public void processCommand(CliController cli, String command) {
		switch (command) {
		case ("b"):
		case ("back"):
			cli.setState(ADDING_STATE_4);
			break;
		default:
			try {
				@SuppressWarnings("deprecation")
				Date date = new Date(command);
				Tour tour = (Tour) cli.getData();
				tour.setDepartureDate(date);
				cli.toursList.add(tour);
				System.out.println("Tour saved!\n");
				cli.setState(MAIN_MENU);
			} catch (IllegalArgumentException e) {
				cli.show("Error parsing your input, please try again\n");
			} catch (RemoteException e) {
				cli.show("Error connecting to the server, please try again later\n");
			}

		}
	}

	@Override
	public CliState init(CliController cli) {
		cli.show("Enter departure date(dd/mm/yyyy): ");
		return this;
	}

}