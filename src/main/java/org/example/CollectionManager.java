package org.example;

import org.example.description_for_collection.StudyGroup;
import org.example.parserYAML.ReadYAMLParser;

import java.io.IOException;
import java.time.LocalDateTime;
import java.util.ArrayDeque;

public class CollectionManager {
    private ArrayDeque<StudyGroup> studyGroupCollection;
    private final LocalDateTime creationDate;
    private final String filename;

    public CollectionManager(String filename) throws IOException {
        this.filename=filename;
        this.creationDate = LocalDateTime.now();
        ReadYAMLParser yaml = new ReadYAMLParser();
        this.studyGroupCollection = yaml.read(filename);
    }



}
