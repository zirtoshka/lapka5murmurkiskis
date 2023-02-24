package org.example;

import org.example.IO.ScannerManager;
import org.example.commands.AddCommand;
import org.example.description_for_collection.StudyGroup;

import java.io.IOException;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws IOException {
//        YamlReader reader = new YamlReader();
//        Map<String, Object> config = reader.read("/Users/zirtoshka/прога/vehvehveh.yml");
//        System.out.println(config);
//        FileManager fileManager= new FileManager("/test.yml");
//        fileManager.loadFromFile(fileManager.getFileName());
        CollectionManager myCollection = new CollectionManager();
        myCollection.loadFromFile();
        myCollection.writeToFile();

        for (StudyGroup a: myCollection.getStudyGroupCollection()) {
            System.out.println(a.getCreationDate());
        }
        myCollection.generateId();
        ScannerManager scannerManager = new ScannerManager(new Scanner(System.in));
        AddCommand add = new AddCommand(myCollection,scannerManager);
        add.execute("ssss");
        System.out.println(myCollection.getStudyGroupCollection().getLast());





    }
}