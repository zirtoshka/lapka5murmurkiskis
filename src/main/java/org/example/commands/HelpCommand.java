package org.example.commands;

public class HelpCommand extends Command{
    public HelpCommand(){
        super("help", "display help on available commands");
    }

    @Override
    public boolean execute(String arg){
        System.out.println("хз что это и как");
        return true;
    }
}
