package org.example.commands;

import java.util.Objects;

public abstract class Command {
    private String name;
    private String discription;

    public Command(String name, String discription){
        this.name=name;
        this.discription=discription;
    }

    public abstract boolean execute(String arg);


    public String getName(){
        return name;
    }

    public String getDiscription(){
        return discription;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {return true;}
        if (obj==null || getClass()!=obj.getClass()){return false;}
        Command command = (Command) obj;
        return Objects.equals(name,command.name)&&Objects.equals(discription,command.discription);
    }

    @Override
    public String toString() {
        return "Command{"+
                "name = '"+name+"', discription = '"+
                discription+"}";
    }

    @Override
    public int hashCode() {
        return name.hashCode()+discription.hashCode();
    }
}
