package org.example.commands;

import org.example.IO.ConsoleManager;

public class PrintUniqueGroupAdminCommand extends Command{
    public PrintUniqueGroupAdminCommand(){
        super("print_unique_group_admin","вывести уникальные значения поля groupAdmin всех элементов в коллекции");
    }
    @Override
    public boolean execute(String arg){
        ConsoleManager.printInfo("че это такое блять");
        return true;
    }
}
