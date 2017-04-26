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
		default:
			cli.show("Unknown command type 'help' to get a list of commands or 'quit' to exit\n");
		}
	}

	@Override
	public CliState init(CliController cli) {
		cli.show(" MAIN	 MENU\n" + "Command	Description\n" + "'list'	list all reservations\n" + "'back'	go back\n"
				+ "'help'	display detailed instructions\n" + "'quit'	exit the program\n");
		cli.setData(null);
		return this;
	}

}
