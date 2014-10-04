package com.buffer.test;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

public class CircularBufferTest {

    private CircularBuffer<Object> buffer;

    @Before
    public void setUp() throws Exception {
        buffer = new CircularBuffer<Object>();
    }

    @Test
    public void newBufferIsEmpty() {
        assertTrue(buffer.isEmpty());
    }

    @Test
    public void newBufferIsNotFull() {
        CircularBuffer<Object> buffer = new CircularBuffer<Object>();

        assertFalse(buffer.isFull());
    }

    @Test
    public void bufferAfterAddElementIsNotEmpty() throws Exception {
        buffer.add(new Object());
        assertFalse(buffer.isEmpty());
    }

    @Test
    public void bufferAfterAddOneElementAndRemoveIsEmpty() throws Exception {

        buffer.add(new Object());
        buffer.remove();

        assertTrue(buffer.isEmpty());
    }

    @Test
    public void bufferAfterGettingFullSizeIsFull() throws Exception {

        //when is full
        for (int i = 0; i < buffer.size(); i++) {
            buffer.add(i);
        }

        assertTrue(buffer.isFull());
    }

    @Test
    public void bufferAfterGettingFullSizeIsNotEmpty() throws Exception {

        //when is full
        for (int i = 0; i < buffer.size(); i++) {
            buffer.add(i);
        }

        assertFalse(buffer.isEmpty());
    }

    @Test
    public void bufferBeforeGettingFullIsNotFull() throws Exception {

        //when is almost full
        for(int i = 0; i < buffer.size() - 1; i++) {
            buffer.add(i);
        }

        assertFalse(buffer.isFull());
    }

    @Test
    public void bufferBeforeGettingFullIsNotEmpty() throws Exception {

        //when is almost full
        for(int i = 0; i < buffer.size() - 1; i++) {
            buffer.add(i);
        }

        assertFalse(buffer.isEmpty());
    }

    @Test(expected = Exception.class)
    public void shouldThrowExceptionIfRemoveFromEmptyBuffer() throws Exception {
        buffer.remove();
    }

    @Test
    public void shouldReturnTheSameValueAfterAddOne() throws Exception {
        Object e = new Object();
        buffer.add(e);
        assertTrue(e.equals(buffer.remove()));
    }
}