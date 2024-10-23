package org.patterns.Multiton;

public class User {
    private String name;

    public User(String name){
        this.name = name;
    }

    public void write(String path, String addText){
        Document doc = DefinitelyNotGoogleDriveMultiton.getDoc(path);
        doc.write(addText);
    }

    public void nuke(String path){
        Document doc = DefinitelyNotGoogleDriveMultiton.getDoc(path);
        doc.clear();
        doc.write("Okay, let's do this one more time...");
    }

    public void writeName(String path){
        Document doc = DefinitelyNotGoogleDriveMultiton.getDoc(path);
        doc.write("hi, my name is " + this.name + ".");

    }

}
