package org.example;

import org.example.description_for_collection.StudyGroup;

import java.util.ArrayDeque;

public class CollectionManager {
    private FileManager fileManager;
    private ArrayDeque<StudyGroup> StudyGroupCollection = new ArrayDeque<>();


//    public CollectionManager(FileManager fileManager){
//        this.fileManager=fileManager;
//        loadCollection();
//    }

//    private void loadCollection(){
//        StudyGroupCollection=fileManager.readCollection();
//    }

}
