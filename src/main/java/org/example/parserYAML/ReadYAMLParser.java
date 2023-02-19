package org.example.parserYAML;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.fasterxml.jackson.dataformat.yaml.YAMLFactory;
import com.fasterxml.jackson.dataformat.yaml.YAMLGenerator;
import org.example.description_for_collection.StudyGroup;
import org.yaml.snakeyaml.Yaml;


import javax.xml.parsers.DocumentBuilderFactory;
import java.io.*;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayDeque;
import java.util.LinkedList;
import java.util.Map;
import java.util.Objects;

public class ReadYAMLParser {

    public void read(String filename) throws FileNotFoundException, IOException {
        //тырпы
        File file = new File(System.getenv("PWD")+filename);
        ObjectMapper objectMapper = new ObjectMapper(new YAMLFactory());
        ArrayDeque<StudyGroup> collectionFromFile = objectMapper.readValue(file, objectMapper.getTypeFactory().constructCollectionType(ArrayDeque.class, StudyGroup.class));

        System.out.println(collectionFromFile);

        //snakeyaml is кринж
//        File file = new File(System.getenv("PWD")+ filename);
//        System.out.println(file+"ddddd");
//        FileInputStream fileInputStream = new FileInputStream(file);
//        Yaml yaml = new Yaml();
//        Map<String, Object> obj = yaml.load(fileInputStream);
//        for (String p : obj.keySet()) {
//            System.out.println(p);
//        }
//        System.out.println(obj);

    }



}

