package com.sezzle.calculator.interaction;

import com.sezzle.calculator.exceptions.CommandNotFoundException;
import com.sezzle.calculator.handlers.CalculatorCommandHandler;
import com.sezzle.calculator.interaction.commands.CalculateCommand;
import com.sezzle.calculator.interaction.commands.ClearCommand;
import com.sezzle.calculator.interaction.commands.Command;

import java.io.IOException;
import java.security.InvalidParameterException;
import java.util.HashMap;
import java.util.Map;

public class CommandFactory {
    private Map<String, Command> commands;

    private CommandFactory() {
        commands = new HashMap<>();
    }

    public static CommandFactory init(CalculatorCommandHandler parkingLotCommandHandler) {
        final CommandFactory cf = new CommandFactory();
        cf.addCommand(">", new CalculateCommand(parkingLotCommandHandler));
        cf.addCommand("clear", new ClearCommand(parkingLotCommandHandler));
        return cf;
    }

    public void addCommand(String name, Command command) {
        commands.put(name, command);
    }

    public void executeCommand(String name, String[] params) throws CommandNotFoundException, IOException, InterruptedException {
        if (name.equals("help")) {
            listCommandHelp();
            return;
        }
        if (commands.containsKey(name)) {
            commands.get(name).execute(params);
        } else {
            throw new CommandNotFoundException(name);
        }
    }

    public void listCommandHelp() {
        commands.keySet().stream()
                .map(command -> commands.get(command).helpText())
                .forEach(System.out::println);
    }

    public Map<String, Command> getCommands() {
        return commands;
    }
}
