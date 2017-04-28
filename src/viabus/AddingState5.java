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
				if (cli.getData() instanceof Trip) {
					Trip trip = (Trip) cli.getData();
					trip.setDepartureDate(date);
					cli.setData(trip);
				} else {
					Travel travel = (Travel) cli.getData();
					travel.setDepartureDate(date);
					cli.setData(travel);
				}
				System.out.println("Tour saved!");
				cli.setState(MAIN_MENU);
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