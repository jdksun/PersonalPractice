package com.syl.thread.example;


/**
 * Sequence
 *
 * @author Brian Goetz and Tim Peierls
 */

public class Sequence {
 private int nextValue;

    public synchronized int getNext() {
        return nextValue++;
    }
}
