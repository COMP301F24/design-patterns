package org.patterns.Iterator;

import java.util.Arrays;
import java.util.Iterator;
import java.util.NoSuchElementException;

public class AlphabetizerArrayIterator implements Iterator<String> {
    private String[] collection;
    int next;

    public AlphabetizerArrayIterator(String[] collection){
        String[] copy = collection.clone();
        Arrays.sort(copy);
        this.collection = copy;
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
