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
//    public void getIdSet(){
//        for(Integer a:idSet){
//            System.out.print(a+" ");
//        }
//    }
    private Integer newId = 1;
    private FileManager fileManager;
//    FileManager fileManager = new FileManager(new Scanner(System.in).nextLine());
    private java.time.LocalDateTime lastInitTime;
    private LocalDateTime lastSaveTime;



    public CollectionManager(FileManager fileManager) {
        this.lastInitTime=null;
        this.lastSaveTime=null;
        this.fileManager=fileManager;
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
    public void clearCollection(){ studyGroupCollection.clear();}
    public void saveCollection() throws IOException {
        fileManager.write(studyGroupCollection); //зачем-то хочет бросатьтся хз
        lastSaveTime = LocalDateTime.now();
    }
    public String headOfCollection(){
        return studyGroupCollection.getFirst().toString();
    }
    public StudyGroup getById(Integer id){
        for (StudyGroup studyGroup: studyGroupCollection){
            if (studyGroup.getId().equals(id)){
                return studyGroup;
            }
        }
        return null;
    }
    public void removeFromCollection(StudyGroup studyGroup){
        studyGroupCollection.remove(studyGroup);
    }
    public void removeById(StudyGroup studyGroup){
        idSet.remove(studyGroup.getId());
        studyGroupCollection.remove(studyGroup);
    }
    public int getMaxNumberInGroup(){
        int res =-1;
        for(StudyGroup group: studyGroupCollection){
            if (group.getStudentsCount()>res){
                res=group.getStudentsCount();}}
        return res;}

    @Override
    public String toString() {
        if (studyGroupCollection.isEmpty()){
            return "Collection is empty(((";
        }
        StringBuilder info = new StringBuilder();
        for (StudyGroup studyGroup: studyGroupCollection){
            info.append(studyGroup.toString());
            if (studyGroup!=studyGroupCollection.getLast()){
                info.append("\n\n");
            }
        }
        return info.toString();
    }


    //запихнуть в метод??????


}
