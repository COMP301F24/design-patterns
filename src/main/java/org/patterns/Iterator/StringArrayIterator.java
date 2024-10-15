package org.patterns.Iterator;

import java.util.Iterator;
import java.util.NoSuchElementException;

public class StringArrayIterator implements Iterator<String> {
    private String[] collection;
    int next;

    public StringArrayIterator(String[] collection){
        this.collection = collection;
        this.next = 0;
    }

    @Override
    public boolean hasNext() {
        //Better than saying if(){ return true;} else{return false};
        return (this.next < collection.length);
    }

    @Override
    public String next() {
        if (hasNext()) {
          return this.collection[this.next++];
        }
        //Else is not necessary for syntax
        throw new NoSuchElementException("You have reached the end of the collection");
    }


}
