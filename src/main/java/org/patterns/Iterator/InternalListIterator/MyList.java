package org.patterns.Iterator.InternalListIterator;

/**
 * An interface specifying the operations that should be supported
 * by a simple list data structure.
 *
 * @author Prairie Goodwin
 * @version 1.1
 */
public interface MyList<E>{
    
    /**
     * Returns the number of elements on the list.
     *
     * @return the number of elements on the list.
     */
    public int size();

    /**
     * Appends a new element to the end of the list.
     *
     * @param elem the element to add to the list.
     * @return always returns true.
     */
    public boolean add(E elem);

    /**
     * Adds a new element to the list at the index specified as an argument.
     *
     * @param  idx  the index at which the new element should be found once it
     *              has been added to the list.
     * @param elem the element to add to the list.
     * @throws IndexOutOfBoundsException if index not in range [0,size()].
     */
    public void add(int idx, E elem) throws IndexOutOfBoundsException;

    /**
     * Removes and returns the list element located at the index specified as an argument.
     *
     * @param idx the index at which the element to be removed resides.
     * @return the element removed.
     * @throws IndexOutOfBoundsException if index not in range [0,size()-1].
     */
    public E remove(int idx) throws IndexOutOfBoundsException;
    
    /**
     * Returns the list element stored at the index specified as an argument.
     *
     * @param idx the index of the element to be retrieved.
     * @return the element at the specified index.
     * @throws IndexOutOfBoundsException if index not in range [0,size()-1].
     */
    public E get(int idx) throws IndexOutOfBoundsException;

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
    public int indexOf(E elem);

    /**
     * Returns a textual representation of the list elements in the format "{elem1, elem2, .., elemn}".
     * E.g. A list with elements 1, 2 and 3 should return "{1, 2, 3}".
     * 
     * @return the string representation of the list.
     */
    public String toString();
}