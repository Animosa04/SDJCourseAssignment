package viabus;

import java.text.SimpleDateFormat;
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
				Date date = new SimpleDateFormat("dd/MM/yyyy").parse(command);
				Tour tour = (Tour) cli.getData();
				tour.setDepartureDate(date);
				System.out.println("Tour saved!");
				cli.toursList.add(tour);
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	}

	@Override
	public CliState init(CliController cli) {
		cli.show("Enter departure date(dd/mm/yyyy): ");
		return this;
	}

}