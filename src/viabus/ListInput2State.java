package viabus;

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
				cli.setData(new DateInterval((Date) cli.getData(), new Date(command)));
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
