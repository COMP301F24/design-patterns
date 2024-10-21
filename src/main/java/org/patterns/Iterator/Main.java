package org.patterns.Iterator;

import org.patterns.Iterator.InternalListIterator.MyLinkedList;
import java.util.Iterator;


public class Main {
    public static void main(String[] args) {
        MyLinkedList<Integer> myList = new MyLinkedList<>();
        myList.add(0);
        myList.add(1);
        myList.add(2);
        myList.add(3);
        myList.add(4);
        myList.add(5);


        Iterator<Integer> iterator = myList.iterator();

        for(int i : myList){
            i++;
        }



        while(iterator.hasNext()){
            System.out.println(iterator.next());
        }



    }
}