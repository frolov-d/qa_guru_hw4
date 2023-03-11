package com.jsd.dataStructures;

import java.util.Iterator;

public class MyList<T> implements Iterable<T> {
    private T[] elements;
    private int size;

    public MyList() {
        elements = (T[]) new Object[10];
        size = 0;
    }

    public void add(T element) {
        if (size == elements.length) {
            T[] newElements = (T[]) new Object[2 * elements.length];
            System.arraycopy(elements, 0, newElements, 0, size);
            elements = newElements;
        }
        elements[size] = element;
        size++;
    }

    public T find(T element) {
        for (int i = 0; i < size; i++) {
            if (elements[i].equals(element)) {
                return elements[i];
            }
        }
        return null;
    }

    public void remove(T element) {
        int index = -1;
        for (int i = 0; i < size; i++) {
            if (elements[i].equals(element)) {
                index = i;
                break;
            }
        }
        if (index != -1) {
            for (int i = index; i < size - 1; i++) {
                elements[i] = elements[i + 1];
            }
            size--;
        }
    }

    public int size() {
        return size;
    }

    public T get(int index) {
        if (index < 0 || index >= size) {
            throw new IndexOutOfBoundsException("Invalid index: " + index);
        }
        return elements[index];
    }

    @Override
    public Iterator<T> iterator() {
        return new MyListIterator();
    }

    private class MyListIterator implements Iterator<T> {
        private int currentIndex;

        public MyListIterator() {
            currentIndex = 0;
        }

        @Override
        public boolean hasNext() {
            return currentIndex < size;
        }

        @Override
        public T next() {
            if (!hasNext()) {
                throw new java.util.NoSuchElementException();
            }
            return elements[currentIndex++];
        }
    }

    public static void main(String[] args) {
        MyList<String> myList = new MyList<>();

        myList.add("apple");
        myList.add("banana");
        myList.add("cherry");

        for (int i = 0; i < myList.size; i++) {
            String element = myList.get(i);
            System.out.println(element);
        }

    }
}
