package org.patterns.Multiton;

public class User {
    private String name;
    private Document doc;


    public User(String name, String path){
        this.name = name;
        this.doc = DefinitelyNotGoogleDriveMultiton.getDoc(path);
    }

    public Document getDoc(){
        return this.doc;
    }

    public void write(String addText){
        doc.write(addText);
    }

    public void nuke(){
        doc.clear();
        doc.write("Okay, let's do this one more time...");
    }

    public void writeName(){
        doc.write("hi, my name is " + this.name + ".");

    }

}
