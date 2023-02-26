package org.example.commands;

import org.example.CollectionManager;
import org.example.IO.ConsoleManager;

import java.io.IOException;

public class SaveCommand extends Command{
    private final CollectionManager collectionManager;
    public SaveCommand(CollectionManager collectionManager){
        super("save", "save to file");
        this.collectionManager=collectionManager;
    }
    @Override
    public boolean execute(String arg) throws IOException {
        //зачем-то решил броситься
        collectionManager.saveCollection();
        ConsoleManager.printSuccess("Collection was saved");
        return true;
    }
}
