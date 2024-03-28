package collections;

import java.util.ArrayList;
import java.util.EmptyStackException;

/*
Простая реализация стека на основе ArrayList
 */
public class Stack<T> {
    private ArrayList<T> arr = new ArrayList<>();
    private int size = 0;

    public void push(T obj) {
        arr.add(obj);
        size++;
    }

    public T pop() {
        if (size == 0)
            throw new EmptyStackException();
        size--;
        return arr.get(size);
    }

    public int size() {
        return size;
    }
} 