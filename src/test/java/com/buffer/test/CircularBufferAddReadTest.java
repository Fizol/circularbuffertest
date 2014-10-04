package com.buffer.test;

import org.junit.Assert;
import org.junit.Test;

import java.util.Collections;
import java.util.HashSet;
import java.util.Set;

public class CircularBufferAddReadTest {

    @Test
    public void shouldOverwriteOldValues() throws Exception {
        CircularBuffer<Integer> buffer = new CircularBuffer<Integer>(3);

        //add 0,1,2,3
        for(int i = 0; i < buffer.size() + 1; i++) {
            buffer.add(i);
        }

        //should be 1,2,3 in the buffer
        Set<Integer> actual = new HashSet<Integer>();
        while(!buffer.isEmpty()) {
            actual.add(buffer.remove());
        }

        Set<Integer> exp = new HashSet<Integer>();
        Collections.addAll(exp, 1, 2, 3);

        Assert.assertEquals(exp, actual);
    }
}