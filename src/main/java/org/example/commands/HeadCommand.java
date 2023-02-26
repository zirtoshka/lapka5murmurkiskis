package org.example.commands;

import org.example.CollectionManager;
import org.example.IO.ConsoleManager;

public class HeadCommand extends Command{
    private final CollectionManager collectionManager;
    public HeadCommand(CollectionManager collectionManager){
        super("head", "print the first elemet of the collecion");
        this.collectionManager=collectionManager;
    }

    @Override
    public boolean execute(String arg){
        ConsoleManager.printInfo1(collectionManager.headOfCollection());
        return true;
    }
}
