package org.patterns.Iterator.InternalListIterator;

import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.TestMethodOrder;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;


/**
 * A class with unit tests for a MyList list implementation.
 * It tests the MyLinkedList class but is designed to be able to
 * be extended for testing other MyList implementations.
 * For that, subclasses need only override the
 * createEmptyIntList() method.
 * The tests try to test all methods and corner cases.
 * We recommend you tackle them (i.e. try to make them pass) in the
 * order they appear in this file.
 * Tests have been updated to JUnit 5.8.1, and to remove Explicit Boxing
 * constructors which have deprecated and marked for removal.
 *
 * @author  Rui Meireles
 * @author  Prairie Goodwin
 * @version 2.0
*/

@TestMethodOrder(MethodOrderer.MethodName.class)//@FixMethodOrder(MethodSorters.NAME_ASCENDING)
class MyLinkedListTest {

    // # integers to use in testing. should be 10 * 2^i to test array at capacity.
    private static final int NINTS = 20;

    /**
     * A factory method to create an empty list of integers using the
     * implementation of MyList we're trying to test.
     * @return an empty list of integers.
     */
    protected MyList<Integer> createEmptyIntegerList(){
        return new MyLinkedList<>();
    }

    /**
     * Tests whether adding nodes at the tail of the list is reflected on the list's size.
     */

//    @Test
//    public void testSize(){
//        MyLinkedList<Integer> list = new MyLinkedList<>();
//        assertEquals(0, list.size);
//    }


    @Test
    public void test1AddTailAndSize(){
        MyList<Integer> list = createEmptyIntegerList(); // new empty list
        assertEquals(0, list.size(),"Initial list size not zero");

        for (Integer i=1; i <= NINTS; i++){ // add an element at a time, and check list size increases
            //System.out.println("adding element " + i);
            list.add(i);
            assertEquals( i, list.size(),"List size doesn't match number of added elements");
        }
    }

    /**
     * Tests adding at the tail of the list and checking the elements are at the proper indices.
     */
    @Test
    public void test2AddTailAndIndexOf(){
        MyList<Integer> list = createEmptyIntegerList(); // new empty list
        Integer one = 1;
        assertEquals(-1, list.indexOf(one)); // element that that doesn't exist

        for (Integer i=0; i < NINTS; i++){ // add an element at a time, and check that it's in the right place
            list.add(i);
            assertEquals(i, list.indexOf(i));
        }

        for (Integer i=0; i < NINTS; i++){ // are they still in the right place?
            assertEquals(list.indexOf(i), i);
        }
        assertEquals(-1, list.indexOf(NINTS + 2));  // element that doesn't exist
        list.add(one); // repeat element
        assertEquals(1, list.indexOf(one));  // index of first occurrence should be returned
    }

    /**
     * Tests adding at the tail of the list and then retrieving the elements that have been added.
     */
    @Test
    public void test3AddTailAndGet(){
        MyList<Integer> list = createEmptyIntegerList(); // new empty list

        for (int i=0; i < NINTS; i++){ // add an element at a time, and check that it's there
            Integer li = i;
            list.add(li);
            assertEquals(i, list.get(i));
        }

        for (int i=0; i < NINTS; i++){ // are they still there?
            assertEquals(i, list.get(i));
        }

        // test index boundaries
        String fmsg = "Invalid index to get() should throw IndexOutOfBoundsException";
        try{
            list.get(-1); // invalid index (too small)
            fail(fmsg);
        } catch(IndexOutOfBoundsException e){}

        try{
            list.get(NINTS); // invalid index (too large)
            fail(fmsg);
        } catch(IndexOutOfBoundsException e){}
    }

    /**
     * A helper to avoid code duplication. Appends integers 0 through n-1 to list.
     *
     * @param list the list to append to.
     * @param n the number of integers to append.
     */
    protected void addNints(MyList<Integer> list, int n){
        for (Integer i=0; i < n; i++){ // add n elements
            list.add(i);
        }
    }

    /**
     * Checks list contains integers from low+offset to high+offset, in order, at indices low too high.
     * @param list The list we're checking.
     * @param low The smallest index we're checking.
     * @param high The largest index we're checking.
     * @param offset The values' offset relative to the index they're stored at.
     */
    protected static void checkListContents(MyList<Integer> list, int low, int high, int offset){
        // (hint) debugging techniques for when things go wrong:
        //    - set up a breakpoint and use the debugger
        //    - print the list's contents

        // check that all elements are there and in the proper order
        for (int i=low; i <= high; i++){
            final Integer val = i + offset;
            assertEquals(i, list.indexOf(val));
            assertEquals(val, list.get(i));
        }
    }

    /**
     * A helper to avoid code duplication.
     * Removes item at index idx (expected value val)
     * from a list that is supposed to contain integers
     * 0 through the list's size -1.
     *
     * @param list the list to remove from.
     * @param idx the index of the item that should be removed.
     */
    private void testRemoveSingle(MyList<Integer> list, int idx, int val){
        int n = list.size();
        assertEquals(val, list.remove(idx)); // element at index 50 is no Integerer
        assertEquals(n-1, list.size()); // list now has length n- 1
        checkListContents(list, 0, idx-1, 0); // check contents
        checkListContents(list, idx, n-2, 1); // check contents
    }

    /**
     * Tests element removal.
     * Test assumes add() (tail version), size(), get(), and indexOf() are working properly.
     */
    @Test
    public void test4Remove(){
        MyList<Integer> list = createEmptyIntegerList(); // new empty list

        // test removing from the tail
        this.addNints(list, NINTS);
        for (int i=NINTS-1; i >= 0; i--){
            assertEquals(i, list.remove(i));
            assertEquals(i, list.size()); // list size should decrease
            checkListContents(list, 0, i-1, 0); // is everything else ok?
        }

        // test removing from the head
        this.addNints(list, NINTS);
        for (int i=0; i < NINTS; i++){
            assertEquals(i, list.remove(0));
            int nleft = NINTS-i-1;
            assertEquals(nleft, list.size()); // list size should decrease
            checkListContents(list, 0, nleft-1, i+1); // is everything else ok?
        }

        // test removing from the middle
        int idx = NINTS/2;
        this.addNints(list, NINTS);
        testRemoveSingle(list, idx,idx);
        int nleft = NINTS - 1;

        // test index boundaries
        String fmsg = "Invalid index to remove() should throw IndexOutOfBoundsException";
        try{
            list.remove(-1); // invalid index (too small)
            fail(fmsg);
        } catch(IndexOutOfBoundsException e){}

        try{
            list.remove(nleft); // invalid index (too large)
            fail(fmsg);
        } catch(IndexOutOfBoundsException e){}

        // random removal until list becomes empty
        for(int i=nleft; i > 0; i--){
            int rndIdx = (int) (Math.random()*i);
            list.remove(rndIdx);
            assertEquals(i-1, list.size());
        }
    }

    /**
     * Tests element addition (indexed version).
     * Test assumes size(), get(), indexOf(), and remove() are working properly.
     */
    @Test
    public void test5AddIndexed(){
        MyList<Integer> list = createEmptyIntegerList(); // new empty list

        // test adding at the tail
        for (int i=0; i < NINTS; i++){
            final Integer li = i;
            list.add(i, li); // tail add
            assertEquals(i+1, list.size()); // list size should increase
            checkListContents(list, 0, i, 0); // everything in its right place?
        }

        // test adding at the head
        list = createEmptyIntegerList(); // hard reset
        for (int i=0; i < NINTS; i++){
            final int val = NINTS-1-i;
            final Integer lval = val;
            list.add(0, lval); // head add
            assertEquals(i+1, list.size()); // list size should increase
            checkListContents(list, 0, i, val); // everything in its right place?
        }

        // test adding in the middle
        int idx = NINTS/2;
        testRemoveSingle(list, idx,idx); // remove element at index NINTS/12
        list.add(idx,idx); // add it back where it was originally
        assertEquals(NINTS, list.size()); // list noe has length NINTS again
        checkListContents(list, 0, NINTS-1, 0); // check contents

        // test adding at odd indices
        list = createEmptyIntegerList(); // hard reset
        for (int i=0; i < NINTS; i+=2) // add all the evens
            list.add(i/2, i); // tail add
        for (int i=1; i < NINTS; i+=2){ // add all the odds
            list.add(i, i); // inserts in the middle
            checkListContents(list, 0, i, 0); // everything in its right place?
        }

        // test random-index insertion
        list = createEmptyIntegerList(); // hard reset
        for (int i=0; i < NINTS; i++){
            final int rndIdx = (int) (Math.random()*i);
            final Integer li = i;
            list.add(rndIdx,li);
            assertEquals(i+1, list.size());
        }
        int[] carr = new int[NINTS]; // counts array
        for (int i=0; i < NINTS; i++){ // how many times does each elem appear on the list?
            int elem =  list.get(i);
            carr[elem]++;
        }
        for(int c : carr) assertEquals(1, c); // each element must appear exactly once

        // test index boundaries
        String fmsg = "Invalid index to add() should throw IndexOutOfBoundsException";
        Integer zero = 0;
        try{
            list.add(-1, zero); // invalid index (too small)
            fail(fmsg);
        } catch(IndexOutOfBoundsException e){}

        try{
            list.add(NINTS+1, zero); // invalid index (too large)
            fail(fmsg);
        } catch(IndexOutOfBoundsException e){}
    }

    /**
     * Tests the list's toString() to see if it conforms with the specification.
     */
    @Test
    public void test6ToString(){
        MyList<Integer> list = createEmptyIntegerList(); // new empty list
        this.addNints(list, NINTS);
        String listStr = list.toString();

        // create a reference string "{elem1, elem2, ..., elemn}"
        String refStr = "{";
        for(int i = 0; i < NINTS-1; i++)
            refStr += i + ", ";
        refStr += NINTS-1 + "}";

        assertEquals(refStr, listStr); // compare the two strings
    }
}