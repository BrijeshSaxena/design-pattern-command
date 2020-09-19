package org.trishinfotech.command;

import java.util.Optional;
import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		String commandStr = null; 
		HomeRemote remote = new HomeRemote();
		try (Scanner scanner = new Scanner(System.in)) {
			do {
				System.out.println("Please enter command to operate on your Home Appliances (Press Ctrl + C to end)");
				System.out.println("-------------------------------------------------------------------------------");
				System.out.printf(" Available Devices: %s\n", HomeAutomation.INSTANCE.applianceNames());
				System.out.println("-------------------------------------------------------------------------------");
				System.out.print("Alexa>");
				commandStr = scanner.nextLine();
				Optional<Command> commandOption = CommandInterpreter.interpretCommand(commandStr);
				if (commandOption.isPresent()) {
					Command command = commandOption.get();
					remote.setCommand(command);
					remote.pressButton();
				} else {
					System.out.println("Sorry! I am not sure how to do that? Please try again!\n");
				}
			} while(true);
		}
	}

}
