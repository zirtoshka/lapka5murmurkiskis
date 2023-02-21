package org.example;

import java.io.IOException;

public class Main {
    public static void main(String[] args) throws IOException {
//        YamlReader reader = new YamlReader();
//        Map<String, Object> config = reader.read("/Users/zirtoshka/прога/vehvehveh.yml");
//        System.out.println(config);
//        FileManager fileManager= new FileManager("/test.yml");
//        fileManager.loadFromFile(fileManager.getFileName());
        CollectionManager myCollection = new CollectionManager();
        myCollection.loadFromFile();
        myCollection.writeToFile();


    }
}