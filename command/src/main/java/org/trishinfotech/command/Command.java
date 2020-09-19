package org.trishinfotech.command;

import java.util.List;

import org.trishinfotech.command.devices.Appliance;

public abstract class Command {

	protected String name;
	protected Appliance appliance;

	public Command(String name, Appliance appliance) {
		this.name = name;
		this.appliance = appliance;
	}

	public Appliance appliance() {
		return appliance;
	}

	public String name() {
		return name;
	}

	public abstract void execute();

	public abstract List<String> keywords();
}
