package org.example.IO;

import org.example.CollectionManager;
import org.example.CommandManager;
import org.example.HistoryWriter;
import org.example.Main;

import java.io.IOException;
import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;
import java.util.SortedMap;

public class ConsoleManager {
    private CommandManager commandManager;
    private ScannerManager scannerManager;
    private final Scanner scanner;
    private final HistoryWriter historyWriter;
    private final List<String> script = new LinkedList<>();

    public ConsoleManager(CommandManager commandManager, ScannerManager scannerManager, Scanner scanner, HistoryWriter historyWriter) {
        this.commandManager = commandManager;
        this.scannerManager = scannerManager;
        this.scanner = scanner;
        this.historyWriter = historyWriter;
    }

    public static void printInfo(Object message) {
        System.out.println("\u001B[35m" + message + "\u001B[0m");
    }

    public static void printInfo1(Object message) {
        System.out.println("\u001B[45m" + message + "\u001B[0m");
    }

    public static void printForNothing(Object message) {
        System.out.println("\u001B[36m" + message + "\u001B[0m");
    }

    public static void printSuccess(Object message) {
        System.out.println("\u001B[42m" + message + "\u001B[0m");
    }

    public static void printError(Object message) {
        System.out.println("\u001B[33m" + message + "\u001B[0m");
    }

    public int launchCommand(String[] userCommand) {
//        switch ()
        return 0;
    }

    //DELETE IOEXCEPTION!!!!!!!!????????/
    public int scriptMode(String[] userCmd) throws IOException {
        String cmd=userCmd[0];
        String arg = userCmd[1];
        switch (cmd){
            case "help":
                if(!commandManager.help(arg)){
                    historyWriter.addInHistory("help");
                    return 1;
                }
                break;
            case "":
                ConsoleManager.printError("Well... This is an empty line... Maybe you want to ask something?");
                break;
            case "info":
                if(!commandManager.info(arg)){
                    historyWriter.addInHistory("info");
                   return 1;
                }
                break;
            case "show":
                if (!commandManager.show(arg)){
                    historyWriter.addInHistory("show");
                    return 1;
                } break;
            case "add":
                if (!commandManager.add(arg)){
                    historyWriter.addInHistory("add");
                    return 1;
                }break;
            case "update_by_id":
                if(!commandManager.updateById(arg)){
                    historyWriter.addInHistory("update_by_id");
                    return 1;
                }break;
            case "remove_by_id":
                if(!commandManager.removeById(arg)){
                    historyWriter.addInHistory("remove_by_id");
                    return 1;
                }break;
            case "clear":
                if(!commandManager.clear(arg)){
                    historyWriter.addInHistory("clear");
                    return 1;
                }break;
            case "save":
                if(!commandManager.save(arg)){
                    historyWriter.addInHistory("save");
                    return 1;
                } break;
            case "execute_script":
                if(!commandManager.executeScript(arg)){
                    historyWriter.addInHistory("execute_script");
                    return 1;
                } break;
            case "exit":
                if(!commandManager.exit(arg)){
                    historyWriter.addInHistory("exit");
                    return 1;
                }break;
            case "head":
                if(!commandManager.head(arg)){
                    historyWriter.addInHistory("head");
                    return 1;
                }break;
            case "add_if_max":
                if(!commandManager.addIfMax(arg)){
                    historyWriter.addInHistory("add_if_max");
                    return 1;
                }break;
            case "history":
                if(!commandManager.history(arg)){
                    historyWriter.addInHistory("history");
                    return 1;
                }break;
            case "filter_contains_name":
                if(!commandManager.filterContainsName(arg)){
                    historyWriter.addInHistory("filter_contains_name");
                    return 1;
                }break;
            case "print_unique_group_admin":
                if(!commandManager.printUniqueAdmin(arg)){
                    historyWriter.addInHistory("print_unique_group_admin");
                    return 1;
                }break;
            case "print_field_descending_semester_enum":
                if(!commandManager.printFieldDescendingSemester(arg)){
                    historyWriter.addInHistory("print_field_descending_semester_enum");
                    return 1;
                }break;
            default:
                historyWriter.addInHistory("I don't know this command:((");
                ConsoleManager.printError("No such command as in list");
                break;
        }
        return 0;
    }

    public void toStartMode() {
        String[] userCmd = {"", ""};
        int cmdStatus;

        do {
            System.out.println(Main.INPUT_COMMAND);
            userCmd = (scanner.nextLine().trim() + " ").split(" ", 2);
            userCmd[1] = userCmd[1].trim();
            cmdStatus = launchCommand(userCmd);
        } while (cmdStatus != 1);


    }
}


























