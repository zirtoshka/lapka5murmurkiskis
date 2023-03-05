package org.example.commands;

import org.example.CollectionManager;
import org.example.IO.ConsoleManager;
import org.example.description_for_collection.StudyGroup;

public class RemoveByIdCommand extends Command{
    private final CollectionManager collectionManager;
    public RemoveByIdCommand(CollectionManager collectionManager){
        super("remove_by_id", "remove element by id");
        this.collectionManager=collectionManager;
    }

    @Override
    public boolean execute(String arg){
        Integer id =Integer.parseInt(arg);
        StudyGroup studyGroup=collectionManager.getById(id);
        collectionManager.removeById(studyGroup);
        ConsoleManager.printSuccess("Study group was removed");
        return true;
    }
}
