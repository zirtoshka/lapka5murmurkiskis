package org.example.commands;

import org.example.CollectionManager;
import org.example.IO.ConsoleManager;
import org.example.IO.ScannerManager;
import org.example.description_for_collection.StudyGroup;

import java.util.Scanner;

public class AddIfMaxCommand extends Command{
    private final CollectionManager collectionManager;
    private final ScannerManager scannerManager;
    public AddIfMaxCommand(CollectionManager collectionManager, ScannerManager scannerManager){
        super("add if max {element}","add a new element if the number of students in the new group is more than in the others");
        this.collectionManager=collectionManager;
        this.scannerManager=scannerManager;
    }
    @Override
    public boolean execute(String arg){
        StudyGroup studyGroup = new StudyGroup(
                collectionManager.generateId(),
                scannerManager.askGroupName(),
                scannerManager.askCoordinates(),
                collectionManager.getLastInitTime().now(),
                scannerManager.askStudentCount(),
                scannerManager.askShouldBeExpelled(),
                scannerManager.askAverageMark(),
                scannerManager.askSemesterEnum(),
                scannerManager.askPerson());
        if (studyGroup.getStudentsCount()>collectionManager.getMaxNumberInGroup()){
            collectionManager.addToCollection(studyGroup);
            ConsoleManager.printSuccess("Wow< we have got a new BIG group");
        }else { ConsoleManager.printForNothing("oh, Nothing happened");}
        return true;
    }
    }

