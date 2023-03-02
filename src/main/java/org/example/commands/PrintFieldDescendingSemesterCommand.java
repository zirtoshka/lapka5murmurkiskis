package org.example.commands;

import org.example.IO.ConsoleManager;

public class PrintFieldDescendingSemesterCommand extends Command{
    public PrintFieldDescendingSemesterCommand(){
        super("print field descending semester enum", "вывести значения поля semesterEnum всех элементов в порядке убывания");
    }
    @Override
    public boolean execute(String arg){
        ConsoleManager.printInfo("че это такое блять");
        return true;
    }
}
