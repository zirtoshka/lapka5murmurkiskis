package org.example;

import org.example.commands.Command;

import java.util.LinkedList;
import java.util.List;

public class CommandManager {
    private final List<Command> commands = new LinkedList<>();
    private final Command helpCmd;
    private final Command infoCmd;
    private final Command showCmd;
    private final Command addCmd;
    private final Command updateByIdCmd;
    private final Command removeByIdCmd;
    private final Command clearCmd;
    private final Command saveCmd;
    private final Command executeFileCmd;
    private final Command exitCmd;
    private final Command headCmd;
    private final Command addIfMaxCmd;
    private final Command historyCmd;
    private final Command filterContainsNameCmd;
    private final Command printUniqueAdminCmd;
    private final Command printFieldDescendingSemesterCmd;


    public CommandManager(Command helpCmd, Command infoCmd, Command showCmd,
                          Command addCmd, Command updateByIdCmd, Command removeByIdCmd,
                          Command clearCmd, Command saveCmd, Command executeFileCmd, Command exitCmd, Command headCmd,
                          Command addIfMaxCmd, Command historyCmd, Command filterContainsNameCmd, Command printUniqueAdminCmd,
                          Command printFieldDescendingSemesterCmd) {
        this.helpCmd=helpCmd;
        this.infoCmd=infoCmd;
        this.showCmd=showCmd;
        this.addCmd=addCmd;
        this.updateByIdCmd=updateByIdCmd;
        this.removeByIdCmd=removeByIdCmd;
        this.clearCmd=clearCmd;
        this.saveCmd=saveCmd;
        this.executeFileCmd=executeFileCmd;
        this.exitCmd=exitCmd;
        this.addIfMaxCmd=addIfMaxCmd;
        this.historyCmd=historyCmd;
        this.headCmd=headCmd;
        this.filterContainsNameCmd=filterContainsNameCmd;
        this.printFieldDescendingSemesterCmd=printFieldDescendingSemesterCmd;
        this.printUniqueAdminCmd=printUniqueAdminCmd;

        commands.add(helpCmd);//why not this.helpCmd????????
        commands.add(infoCmd);
        commands.add(showCmd);
        commands.add(addCmd);
        commands.add(updateByIdCmd);
        commands.add(removeByIdCmd);
        commands.add(clearCmd);
        commands.add(saveCmd);
        commands.add(executeFileCmd);
        commands.add(exitCmd);
        commands.add(addIfMaxCmd);
        commands.add(historyCmd);
        commands.add(filterContainsNameCmd);
        commands.add(printFieldDescendingSemesterCmd);
        commands.add(printUniqueAdminCmd);
    }

}
