package org.example;

import org.example.description_for_collection.StudyGroup;
import org.example.parserYAML.WriteYAMLParses;

import java.io.IOException;
import java.util.ArrayDeque;
import java.util.Scanner;
import java.util.Set;

public class CollectionManager {
    private ArrayDeque<StudyGroup> studyGroupCollection;
    private Set<Integer> idSet; //буду чекать среди сущ id
    FileManager fileManager= new FileManager(new Scanner(System.in).nextLine());


    public CollectionManager(){
    }

    public void loadFromFile() throws IOException{
        this.studyGroupCollection = fileManager.loadFromFile();
    }

    public void writeToFile() throws IOException {
        fileManager.write(studyGroupCollection);
    }

    public ArrayDeque<StudyGroup> getStudyGroupCollection(){
        return  studyGroupCollection;
    }





    //запихнуть в метод??????




}
