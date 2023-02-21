package org.example.commands;

public class InfoCommand extends Command{
    public InfoCommand(){
        super("info", "print information about the collection");
    }

    @Override
    public boolean execute(String arg){
        return false;
    }
}
