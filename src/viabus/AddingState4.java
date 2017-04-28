package viabus;

public class AddingState4 extends CliState {

	@Override
	public void processCommand(CliController cli, String command) {
		switch (command) {
		case ("b"):
		case ("back"):
			cli.setState(ADDING_STATE_3);
			break;
		default:
			Tour tour = (Tour) cli.getData();
			tour.setChauffeur(command);
			cli.setState(ADDING_STATE_5);
		}
	}

	@Override
	public CliState init(CliController cli) {
		cli.show("Enter chauffeur id: ");
		return this;
	}

}