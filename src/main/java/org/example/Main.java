package org.example;

import org.example.IO.ConsoleManager;
import org.example.IO.ScannerManager;
import org.example.commands.*;
import org.example.description_for_collection.StudyGroup;

import java.io.IOException;
import java.util.Scanner;

public class Main {
    public static final String INPUT_COMMAND = "$ ";
    public static final String INPUT_INFO = "> ";
    public static void main(String[] args) throws IOException {
        Scanner userScanner=new Scanner(System.in);
        HistoryWriter historyWriter=new HistoryWriter();
        ScannerManager scannerManager = new ScannerManager(userScanner);
        FileManager fileManager=new FileManager(new Scanner(System.in).nextLine());

//        FileManager fileManager = new FileManager(args[0]);
        CollectionManager collectionManager = new CollectionManager(fileManager);
        collectionManager.loadFromFile();
        CommandManager commandManager=new CommandManager(
                new HelpCommand(), new InfoCommand(collectionManager), new ShowCommand(collectionManager),
                new AddCommand(collectionManager,scannerManager), new UpdateByIdCommand(collectionManager,scannerManager),
                new RemoveByIdCommand(collectionManager), new ClearCommand(collectionManager), new SaveCommand(collectionManager),
                new ExecuteScriptCommand(), new ExitCommand(), new HeadCommand(collectionManager), new AddIfMaxCommand(collectionManager,scannerManager),
                new HistoryCommand(historyWriter), new FilterContainsNameCommand(collectionManager), new PrintUniqueGroupAdminCommand(),
                new PrintFieldDescendingSemesterCommand());
        ConsoleManager consoleManager = new ConsoleManager(commandManager,scannerManager,userScanner, historyWriter);
        consoleManager.toStartMode();
//        collectionManager.loadFromFile();
//        collectionManager.writeToFile();
//        System.out.println(collectionManager);


//        StudyGroup rem = new StudyGroup();
//        for (StudyGroup a: collectionManager.getStudyGroupCollection()) {
//            if (a.getId()==2){
//                rem=a;
//            }
////            System.out.println(a.getCreationDate());
//        }
//        System.out.println("trying to remove");
//        collectionManager.removeFromCollection(rem);
//        System.out.println(collectionManager);

//
//        AddCommand add = new AddCommand(collectionManager,scannerManager);
//        add.execute("ssss");
//        System.out.println(collectionManager.getStudyGroupCollection().getLast());
////        collectionManager.getIdSet();

//        InfoCommand info = new InfoCommand(collectionManager);
//        info.execute("ddd");
//        ShowCommand showCommand = new ShowCommand(collectionManager);
//        showCommand.execute("dddd");
//        SaveCommand save = new SaveCommand(collectionManager);
//        save.execute("ddd");
//        ClearCommand clearCommand=new ClearCommand(collectionManager);
//        clearCommand.execute("dddd");
//        HeadCommand head = new HeadCommand(collectionManager);
//        head.execute("dddd");





    }
}