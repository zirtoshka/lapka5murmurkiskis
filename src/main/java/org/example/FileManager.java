package org.example;

import org.example.description_for_collection.StudyGroup;
import org.example.parserYAML.ReadYAMLParser;

import java.util.ArrayDeque;

public class FileManager {
    private final String fileName;

    public FileManager(String fileName){
        this.fileName=fileName;
    }


    public String getFileName(){
        return fileName;
    }

}
