package viabus;

public class AddingState extends CliState {

	@Override
	public void processCommand(CliController cli, String command) {
		switch (command) {
		case ("b"):
		case ("back"):
			cli.setState(MAIN_MENU);
			break;
		default:
			try {
				TourFactory tf = new TourFactory();
				cli.setData(tf.getTour(command));
				cli.setState(ADDING_STATE_2);
			} catch (IllegalArgumentException e) {
				cli.show("Invalid Input, try again\n");
			}
		}
	}

	@Override
	public CliState init(CliController cli) {
		cli.show("Select \"Trip\" or \"Travel\": ");
		return this;
	}

}
