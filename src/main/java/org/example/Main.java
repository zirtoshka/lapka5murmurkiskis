package org.example;

import org.example.description_for_collection.StudyGroup;
import org.example.parserYAML.ReadYAMLParser;
import org.yaml.snakeyaml.Yaml;

import java.io.IOException;
import java.io.InputStream;
import java.time.LocalDateTime;
import java.util.ArrayDeque;
import java.util.Map;

public class Main {
    public static void main(String[] args) throws IOException {
//        YamlReader reader = new YamlReader();
//        Map<String, Object> config = reader.read("/Users/zirtoshka/прога/vehvehveh.yml");
//        System.out.println(config);
        FileManager fileManager= new FileManager("/test.yml");
        fileManager.loadFromFile(fileManager.getFileName());


    }
}