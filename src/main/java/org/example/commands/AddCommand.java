package org.example.commands;

import org.example.CollectionManager;
import org.example.IO.ScannerManager;

import java.util.Scanner;

public class AddCommand  extends Command{
    private final CollectionManager collectionManager;
    private final ScannerManager scannerManager;
    public AddCommand(CollectionManager collectionManager, ScannerManager scannerManager){
        super("add", "add a new element to the collection");
        this.collectionManager=collectionManager;
        this.scannerManager=scannerManager;
    }

    public boolean execute(String arg){
//        try {
            if(!arg.isEmpty()){

            }
//        } catch ()
    }


}
