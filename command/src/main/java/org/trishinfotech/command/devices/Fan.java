package org.trishinfotech.command.devices;

public abstract class Fan extends Appliance {

	public static int TOP_SPEED = 4;
	
	public static int LOWEST_SPEED = 1;
	
	protected int currentSpeed = 1;
	
	public Fan(String name) {
		super(name);
	}
	
	// define operations for fan
	public void increase() {
		if (currentSpeed < TOP_SPEED) {
			currentSpeed++;
			System.out.printf("Encreasing Speed of '%s' to '%d'.\n", name, currentSpeed);
		} else {
			System.out.printf("'%s' is already running at top speed!\n", name);
		}
	}
	
	public void decrease() {
		if (currentSpeed > LOWEST_SPEED) {
			currentSpeed--;
			System.out.printf("Decreasing Speed of '%s' to '%d'.\n", name, currentSpeed);
		} else {
			System.out.printf("'%s' is laready running at lowest speed!\n", name);
		}
	}
}
