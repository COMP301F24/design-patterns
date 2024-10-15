package org.patterns.Iterator.InternalListIterator;

import java.util.Iterator;

/**
 * A class that implements the MyList<E> interface using a linked list of nodes.
 *
 * @author Prairie Goodwin
 * @version 1.1
 */
public class MyLinkedList<E> implements MyList<E>, Iterable<E>{
    /* A reference to the first node on the list */
    private Node<E> headNode = null;
    /* Keeps track of the list's size */
    private int size = 0;

    private class MyLinkedListIterator<E> implements Iterator<E>{
        private Node<E> next;

        public MyLinkedListIterator(){
           this.next = (Node<E>) MyLinkedList.this.headNode;
        }

        @Override
        public boolean hasNext() {
            return (this.next != null);
        }

        @Override
        public E next() {
            E retval = this.next.getValue();
            this.next = this.next.getNext();
            return retval;
        }
    }

    @Override
    public Iterator<E> iterator() {
        return new MyLinkedListIterator<>();
    }

    /**
     * List constructor.
     * @return an empty list.
     */
    public MyLinkedList(){ }

    /**
     * Returns the number of elements on the list.
     *
     * @return the number of elements on the list.
     */
    public int size(){ return this.size; };

    /**
     * Appends a new element to the end of the list.
     *
     * @param elem the element to add to the list.
     * @return always returns true.
     */
    public boolean add(E elem){
        // traverse the list all the way to the end
        Node<E> prev = null;
        for (Node<E> cur = headNode; cur != null; prev = cur, cur = cur.getNext());

        Node<E> newNode = new Node(elem);
        if (prev == null) this.headNode = newNode;// inserting at head
        else prev.setNext(newNode);

        this.size++; // register one more element
        
        return true; // required by interface
    }

    /**
     * Helper method to reduce code duplication when checking index bounds.
     * 
     * @param idx the index to be checked.
     * @param upperBound the valid range's upper limit.
     * @throws IndexOutOfBoundsException if idx not in range [0,upperBound].
     */
    private void checkBounds(int idx, int upperBound) throws IndexOutOfBoundsException{
        if (idx < 0 || idx > upperBound){
            String emsg = String.format("Invalid idx %d, [0,%d] needed", idx, upperBound);
            throw new IndexOutOfBoundsException(emsg);
        }
    }
    
    /**
     * Adds a new element to the list at the index specified as an argument.
     *
     * @param  idx  the index at which the new element should be found once it
     *              has been added to the list.
     * @param elem the element to add to the list.
     * @throws IndexOutOfBoundsException if index not in range [0,size()].
     */
    public void add(int idx, E elem) throws IndexOutOfBoundsException{
        this.checkBounds(idx, this.size); // index bounds check

        // traverse list until desired index is reached
        Node<E> cur = headNode, prev = null;
        for (int i=0; i < idx; prev = cur, cur = cur.getNext(), i++);

        Node<E> newNode = new Node(elem, cur);
        if (prev == null) this.headNode = newNode; // inserting at head
        else prev.setNext(newNode); // inserting elsewhere

        this.size++; // register one more element
    }

    /**
     * Removes and returns the list element located at the index specified as an argument.
     *
     * @param idx the index at which the element to be removed resides.
     * @throws IndexOutOfBoundsException if index not in range [0,size()-1].
     * @return the element removed.
     */
    public E remove(int idx) throws IndexOutOfBoundsException{
        this.checkBounds(idx, this.size-1); // index bounds check

        // traverse list until desired index is reached
        Node<E> cur = headNode, prev = null;
        for (int i=0; i < idx; prev = cur, cur = cur.getNext(), i++);

        if (prev == null) headNode = cur.getNext(); // we are removing the 1st node
        else prev.setNext(cur.getNext()); // general case

        this.size--; // one fewer element

        return cur.getValue(); // return value of removed node
    }

    /**
     * Returns the list element stored at the index specified as an argument.
     *
     * @param idx the index of the element to be retrieved.
     * @throws IndexOutOfBoundsException if index not in range [0,size()-1].
     * @return the element at the specified index.
     */
    public E get(int idx) throws IndexOutOfBoundsException{
        this.checkBounds(idx, this.size-1); // index bounds check
        
        // traverse list until desired index is reached
        Node<E> cur = headNode;
        for (int i=0; i < idx; cur = cur.getNext(), i++);

        return cur.getValue(); // return value of relevant node
    }

    /**
     * Returns the index at which the element passed as an argument can be found
     * on the list. Equality is determined by the equals(Object o) method,
     * defined in the Object class, and potentially overridden by the element's class.
     * If elem appears multiple times on the list, the lowest index at which it can
     * be found is returned. If the element is not present in the list, -1 is returned.
     *
     * @param elem the element we're trying to find.
     * @return the index of the first ocurrence of elemement elem, or -1 if not found.
     */
    public int indexOf(E elem){
        // traverse list looking for elem
        int i = 0;
        for (Node<E> cur = headNode; cur != null; cur = cur.getNext(), i++)
            if (cur.getValue().equals(elem)) return i; // found the element of interest

        return -1; // nothing was found
    }

    /**
     * Returns a textual representation of the list elements in the format "{elem1, elem2, .., elemn}".
     * E.g. A list with elements 1, 2 and 3 should return "{1, 2, 3}".
     * 
     * @return the string representation of the list.
     */
    public String toString(){
        String s = "{";
        for(Node<E> cur = headNode; cur != null; cur = cur.getNext()){
            s += cur.getValue();
            if (cur.getNext() != null) s += ", ";
        }
        return s + "}";
    }
}