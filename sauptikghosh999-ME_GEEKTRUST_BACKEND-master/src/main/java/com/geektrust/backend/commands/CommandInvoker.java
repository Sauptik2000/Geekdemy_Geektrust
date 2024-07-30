package com.geektrust.backend.commands;

import com.geektrust.backend.exception.InvalidCommandException;

import java.util.HashMap;
import java.util.Map;
import java.util.List;

public class CommandInvoker {

    private static final Map<String, ICommand> commandMap = new HashMap<>();

    // Register the command into the HashMap
    public void register(String commandName, ICommand command){
        commandMap.put(commandName,command);
    }

    // Get the registered Command
    private ICommand get(String commandName){
        return commandMap.get(commandName);
    }

    // Execute the registered Command
    public void executeCommand(String commandName, List<String> tokens) throws InvalidCommandException {
        ICommand command = get(commandName);
        if(command == null){
            // Handle Exception
            throw new InvalidCommandException();
        }
        command.execute(tokens);
    }


}