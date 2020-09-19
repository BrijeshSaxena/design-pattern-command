package org.trishinfotech.command.devices;

public abstract class Appliance implements Comparable<Appliance> {

	protected String name;
	protected boolean status;
	
	public Appliance(String name) {
		super();
		if (name == null || name.trim().isEmpty()) {
			new IllegalArgumentException("Appliance name is mandatory for Home Automation");
		}
		this.name = name;
	}

	public String name() {
		return name;
	}
	
	// define operations for appliance
	public void on() {
		if (status) {
			System.out.printf("'%s' is already turned on!\n", name);
		} else {
			status = true;
			System.out.printf("Turning On '%s'\n", name);
		}
	}
	
	public void off() {
		if (!status) {
			System.out.printf("'%s' is already turned off!\n", name);
		} else {
			status = false;
			System.out.printf("Turning Off '%s'\n", name);
		}
	}

	// Appliance should be compared only on name.
	@Override
	public int compareTo(Appliance other) {
		return this.name.compareToIgnoreCase(other.name);
	}
	
}
