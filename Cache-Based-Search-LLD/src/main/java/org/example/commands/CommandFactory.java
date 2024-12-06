package org.example.commands;

import org.example.exceptions.CommandNotFoundException;

import java.util.HashMap;
import java.util.Map;

public class CommandFactory implements ICommand{
    private Map<String, ICommand> commandMap;
    private static CommandFactory commandFactoryInstance;
    private CommandFactory() {
        commandMap = new HashMap();
        commandMap.put("ADD_USER",new AddUserCommand());
        commandMap.put("ADD_MOVIE",new AddMovieCommand());
        commandMap.put("SEARCH",new SearchMovieCommand());
//        commandMap.put("SEARCH",);


    }

    public static CommandFactory getInstance() {
        if (commandFactoryInstance == null) {
            commandFactoryInstance = new CommandFactory();
        }
        return commandFactoryInstance;
    }

    private Map<String, ICommand> getCommandMap() {
        return commandMap;
    }

    @Override
    public void executeCommand(String[] cmd) throws CommandNotFoundException {
        if(!commandMap.containsKey(cmd[0])) {
            throw new CommandNotFoundException("InCorrect/Illegal Command ->" + cmd[0]);
        }
        getCommandMap().get(cmd[0]).executeCommand(cmd);
    }
}
