package org.example;

import java.io.IOException;
import java.util.Map;

public class Main {
    public static void main(String[] args) throws IOException {
        YamlReader reader = new YamlReader();
        Map<String, Object> config = reader.read("/Users/zirtoshka/прога/vehvehveh.yml");
        System.out.println(config);
    }
}