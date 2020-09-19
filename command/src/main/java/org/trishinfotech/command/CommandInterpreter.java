package org.trishinfotech.command;

import java.util.Comparator;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

public class CommandInterpreter {

	public static Optional<Command> interpretCommand(String commandStr) {
		Optional<Command> command = Optional.empty();
		if (commandStr != null && !commandStr.trim().isEmpty()) {
			List<String> applianceNames = HomeAutomation.INSTANCE.applianceNames();
			Optional<String> applianceName = findApplianceName(commandStr, applianceNames);
			if (applianceName.isPresent()) {
				List<Command> commands = HomeAutomation.INSTANCE.applianceCommands(applianceName.get());
				command = findCommand(commandStr, commands);
			}
		}
		return command;
	}

	private static Optional<Command> findCommand(String commandStr, List<Command> availableCommands) {
		List<Command> matchingCommands = availableCommands.stream()
				.filter(availableCommand -> hasMatchingKeywords(availableCommand, commandStr))
				.collect(Collectors.toList());
		matchingCommands.sort(new Comparator<Command>() {
					@Override
					public int compare(Command cmd1, Command cmd2) {
						return Integer.compare(noOfMatch(cmd2, commandStr), noOfMatch(cmd1, commandStr));
					}

					private int noOfMatch(Command cmd, String commandStr) {
						return cmd.keywords().stream().filter(keyword -> hasPotentialMatch(keyword, commandStr)).collect(Collectors.toList()).size();
					}
				});
		return Optional.ofNullable(matchingCommands.isEmpty() ? null : matchingCommands.get(0));
	}

	private static boolean hasMatchingKeywords(Command command, String commandStr) {
		return command.keywords().stream().filter(keyword -> hasPotentialMatch(keyword, commandStr)).findAny()
				.isPresent();
	}

	private static Optional<String> findApplianceName(String commandStr, List<String> applianceNames) {
		return applianceNames.stream().filter(applianceName -> hasPotentialMatch(applianceName, commandStr)
				|| hasPossibleMatch(applianceName, commandStr))
				.findFirst();
	}

	private static boolean hasPotentialMatch(String keyword, String commandStr) {
		return commandStr.toLowerCase().indexOf(keyword.toLowerCase()) != -1;
	}

	private static boolean hasPossibleMatch(String keyword, String commandStr) {
		String[] commandWords = commandStr.split("[ !\"\\#$%&'()*+,-./:;<=>?@\\[\\]^_`{|}~]+");
		String commandStrWithoutSpaces = String.join("", commandWords);
		return commandStrWithoutSpaces.toLowerCase().indexOf(keyword.toLowerCase()) != -1;
	}
}
