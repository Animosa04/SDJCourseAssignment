package viabus;

public class MainMenuState extends CliState {

	@Override
	public void processCommand(CliController cli, String command) {
		switch (command) {
		case ("b"):
		case ("back"):
			cli.show("Cannot go back\n");
			break;
		case ("l"):
		case ("list"):
			cli.setState(LIST_INPUT_1);
			break;
		case ("a"):
		case ("add"):
			cli.setState(ADDING_STATE);
			break;
		case ("r"):
		case ("rem"):
			cli.setState(REMOVE);
			break;
		default:
			cli.show("Unknown command type 'help' to get a list of commands or 'quit' to exit\n");
		}
	}

	@Override
	public CliState init(CliController cli) {
		cli.show(" MAIN	 MENU\n" + "Command	Description\n" + "'add'	add a reservation\n"
				+ "'rem'	remove a reservation\n" + "'list'	list all reservations\n" + "'back'	go back\n"
				+ "'quit'	exit the program\n");
		cli.setData(null);
		return this;
	}

}
