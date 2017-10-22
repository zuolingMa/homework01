package com.mzl.homework01;

public class ArrayStack implements Stack {
    final private static int DEFAULT_SIZE = 16;
    private Object[] datas;
    private int top = 0;
    
    public ArrayStack() {
        datas = new Object[DEFAULT_SIZE];
        top = 0;
    }
    
    public void push(Object e) {
        if ( top >= datas.length) {
            Object[] temp = new Object[top*2];
            System.arraycopy(datas, 0, temp, 0, top);
            datas = temp;
        }
        datas[top] = e;
        top++;
    }
    
    public Object pop() {
        if (isEmpty()) {
            return null;
        }
        top--;
        return datas[top];
    }
    
    public Object peek() {
       if (isEmpty()) {
            return null;
        }
        return datas[top-1]; 
    }    
    
    public void clear() {
        while (top > 0) {
            top--;
            datas[top] = null;
        }
    }
    
    public int size() {
        return top;
    }
    
    public boolean isEmpty() {
        return top == 0;
    }
}
