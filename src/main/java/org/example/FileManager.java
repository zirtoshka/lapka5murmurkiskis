package org.example;

import org.example.description_for_collection.StudyGroup;
import org.example.parserYAML.ReadYAMLParser;
import org.example.parserYAML.WriteYAMLParses;


import java.io.IOException;
import java.util.ArrayDeque;

public class FileManager {
    private final String path;
    private final String fileName;

    public FileManager(String fileName){
        this.fileName = fileName;
        path = System.getenv("PWD")+fileName;
    }


    public String getFileName(){
        return fileName;
    }
    public String getPath(){return path;}

    public ArrayDeque<StudyGroup> loadFromFile() throws IOException {
        ReadYAMLParser yaml = new ReadYAMLParser();
        ArrayDeque<StudyGroup> studyGroupCollection = yaml.read(path);
//        for (StudyGroup a: studyGroupCollection){
//            System.out.println(a);
//        }
        return studyGroupCollection;
    }
    public void write(ArrayDeque<StudyGroup> studyGroupCollection) throws IOException{
        WriteYAMLParses writeYAMLParses = new WriteYAMLParses();
        writeYAMLParses.write(studyGroupCollection);
    }


}
