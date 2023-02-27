package org.example;

import org.example.IO.ConsoleManager;
import org.example.IO.ScannerManager;
import org.example.commands.*;
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

        CommandManager commandManager=new CommandManager();
        ScannerManager scannerManager = new ScannerManager(new Scanner(System.in));
        ConsoleManager consoleManager = new ConsoleManager(commandManager,scannerManager);
        myCollection.loadFromFile();
        myCollection.writeToFile();
        System.out.println(myCollection);

        StudyGroup rem = new StudyGroup();
        for (StudyGroup a: myCollection.getStudyGroupCollection()) {
            if (a.getId()==2){
                rem=a;
            }
//            System.out.println(a.getCreationDate());
        }
        System.out.println("trying to remove");
        myCollection.removeFromCollection(rem);
        System.out.println(myCollection);

//
//        AddCommand add = new AddCommand(myCollection,scannerManager);
//        add.execute("ssss");
//        System.out.println(myCollection.getStudyGroupCollection().getLast());
////        myCollection.getIdSet();

//        InfoCommand info = new InfoCommand(myCollection);
//        info.execute("ddd");
//        ShowCommand showCommand = new ShowCommand(myCollection);
//        showCommand.execute("dddd");
//        SaveCommand save = new SaveCommand(myCollection);
//        save.execute("ddd");
//        ClearCommand clearCommand=new ClearCommand(myCollection);
//        clearCommand.execute("dddd");
//        HeadCommand head = new HeadCommand(myCollection);
//        head.execute("dddd");





    }
}