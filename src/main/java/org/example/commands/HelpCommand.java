package org.example.commands;

public class HelpCommand extends Command{
    public HelpCommand(){
        super("help", "display help on available commands");
    }

    @Override
    public boolean execute(String arg){
        return false;
    }
}
