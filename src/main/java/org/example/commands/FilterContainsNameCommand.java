package org.example.commands;

import org.example.IO.ConsoleManager;

public class FilterContainsNameCommand extends Command{
    public FilterContainsNameCommand(){
        super("filter contains name", "вывести элементы, значение поля name которых содержит заданную подстроку");
    }
    @Override
    public boolean execute(String arg){
        ConsoleManager.printInfo("че это такое блять");
        return true;
    }
}
