package viabus;

public class AddingState3 extends CliState {

	@Override
	public void processCommand(CliController cli, String command) {
		switch (command) {
		case ("b"):
		case ("back"):
			cli.setState(ADDING_STATE_2);
			break;
		default:
			try {
				Tour tour = (Tour) cli.getData();
				tour.setBus(command);
				cli.setState(ADDING_STATE_4);
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	}

	@Override
	public CliState init(CliController cli) {
		cli.show("Enter bus id: ");
		return this;
	}

}