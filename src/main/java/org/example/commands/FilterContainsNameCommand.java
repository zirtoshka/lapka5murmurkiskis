package org.example.commands;

import org.example.CollectionManager;
import org.example.IO.ConsoleManager;
import org.example.description_for_collection.StudyGroup;

public class FilterContainsNameCommand extends Command{
    private final CollectionManager collectionManager;
    public FilterContainsNameCommand(CollectionManager collectionManager){
        super("filter_contains_name", "вывести элементы, значение поля name которых содержит заданную подстроку");
        this.collectionManager=collectionManager;
    }
    @Override
    public boolean execute(String arg){
        String name=arg;
        for (StudyGroup sg: collectionManager.getStudyGroupCollection()
             ) { if(sg.getName().contains(name)){
            ConsoleManager.printInfo1(sg.getName());
        }

        }
        return true;
    }
}
