package org.example.IO;

import org.example.utilities.CommandManager;
import org.example.utilities.HistoryWriter;
import org.example.Main;
import org.example.exceptions.IncorrectScriptException;
import org.example.exceptions.NoAccessToFileException;
import org.example.exceptions.ScriptRecurentException;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.LinkedList;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.Scanner;

public class ConsoleManager {
    private final CommandManager commandManager;
    private final ScannerManager scannerManager;
    private final Scanner scanner;
    private final HistoryWriter historyWriter;
    private final List<String> script = new LinkedList<>();
    private final int NAME_CMD= 0;
    private final int ARG_CMD =1;
    private final int SUCCESSFUL_EXECUTION = 1;
    private final int NOT_SUCCESSFUL_EXECUTION = 0;


    public ConsoleManager(CommandManager commandManager, ScannerManager scannerManager, Scanner scanner, HistoryWriter historyWriter) {
        this.commandManager = commandManager;
        this.scannerManager = scannerManager;
        this.scanner = scanner;
        this.historyWriter = historyWriter;
    }

    public static void printInfoPurple(Object message) {
        System.out.println("\u001B[35m" + message + "\u001B[0m");
    }

    public static void printInfoPurpleBackground(Object message) {
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


    public int launchCmd(String[] userCmd) throws IOException {
        String cmd = userCmd[NAME_CMD];
        String arg = userCmd[ARG_CMD];
        switch (cmd) {
            case "help":
                if (commandManager.help(arg)) {
                    historyWriter.addInHistory("help");
                    return SUCCESSFUL_EXECUTION;
                }
                break;
            case "":
                ConsoleManager.printError("Well... This is an empty line... Maybe you want to ask something?");
                break;
            case "info":
                if (commandManager.info(arg)) {
                    historyWriter.addInHistory("info");
                    return SUCCESSFUL_EXECUTION;
                }
                break;
            case "show":
                if (commandManager.show(arg)) {
                    historyWriter.addInHistory("show");
                    return SUCCESSFUL_EXECUTION;
                }
                break;
            case "add":
                if (commandManager.add(arg)) {
                    historyWriter.addInHistory("add");
                    return SUCCESSFUL_EXECUTION;
                }
                break;
            case "update_by_id":
                if (commandManager.updateById(arg)) {
                    historyWriter.addInHistory("update_by_id");
                    return SUCCESSFUL_EXECUTION;
                }
                break;
            case "remove_by_id":
                if (commandManager.removeById(arg)) {
                    historyWriter.addInHistory("remove_by_id");
                    return SUCCESSFUL_EXECUTION;
                }
                break;
            case "clear":
                if (commandManager.clear(arg)) {
                    historyWriter.addInHistory("clear");
                    return SUCCESSFUL_EXECUTION;
                }
                break;
            case "save":
                if (commandManager.save(arg)) {
                    historyWriter.addInHistory("save");
                    return SUCCESSFUL_EXECUTION;
                }
                break;
            case "execute_script":
                if (commandManager.executeScript(arg)) {
                    historyWriter.addInHistory("execute_script");
                    return scriptMode(arg);
                }
            case "exit":
                if (commandManager.exit(arg)) {
                    historyWriter.addInHistory("exit");
                    return SUCCESSFUL_EXECUTION;
                }
                break;
            case "head":
                if (commandManager.head(arg)) {
                    historyWriter.addInHistory("head");
                    return SUCCESSFUL_EXECUTION;
                }
                break;
            case "add_if_max":
                if (commandManager.addIfMax(arg)) {
                    historyWriter.addInHistory("add_if_max");
                    return SUCCESSFUL_EXECUTION;
                }
                break;
            case "history":
                if (commandManager.history(arg)) {
                    historyWriter.addInHistory("history");
                    return SUCCESSFUL_EXECUTION;
                }
                break;
            case "filter_contains_name":
                if (commandManager.filterContainsName(arg)) {
                    historyWriter.addInHistory("filter_contains_name");
                    return SUCCESSFUL_EXECUTION;
                }
                break;
            case "print_unique_group_admin":
                if (commandManager.printUniqueAdmin(arg)) {
                    historyWriter.addInHistory("print_unique_group_admin");
                    return SUCCESSFUL_EXECUTION;
                }
                break;
            case "print_field_descending_semester_enum":
                if (commandManager.printFieldDescendingSemester(arg)) {
                    historyWriter.addInHistory("print_field_descending_semester_enum");
                    return SUCCESSFUL_EXECUTION;
                }
                break;
            default:
                historyWriter.addInHistory("I don't know this command:((");
                ConsoleManager.printError("No such command as in list");
                break;
        }
        return NOT_SUCCESSFUL_EXECUTION;
    }

    public void toStartMode() throws IOException {
        String[] userCmd = {"", ""};
        int cmdStatus;

        do {
            System.out.print(Main.INPUT_COMMAND);
            userCmd = (scanner.nextLine().trim() + " ").split(" ", 2);
            userCmd[ARG_CMD] = userCmd[ARG_CMD].trim();
            cmdStatus = launchCmd(userCmd);
        } while (cmdStatus != 2);


    }

    public int scriptMode(String arg) throws IOException {
        String path;
        String[] userCmd = {"", ""};
        int cmdStatus;
        script.add(arg);
        try {
            path = System.getenv("PWD") + "/" + arg;
            File file = new File(path);
            if (file.exists() && !file.canRead()) throw new NoAccessToFileException();
            Scanner scriptScanner = new Scanner(file);
            if (!scriptScanner.hasNext()) throw new NoSuchElementException();
            Scanner tmpScanner = scannerManager.getScanner();
            scannerManager.setScanner(scriptScanner);
            scannerManager.setFileMode();
            do {
                userCmd = (scriptScanner.nextLine().trim() + " ").split(" ", 2);
                userCmd[ARG_CMD] = userCmd[ARG_CMD].trim();
                while (scriptScanner.hasNextLine() && userCmd[NAME_CMD].isEmpty()) {
                    userCmd = (scriptScanner.nextLine().trim() + " ").split(" ", 2);
                    userCmd[ARG_CMD] = userCmd[ARG_CMD].trim();
                }
                System.out.println(Main.INPUT_COMMAND + String.join(" ", userCmd));
                if (userCmd[NAME_CMD].equals("execute_script")) {
                    for (String scri : script) {
                        if (userCmd[ARG_CMD].equals(scri)) throw new ScriptRecurentException();
                    }
                }
                cmdStatus = launchCmd(userCmd);
            } while (cmdStatus == SUCCESSFUL_EXECUTION && scriptScanner.hasNextLine());
            scannerManager.setScanner(tmpScanner);
            scannerManager.setUserMode();
            if (cmdStatus == NOT_SUCCESSFUL_EXECUTION && !userCmd[NAME_CMD].equals("execute_script") && userCmd[ARG_CMD].isEmpty())
                throw new IncorrectScriptException();
            return cmdStatus;
        } catch (NoAccessToFileException e) {
            ConsoleManager.printError("No rules");
        } catch (NoSuchElementException e) {
            ConsoleManager.printError("I can't do anything with empty file");
        } catch (FileNotFoundException e) {
            ConsoleManager.printError("No such file with script");
        } catch (ScriptRecurentException e) {
            ConsoleManager.printError("Recurrent is cool, but I don't know how to use it");
        } catch (IncorrectScriptException e) {
            ConsoleManager.printError("Script is incorrect");
        } finally {
            script.remove(script.size() - 1);
        }
        return SUCCESSFUL_EXECUTION;
    }
}


























