package org.example.commands;

import org.example.HistoryWriter;
import org.example.IO.ConsoleManager;

public class HistoryCommand extends Command{
    private final HistoryWriter historyWriter;
    public HistoryCommand(HistoryWriter historyWriter){
        super("history","View last 12 commands");
        this.historyWriter=historyWriter;
    }
    @Override
    public boolean execute(String arg){
        String[] history = historyWriter.getHistory();
        System.out.println("Last 12 commands:");
        for (String s:history){
            if (!(s==null)){
                ConsoleManager.printSuccess(s);
            }
        }
        return true;
    }

}
