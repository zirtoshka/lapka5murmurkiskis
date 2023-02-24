package org.example.commands;

import org.example.CollectionManager;
import org.example.IO.ScannerManager;
import org.example.description_for_collection.StudyGroup;

import java.util.Scanner;

public class AddCommand  extends Command{
    private final CollectionManager collectionManager;
    private final ScannerManager scannerManager;
    public AddCommand(CollectionManager collectionManager, ScannerManager scannerManager){
        super("add {element}", "add a new element to the collection");
        this.collectionManager=collectionManager;
        this.scannerManager=scannerManager;
    }

    public boolean execute(String arg){
//        try {
            if(!arg.isEmpty()){
                collectionManager.addToCollection(
                        new StudyGroup(
                             collectionManager.generateId(),
                             scannerManager.askGroupName(),
                                scannerManager.askCoordinates(),
                                collectionManager.getLastInitTime().now(),
                                scannerManager.askStudentCount(),
                                scannerManager.askShouldBeExpelled(),
                                scannerManager.askAvarageMark(),
                                scannerManager.askSemesterEnum(),
                                scannerManager.askPerson())
                );
            }
//        } catch ()
        return false;
    }


}
