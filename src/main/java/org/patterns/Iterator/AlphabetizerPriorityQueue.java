package org.patterns.Iterator;

import java.util.Iterator;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.PriorityQueue;

public class AlphabetizerPriorityQueue implements Iterator<String> {
    PriorityQueue<String> queue;

    public AlphabetizerPriorityQueue(String[] collection){
        String[] copy = collection.clone();
        this.queue = new PriorityQueue<String>(List.of(copy));
    }

    @Override
    public boolean hasNext(){
        return !this.queue.isEmpty();
    }

    @Override
    public String next(){
        if (hasNext()) {
          return this.queue.poll();
        }

        throw new NoSuchElementException();
    }

}
