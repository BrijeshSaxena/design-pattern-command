package org.trishinfotech.command.devices;

public abstract class TV extends Appliance {

	public static int TOP_VOLUME = 30;

	public static int LOWEST_VOLUME = 0;

	public static int TOP_CHANNEL_NO = 999;

	public static int LOWEST_CHANNEL_NO = 1;

	protected int currentVolume = 1;
	protected int currentChannel = 1;
	protected int volumeWhenMute;

	public TV(String name) {
		super(name);
	}

	// define operations for TV
	public void increaseVolume() {
		if (currentVolume < TOP_VOLUME) {
			currentVolume++;
			System.out.printf("Encreasing volume of '%s' to '%d'.\n", name, currentVolume);
		} else {
			System.out.printf("'%s' is already on top volume!\n", name);
		}
	}

	public void decreaseVolume() {
		if (currentVolume > LOWEST_VOLUME) {
			currentVolume--;
			System.out.printf("Decreasing volume of '%s' to '%d'.\n", name, currentVolume);
		} else {
			System.out.printf("'%s' is already on mute!\n", name);
		}
	}

	public void mute() {
		if (currentVolume != LOWEST_VOLUME) {
			volumeWhenMute = currentVolume;
			currentVolume = 0;
			System.out.printf("Putting '%s' on mute!\n", name);
		} else {
			currentVolume = volumeWhenMute;
			System.out.printf("Unmuting '%s'. Setting volume back to '%d'!\n", name, currentVolume);
		}
	}

	public void increaseChannel() {
		if (currentChannel < TOP_CHANNEL_NO) {
			currentChannel++;
			System.out.printf("Encreasing channel of '%s' to '%d'.\n", name, currentChannel);
		} else {
			System.out.printf("'%s' is already showing channel '%d'!\n", name, currentChannel);
		}
	}

	public void decreaseChannel() {
		if (currentChannel > LOWEST_CHANNEL_NO) {
			currentChannel--;
			System.out.printf("Decreasing channel of '%s' to '%d'.\n", name, currentChannel);
		} else {
			System.out.printf("'%s' is already showing channel '%d'!\n", name, currentChannel);
		}
	}
}
