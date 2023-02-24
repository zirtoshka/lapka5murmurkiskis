package org.example;

import com.fasterxml.jackson.datatype.jsr310.ser.LocalDateSerializer;
import org.example.description_for_collection.StudyGroup;
import org.example.parserYAML.WriteYAMLParses;

import java.io.IOException;
import java.time.LocalDateTime;
import java.util.ArrayDeque;
import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class CollectionManager {
    private ArrayDeque<StudyGroup> studyGroupCollection;
    private Set<Integer> idSet = new HashSet<>(); //буду чекать среди сущ id
    private Integer newId = 1;
    FileManager fileManager = new FileManager(new Scanner(System.in).nextLine());
    private java.time.LocalDateTime lastInitTime;
    private LocalDateTime lastSaveTime;



    public CollectionManager() {
        this.lastInitTime=null;
        this.lastSaveTime=null;
    }

    public void loadFromFile() throws IOException {
        this.studyGroupCollection = fileManager.loadFromFile();
        for (StudyGroup stg: studyGroupCollection) {
            idSet.add(stg.getId());
        }
    }

    public void writeToFile() throws IOException {
        fileManager.write(studyGroupCollection);
    }

    public ArrayDeque<StudyGroup> getStudyGroupCollection() {
        return studyGroupCollection;
    }

    public Integer generateId() {
        while (!idSet.add(newId)) {
            newId++;
        }
//        System.out.println(newId);
        return newId;
    }
    public void addToCollection(StudyGroup studyGroupFromUser){
        studyGroupCollection.addLast(studyGroupFromUser);
    }
    public LocalDateTime getLastInitTime(){
        return lastInitTime;
    }
    public LocalDateTime getLastSaveTime(){return lastSaveTime;}
    public String collectionType(){
        return studyGroupCollection.getClass().getName();
    }
    public int collectionSize(){
        return studyGroupCollection.size();
    }






    //запихнуть в метод??????


}
