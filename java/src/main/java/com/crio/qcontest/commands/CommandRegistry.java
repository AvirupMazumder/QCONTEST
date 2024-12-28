package com.crio.qcontest.commands;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class CommandRegistry {
    
    private static Map<String,ICommand> commands;

    public CommandRegistry() {
        commands = new HashMap<>();
    }

    public void register(String commandName, ICommand cmd) {
        commands.putIfAbsent(commandName,cmd);
    }

    public void deregister(String commandName, ICommand cmd) {

        if(commands.containsKey(commandName)) {
            commands.remove(commandName);
        }
    }

    public void invokeCommand(List<String> tokens) {
        String commandName = tokens.get(0);
        ICommand cmd;
        if(commands.containsKey(commandName)) {
            cmd = commands.get(commandName);
            cmd.invoke(tokens);
        } else {
            throw new RuntimeException("Error. No such command: " + commandName);
        }
    }
}
