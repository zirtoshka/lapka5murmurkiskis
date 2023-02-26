package org.example.commands;

import org.example.CollectionManager;
import org.example.IO.ConsoleManager;

public class ClearCommand extends Command{
    private final CollectionManager collectionManager;
    public ClearCommand(CollectionManager collectionManager){
        super("clear", "clear collection");
        this.collectionManager=collectionManager;
    }

    @Override
    public boolean execute(String arg) {
        collectionManager.clearCollection();
        ConsoleManager.printSuccess("Collection is cleared");
        return false;
    }
}
