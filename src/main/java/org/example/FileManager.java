package org.example;

import org.example.description_for_collection.StudyGroup;
import org.example.parserYAML.ReadYAMLParser;


import java.io.IOException;
import java.util.ArrayDeque;

public class FileManager {
    private final String fileName;

    public FileManager(String fileName){
        this.fileName=fileName;
    }


    public String getFileName(){
        return fileName;
    }

    public ArrayDeque<StudyGroup> loadFromFile(String fileName) throws IOException {
        ReadYAMLParser yaml = new ReadYAMLParser();
        ArrayDeque<StudyGroup> studyGroupCollection = yaml.read(fileName);
        for (StudyGroup a: studyGroupCollection){
            System.out.println(a);
        }
        return studyGroupCollection;
    }

}
