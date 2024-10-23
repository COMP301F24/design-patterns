package org.patterns.Multiton;

public class Document {
    private String text = "New Document\n";

    public String read(){
        return this.text;
    }

    public void write(String moreText){
        this.text += moreText + "\n";
    }

    public void clear(){
        this.text = "";
    }

    @Override
    public String toString(){
        return this.text;
    }
}
