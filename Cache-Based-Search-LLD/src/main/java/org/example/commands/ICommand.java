package org.example.commands;

import org.example.exceptions.CommandNotFoundException;

public interface ICommand {
    void executeCommand(String cmd[]) throws CommandNotFoundException;
}
