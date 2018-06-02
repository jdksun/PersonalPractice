package com.syl.thread.example;


/**
 * UnsafeSequence
 *
 * @author Brian Goetz and Tim Peierls
 */

public class UnsafeSequence {
    private int value;

    /**
     * Returns a unique value.
     */
    public int getNext() {
        return value++;
    }
}
