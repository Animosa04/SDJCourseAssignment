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
				if (cli.getData() instanceof Trip) {
					Trip trip = (Trip) cli.getData();
					trip.setDestination(command);
					cli.setData(trip);
				} else {
					Travel travel = (Travel) cli.getData();
					travel.setDestination(command);
					cli.setData(travel);
				}
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
