package org.example.parserYAML;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.dataformat.yaml.YAMLFactory;
import com.fasterxml.jackson.dataformat.yaml.YAMLGenerator;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;
import org.example.CollectionManager;
import org.example.description_for_collection.StudyGroup;

import java.io.File;
import java.io.IOException;
import java.util.ArrayDeque;

public class WriteYAMLParses {

    public void write(ArrayDeque<StudyGroup> studyGroupArrayDeque) throws  IOException {
        //тырпы
//        String path  = System.getenv("PWD")+"/pukpuk.yml";
        String path =  "/Users/zirtoshka/IdeaProjects/blydskiyxuy5/pukpuk.yml";
        System.out.println(path);
        File file = new File(path);

        ObjectMapper objectMapper = new ObjectMapper(new YAMLFactory());
        objectMapper.registerModule(new JavaTimeModule());
//        for (StudyGroup a: studyGroupArrayDeque) {
//            objectMapper.writeValue(file, a);
//
//        }
        objectMapper.writeValue(file,studyGroupArrayDeque);

    }

    }
