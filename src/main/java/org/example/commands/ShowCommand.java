package org.example.commands;

import org.example.CollectionManager;
import org.example.CommandManager;

public class ShowCommand extends Command{
    private final CollectionManager collectionManager;
    public ShowCommand(CollectionManager collectionManager){
        super("show","Show collection");
        this.collectionManager=collectionManager;
    }
    @Override
    public boolean execute(String arg){
        System.out.println(collectionManager);
        return true;
    }

}
