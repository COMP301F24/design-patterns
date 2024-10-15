package org.patterns.Iterator.InternalListIterator;
/**
 * A simple class to represent a linked list node.
 *
 * @author Rui Meireles
 * @version 1.1
 */
public class Node<E>{
    /* The value stored at this node */
    private E value;
  
    /* A reference to the next node in the list */
    private Node<E> next;

    /**
     * Constructs a new node with the value passed in as an argument and a
     * next reference to a node passed as an argument.
     * @param value the value to store in the node.
     * @param next the node coming next on the list.
     */
    public Node(E value, Node<E> next){
        this.value = value;
        this.next = next;
    }
    
    /**
     * Constructs a new node with the value passed in as an argument and a
     * null next reference.
     * @param value the value to store in the node.
     */
    public Node(E value){
        this(value, null);
    }
    
    /**
     * Returns the value stored inside this node.
     * @return the value stored inside this node.
     */
    public E getValue(){
        return this.value;
    }

    /**
     * Sets the value of this node to the value passed as an argument.
     * @param value value to be stored inside this node.
     */
    public void setValue(E value){
        this.value = value;
    }

    /**
     * Returns the next reference stored in this node, which represents
     * the next node on the linked list.
     * @return the next reference stored in this node.
     */
    public Node<E> getNext(){
        return this.next;
    }

    /**
     * Sets this node's next reference, which represents the next node
     * on the linked list, to the value passed as an argument.
     * @param next next node reference to be stored in the node.
     */
    public void setNext(Node<E> next){
        this.next = next;
    }
}