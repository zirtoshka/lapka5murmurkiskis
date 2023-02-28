package org.example.commands;

import org.example.IO.ConsoleManager;

public class ExecuteScriptCommand extends Command{
    public ExecuteScriptCommand(){
        super("execute script <file_name>", "use script from file");
    }
    @Override
    public boolean execute(String arg){
        ConsoleManager.printSuccess("Script? "+arg+" Yes, something's going on in my head ...");
        return true;
    }
}
