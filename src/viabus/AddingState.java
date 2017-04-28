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
				boolean isTrip = false;
				if (command.equalsIgnoreCase("Trip"))
					isTrip = true;
				cli.setData(tf.getTour(isTrip));
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	}

	@Override
	public CliState init(CliController cli) {
		cli.show("Select \"Trip\" or \"Travel\": ");
		return this;
	}

}
