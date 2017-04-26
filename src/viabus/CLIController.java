package viabus;

public class CliController implements CliConstants {
	private CliState state;
	private CliView view;
	private Object data;

	public CliController(CliView view) {
		this.view = view;
		this.state = MAIN_MENU.init(this);
	}

	/**
	 * Sets current state of the CLI
	 * 
	 * @param state
	 */
	void setState(CliState state) {
		this.state = state.init(this);
	}

	/**
	 * Show string in the console
	 * 
	 * @param msg
	 *            the string to show
	 */
	void show(String msg) {
		view.show(msg);
	}

	/**
	 * Process input from the user
	 * 
	 * @param command
	 * @return false if the program should halt
	 */
	boolean processCommand(String command) {
		switch (command) {
		case "exit":
		case "q":
		case "quit":
			show("Program terminated\n");
			return false;
		default:
			state.processCommand(this, command);
		}
		return true;
	}

	/**
	 * Main loop get input from the view and then process it
	 * 
	 * @param args
	 */
	public static void main(String[] args) {
		CliView view = new CliConsole();
		CliController controller = new CliController(view);
		String command;
		do {
			command = view.get();
		} while (controller.processCommand(command));
	}

	/**
	 * @return Data object shared by states
	 */
	public Object getData() {
		return data;
	}

	/**
	 * Set data object shared by states
	 * 
	 * @param data
	 */
	public void setData(Object data) {
		this.data = data;
	}

}
