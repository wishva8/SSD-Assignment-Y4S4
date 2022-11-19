//SSD Assignment 2
package com.ihub.janus.app;

import java.io.PrintStream;

/**
 * The Class AppBanner.
 */
class AppBanner {

	/** The Constant BANNER. */
	private static final String[] BANNER = { "       _                       ", "      | |                      ",
			"      | | __ _ _ __  _   _ ___ ", "  _   | |/ _` | '_ \\| | | / __|", " | |__| | (_| | | | | |_| \\__ \\",
			"  \\____/ \\__,_|_| |_|\\__,_|___/" };

	/**
	 * Prints the banner.
	 */
	static void printBanner() {
		final PrintStream printStream = System.out;
		for (String line : BANNER) {
			printStream.println(line);
		}

		printStream.printf("%31s", "v0.1");
		printStream.println();
	}

}
