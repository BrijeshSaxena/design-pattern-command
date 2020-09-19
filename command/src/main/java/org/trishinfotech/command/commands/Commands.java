package org.trishinfotech.command.commands;

import java.util.Arrays;
import java.util.List;

import org.trishinfotech.command.Command;
import org.trishinfotech.command.devices.Appliance;
import org.trishinfotech.command.devices.Fan;
import org.trishinfotech.command.devices.TV;
import org.trishinfotech.command.devices.livingroom.LivingRoomTV;

public class Commands {

	protected static String SWITCH = "switch";
	protected static String TURN = "turn";
	protected static String ON = "on";
	protected static String OFF = "off";
	protected static String START = "start";
	protected static String STOP = "stop";
	protected static String OPEN = "open";
	protected static String CLOSE = "close";
	protected static String UP = "up";
	protected static String DOWN = "down";
	protected static String STARTUP = "startup";
	protected static String SHUTDOWN = "shutdown";
	protected static String MUTE = "mute";
	protected static String UNMUTE = "unmute";
	protected static String PAUSE = "pause";
	protected static String INCREASE = "increase";
	protected static String DECREASE = "decrease";
	protected static String RAISE = "raise";
	protected static String LOWER = "lower";
	protected static String HIGHER = "higher";
	protected static String HIGH = "high";
	protected static String LOW = "low";
	protected static String SET = "set";
	protected static String SHOW = "show";
	protected static String CHANNEL = "channel";
	protected static String VOLUME = "volume";
	protected static String DISPLAY = "display";

	public static class OnCommand extends Command {
		public OnCommand(String name, Appliance appliance) {
			super(name, appliance);
		}
		@Override public void execute() {
			appliance.on();
		}
		@Override public List<String> keywords() {
			return Arrays.asList(ON, START, STARTUP);
		}
	}

	public static class OffCommand extends Command {
		public OffCommand(String name, Appliance appliance) {
			super(name, appliance);
		}
		@Override public void execute() {
			appliance.off();
		}
		@Override public List<String> keywords() {
			return Arrays.asList(OFF, STOP, SHUTDOWN);
		}
	}

	public static class IncreaseSpeedCommand extends Command {
		public IncreaseSpeedCommand(String name, Appliance appliance) {
			super(name, appliance);
		}
		@Override public void execute() {
			((Fan)appliance).increase();
		}
		@Override public List<String> keywords() {
			return Arrays.asList(UP, INCREASE, RAISE, HIGH, HIGHER);
		}
	}

	public static class DecreaseSpeedCommand extends Command {
		public DecreaseSpeedCommand(String name, Appliance appliance) {
			super(name, appliance);
		}
		@Override public void execute() {
			((Fan)appliance).decrease();
		}
		@Override public List<String> keywords() {
			return Arrays.asList(DOWN, DECREASE, LOW, LOWER);
		}
	}

	public static class TVIncreaseVolumeCommand extends Command {
		public TVIncreaseVolumeCommand(String name, Appliance appliance) {
			super(name, appliance);
		}
		@Override public void execute() {
			((TV)appliance).increaseVolume();
		}

		@Override public List<String> keywords() {
			return Arrays.asList(UP, INCREASE, RAISE, HIGH, HIGHER, VOLUME);
		}
	}

	public static class TVIncreaseChannelCommand extends Command {
		public TVIncreaseChannelCommand(String name, Appliance appliance) {
			super(name, appliance);
		}
		@Override public void execute() {
			((TV)appliance).increaseChannel();
		}

		@Override public List<String> keywords() {
			return Arrays.asList(UP, INCREASE, RAISE, HIGH, HIGHER, CHANNEL);
		}
	}

	public static class TVDecreaseVolumeCommand extends Command {
		public TVDecreaseVolumeCommand(String name, Appliance appliance) {
			super(name, appliance);
		}
		@Override public void execute() {
			((TV)appliance).decreaseVolume();
		}
		@Override public List<String> keywords() {
			return Arrays.asList(DOWN, DECREASE, LOW, LOWER, VOLUME);
		}
	}

	public static class TVDecreaseChannelCommand extends Command {
		public TVDecreaseChannelCommand(String name, Appliance appliance) {
			super(name, appliance);
		}
		@Override public void execute() {
			((TV)appliance).decreaseChannel();
		}
		@Override public List<String> keywords() {
			return Arrays.asList(DOWN, DECREASE, LOW, LOWER, CHANNEL);
		}
	}

	public static class TVMuteCommand extends Command {
		public TVMuteCommand(String name, Appliance appliance) {
			super(name, appliance);
		}
		@Override public void execute() {
			((LivingRoomTV)appliance).mute();
		}
		@Override public List<String> keywords() {
			return Arrays.asList(MUTE, UNMUTE, PAUSE);
		}
	}
}
