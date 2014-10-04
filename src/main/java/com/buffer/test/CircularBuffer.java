package com.buffer.test;

/**
 * This implementation is not type safe.
 * In order to recognize full/empty it leaves one slot empty.
 * <p/>
 * Created by fizol on 02.10.14.
 */
public class CircularBuffer<T> {

    private Object[] buffer;
    private int size = 16;
    private int start = 0;
    private int end = 0;

    public CircularBuffer() {
        buffer = new Object[++this.size];
    }

    public CircularBuffer(int size) {
        if(size <= 0) {
            throw new IllegalArgumentException();
        }
        this.size = ++size;
        buffer = new Object[this.size];
    }

    public void add(T element) {
        buffer[end] = element;
        end = (end + 1) % size;
        if (end == start) {
            //overwrite
            buffer[start] = null;
            start = (start + 1) % size;
        }
    }

    public T remove() throws Exception {
        if (isEmpty()) {
            throw new Exception();
        }
        @SuppressWarnings("unchecked")
        T e = (T) buffer[start];
        start = (start + 1) % size;
        return e;
    }

    public boolean isFull() {
        return (end + 1) % size == start;
    }

    public boolean isEmpty() {
        return start == end;
    }

    public int size() {
        return size - 1;
    }

    //remaining capacity
}
