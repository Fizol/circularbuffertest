package com.buffer.test;

/**
 * Created by fizol on 04.10.14.
 */
public class CuncurrentCircularBuffer<T> {

    private CircularBuffer<T> buffer = new CircularBuffer<T>();
    private volatile boolean semaphore = true;

    public void add(T e) {
        semaphore = false;
        while(true) {
            if(semaphore) {
                //is it visible to other threads?
                buffer.add(e);
                semaphore = true;
                break;
            }
        }
    }

    public T remove() throws Exception {
        semaphore = false;
        T e;
        while(true) {
            if(semaphore) {
                e = buffer.remove();
                semaphore = true;
                break;
            }
        }
        return e;
    }
}
