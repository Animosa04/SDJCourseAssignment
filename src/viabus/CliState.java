package viabus;

/**
 * Stores all the states
 */
public abstract class CliState implements CliConstants {

	/**
	 * process the command according to the current state
	 * 
	 * @param cli
	 * @param command
	 */
	public abstract void processCommand(CliController cli, String command);

	/**
	 * Initialize the state
	 * 
	 * @param cli
	 * @return itself
	 */
	public abstract CliState init(CliController cli);
}
