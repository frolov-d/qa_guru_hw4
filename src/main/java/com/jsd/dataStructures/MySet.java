package com.jsd.dataStructures;

public class MySet<T> {
    private Object[] elements;
    private int size;

    public MySet() {
        elements = new Object[10];
        size = 0;
    }

    public void add(T element) {
        if (!contains(element)) {
            if (size == elements.length) {
                Object[] newElements = new Object[2 * elements.length];
                System.arraycopy(elements, 0, newElements, 0, size);
                elements = newElements;
            }
            elements[size] = element;
            size++;
        }
    }

    public boolean contains(T element) {
        for (int i = 0; i < size; i++) {
            if (elements[i].equals(element)) {
                return true;
            }
        }
        return false;
    }

    public void remove(T element) {
        for (int i = 0; i < size; i++) {
            if (elements[i].equals(element)) {
                for (int j = i; j < size - 1; j++) {
                    elements[j] = elements[j + 1];
                }
                size--;
                break;
            }
        }
    }

    public int size() {
        return size;
    }

    public T get(int index) {
        if (index < 0 || index >= size) {
            throw new IndexOutOfBoundsException("Invalid index: " + index);
        }
        return (T) elements[index];
    }

    public static void main(String[] args) {
        MySet<String> mySet = new MySet<>();
        mySet.add("apple");
        mySet.add("banana");
        mySet.add("cherry");

        for (int i = 0; i < mySet.size(); i++) {
            String element = mySet.get(i);
            System.out.println(element);
        }

    }
}
