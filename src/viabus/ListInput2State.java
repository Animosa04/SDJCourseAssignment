package viabus;

import java.util.ArrayList;
import java.util.Date;

public class ListInput2State extends CliState {

	@SuppressWarnings("deprecation") // Can't do fuzzy parsing without library
	@Override
	public void processCommand(CliController cli, String command) {
		switch (command) {
		case ("b"):
		case ("back"):
			cli.setState(LIST_INPUT_1);
			break;
		default:
			try {
				ArrayList<Tour> tours = cli.toursList
						.getTourByDateInterval(new DateInterval((Date) cli.getData(), new Date(command)));
				if (tours.size() == 0)
					cli.show("Sorry there are no tours on the selected period\n");
				for (Tour t : tours) {
					cli.show(t.toString() + "\n");
				}
				cli.setState(MAIN_MENU);
			} catch (IllegalArgumentException e) {
				cli.show("Unable to identify date, please try again\n");
			}
		}

	}

	@Override
	public CliState init(CliController cli) {
		cli.show("Please enter an end date: ");
		return this;
	}

}
