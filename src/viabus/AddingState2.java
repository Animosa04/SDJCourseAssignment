package viabus;

public class AddingState2 extends CliState {

	@Override
	public void processCommand(CliController cli, String command) {
		switch (command) {
		case ("b"):
		case ("back"):
			cli.setState(ADDING_STATE);
			break;
		default:
			try {
				Tour tour = (Tour) cli.getData();
				tour.setDestination(command);
				cli.setState(ADDING_STATE_3);
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	}

	@Override
	public CliState init(CliController cli) {
		cli.show("Enter destination: ");
		return this;
	}

}
