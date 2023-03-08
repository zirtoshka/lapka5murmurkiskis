package org.example.commands;

import org.example.CollectionManager;
import org.example.IO.ConsoleManager;
import org.example.description_for_collection.StudyGroup;

import java.util.HashSet;
import java.util.Set;

public class PrintUniqueGroupAdminCommand extends Command {
    private final CollectionManager collectionManager;

    public PrintUniqueGroupAdminCommand(CollectionManager collectionManager) {
        super("print_unique_group_admin", "вывести уникальные значения поля groupAdmin всех элементов в коллекции");
        this.collectionManager = collectionManager;
    }

    @Override
    public boolean execute(String arg) {
        Set<String> nameSet1 = new HashSet<>();
        Set<String> nameSet2 = new HashSet<>();
        for (StudyGroup sg : collectionManager.getStudyGroupCollection()
        ) {
            if (!nameSet1.add(sg.getGroupAdmin().getName())) {
                nameSet2.add(sg.getGroupAdmin().getName());
            }
        }
        for (String a : nameSet2
        ) {
            nameSet1.remove(a);
        }
        ConsoleManager.printInfo(nameSet1);
        return true;
    }
}



