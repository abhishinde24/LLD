package org.example.manager;

import org.example.command.AddRoomCommand;
import org.example.command.BookMeetingCommand;
import org.example.command.CommandI;

import java.net.CookieHandler;
import java.util.HashMap;

public class CommandExecutor implements CommandI {
    private static CommandExecutor commandExecutor;
    private HashMap<String, CommandI> commands;

    public CommandExecutor(){
        commands =new HashMap<>();
        commands.put("ADD",new AddRoomCommand());
        commands.put("BOOK",new BookMeetingCommand());
    }

    public static synchronized CommandExecutor getInstance(){
      if(commandExecutor == null){
          commandExecutor = new CommandExecutor();
      }
      return commandExecutor;
    };

    @Override
    public void execute(final String cmd[]){
        if(commands.get(cmd[0]) == null){
            throw new RuntimeException("Invalid Command");
        }
        commands.get(cmd[0]).execute(cmd);
    }
}
