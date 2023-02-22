package org.example.IO;

import org.example.CommandManager;

import java.util.Scanner;

public class ConsoleManager {
    private CommandManager commandManager;
    private ScannerManager scannerManager;

    public ConsoleManager(CommandManager commandManager, ScannerManager scannerManager){
        this.commandManager=commandManager;
        this.scannerManager=scannerManager;
    }

    public int launchCommand(String[] userCommand){
//        switch ()
        return 0;
    }
    public int scriptMode(String ppp){
        return 0;
    }
}
