package org.trishinfotech.command;

public class HomeRemote {

	Command command;

	public HomeRemote() {
		super();
	}
	
	public void setCommand(Command command) {
		this.command = command;
	}
	
	public void pressButton() {
		System.out.println("---------------------------------------------------------------------------");
		System.out.printf("Executing command '%s' on appliance '%s'...\n", command.name(), command.appliance().name());
		command.execute();
		System.out.println("Done!");
		System.out.println("---------------------------------------------------------------------------");
		System.out.println("\n");
	}
}
