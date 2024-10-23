package org.patterns.Multiton;

import java.util.HashMap;
import java.util.Map;

public class DefinitelyNotGoogleDriveMultiton {
    private static Map<String, Document> drive = new HashMap<>();

    private DefinitelyNotGoogleDriveMultiton() {}

    public static Document getDoc(String path){
        if(!drive.containsKey(path)){
            Document doc = new Document();
            drive.put(path, doc);
            return doc;
        } else {
            return drive.get(path);
        }
    }
}
