package viabus;

import java.util.Scanner;

public class CliConsole implements CliView {
	private Scanner in = new Scanner(System.in);

	/**
	 * Print value to the console
	 * 
	 * @param value
	 */
	@Override
	public void show(String value) {
		System.out.print(value);
	}

	/**
	 * Get input from the console
	 * 
	 * @returns next input line
	 */
	@Override
	public String get() {
		return in.nextLine();
	}

}
