package org.example.commands;

import org.example.CollectionManager;
import org.example.IO.ConsoleManager;
import org.example.description_for_collection.StudyGroup;

public class PrintFieldDescendingSemesterCommand extends Command{
    private final CollectionManager collectionManager;
    public PrintFieldDescendingSemesterCommand(CollectionManager collectionManager){
        super("print_field_descending_semester_enum", "вывести значения поля semesterEnum всех элементов в порядке убывания");
        this.collectionManager=collectionManager;
    }
    @Override
    public boolean execute(String arg){
        int[] count= new int[]{0,0,0};
        for (StudyGroup sg:collectionManager.getStudyGroupCollection()
             ) {switch (sg.getSemesterEnum().name()){
            case "FIRST":
                count[0]+=1;
                break;
            case "SECOND":
                count[1]+=1;
                break;
            case "FIFTH":
                count[2]+=1;
                break;
        }
        }
        for (int i=0;i<3;i++){
            for(int j=0;j<count[i];j++){
                switch (i){
                    case 0:
                        System.out.println("FIRST");
                        break;
                    case 1:
                        System.out.println("SECOND");
                        break;
                    case 2:
                        System.out.println("FIFTH");
                        break;
                }
            }
        }
        return true;
    }
}
