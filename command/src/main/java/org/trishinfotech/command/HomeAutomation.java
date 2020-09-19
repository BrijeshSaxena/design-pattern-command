package org.trishinfotech.command;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.stream.Collectors;

import org.trishinfotech.command.commands.Commands.DecreaseSpeedCommand;
import org.trishinfotech.command.commands.Commands.IncreaseSpeedCommand;
import org.trishinfotech.command.commands.Commands.OffCommand;
import org.trishinfotech.command.commands.Commands.OnCommand;
import org.trishinfotech.command.commands.Commands.TVDecreaseChannelCommand;
import org.trishinfotech.command.commands.Commands.TVDecreaseVolumeCommand;
import org.trishinfotech.command.commands.Commands.TVIncreaseChannelCommand;
import org.trishinfotech.command.commands.Commands.TVIncreaseVolumeCommand;
import org.trishinfotech.command.commands.Commands.TVMuteCommand;
import org.trishinfotech.command.devices.Appliance;
import org.trishinfotech.command.devices.bedroom.BedRoomFan;
import org.trishinfotech.command.devices.bedroom.BedRoomLight;
import org.trishinfotech.command.devices.kitchen.KitchenLight;
import org.trishinfotech.command.devices.kitchen.Microwave;
import org.trishinfotech.command.devices.livingroom.LivingRoomFan;
import org.trishinfotech.command.devices.livingroom.LivingRoomLight;
import org.trishinfotech.command.devices.livingroom.LivingRoomTV;

public class HomeAutomation {

	private Map<Appliance, List<Command>> optionsAvailable = new HashMap<Appliance, List<Command>>();

	private HomeAutomation() {
		Appliance bedRoomFan = new BedRoomFan();
		Appliance bedRoomLight = new BedRoomLight();
		Appliance kitchenLight = new KitchenLight();
		Appliance microwave = new Microwave();
		Appliance livingRoomFan = new LivingRoomFan();
		Appliance livingRoomLight = new LivingRoomLight();
		Appliance livingRoomTV = new LivingRoomTV();
		optionsAvailable.put(bedRoomFan,
				Arrays.asList(new OnCommand("On", bedRoomFan), new OffCommand("Off", bedRoomFan),
						new IncreaseSpeedCommand("Increase", bedRoomFan),
						new DecreaseSpeedCommand("Decrease", bedRoomFan)));
		optionsAvailable.put(bedRoomLight, Arrays.asList(new OnCommand("On", bedRoomLight),
				new OffCommand("Off", bedRoomLight)));
		optionsAvailable.put(kitchenLight, Arrays.asList(new OnCommand("On", kitchenLight),
				new OffCommand("Off", kitchenLight)));
		optionsAvailable.put(microwave,
				Arrays.asList(new OnCommand("On", microwave), new OffCommand("Off", microwave)));
		optionsAvailable.put(livingRoomFan,
				Arrays.asList(new OnCommand("On", livingRoomFan),
						new OffCommand("Off", livingRoomFan),
						new IncreaseSpeedCommand("Increase", livingRoomFan),
						new DecreaseSpeedCommand("Decrease", livingRoomFan)));
		optionsAvailable.put(livingRoomLight, Arrays.asList(new OnCommand("On", livingRoomLight),
				new OffCommand("Off", livingRoomLight)));
		optionsAvailable.put(livingRoomTV,
				Arrays.asList(new OnCommand("On", livingRoomTV),
						new OffCommand("Off", livingRoomTV),
						new TVIncreaseVolumeCommand("Increase Volume", livingRoomTV),
						new TVIncreaseChannelCommand("Decrease Channel", livingRoomTV),
						new TVDecreaseVolumeCommand("Decrease Volume", livingRoomTV),
						new TVDecreaseChannelCommand("Decrease Channel", livingRoomTV),
						new TVMuteCommand("Mute/Unmute", livingRoomTV)));
	}

	public List<String> applianceNames() {
		return optionsAvailable.keySet().stream().map(appliance -> appliance.name()).collect(Collectors.toList());
	}

	public List<Command> applianceCommands(String applianceName) {
		List<Command> commands = new ArrayList<Command>();
		if (applianceName != null && !applianceName.trim().isEmpty()) {
			Optional<Appliance> applianceSelected = optionsAvailable.keySet().stream()
					.filter(appliance -> appliance.name().equalsIgnoreCase(applianceName.trim())).findAny();
			if (applianceSelected.isPresent()) {
				commands.addAll(optionsAvailable.get(applianceSelected.get()));
			}
		}
		return commands;
	}

	public static HomeAutomation INSTANCE = new HomeAutomation();

}
