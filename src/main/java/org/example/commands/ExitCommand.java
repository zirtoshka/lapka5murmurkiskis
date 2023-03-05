package org.example.commands;

import org.example.IO.ConsoleManager;

public class ExitCommand extends Command{
    public ExitCommand(){
        super("exit", "finish program without saving");
    }
    @Override
    public boolean execute(String arg){
        ConsoleManager.printSuccess("Au revoir");
        return false;
    }
}
