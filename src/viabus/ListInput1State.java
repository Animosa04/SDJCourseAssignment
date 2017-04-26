package viabus;

import java.util.Date;

public class ListInput1State extends CliState {

	@SuppressWarnings("deprecation") // Can't do fuzzy parsing without library
	@Override
	public void processCommand(CliController cli, String command) {
		switch (command) {
		case ("b"):
		case ("back"):
			cli.setState(MAIN_MENU);
			break;
		default:
			try {
				cli.setData(new Date(command));
				cli.setState(LIST_INPUT_2);
			} catch (IllegalArgumentException e) {
				cli.show("Unable to identify date, please try again\n");
			}
		}

	}

	@Override
	public CliState init(CliController cli) {
		cli.show("Please enter a start date: ");
		return this;
	}

}
