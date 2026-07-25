package io.isma.datastructures.arrays;

public interface StaticArray<T> {
    int size();




    // Find / Changing
    T get(int index);
    void set(int index, T value);
    int indexOf(T value) ;
    boolean contains(T value);

    String toString() ;

    // Removing
    void clear();
    T popBack();
    T popFront();
    T popAt(int index);

    // Adding
    void pushBack(T value);
    void pushFront(T value);
    void pushAt(int index, T value);

}
