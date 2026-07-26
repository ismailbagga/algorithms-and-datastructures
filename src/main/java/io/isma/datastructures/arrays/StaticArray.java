package io.isma.datastructures.arrays;

public class StaticArray<T> implements Array<T>{
    private int size;
    private int capacity;
    private T[] array ;

    public StaticArray(int capacity) {
        this.size = 0;
        if (capacity <= 0) throw new IllegalArgumentException("capacity can not be less than < 0");
        this.capacity = capacity;
        //noinspection unchecked
        this.array = (T[]) new Object[capacity];

    }

    @Override
    public String toString() {
        StringBuilder builder = new StringBuilder("[") ;
        for (int index=0 ; index < size-1 ; index ++) {
            builder.append(array[index]);
            builder.append(",");
        }
        if (size != 0) builder.append(array[size-1]);
        builder.append("]");
        return builder.toString();
    }

    @Override
    public int size() {
        return size;
    }


    @Override
    public void pushBack(T value) {

        if(size== capacity) throw new RuntimeException("the static array is full");
        array[size++] = value ;

    }



    @Override
    public void pushFront(T value) {
        if (size == capacity) throw new RuntimeException("the static array is full");
        pushFrontLeftShifting(value);
    }
    private void pushFrontLeftShifting(T value) {
        for (int index = size ; index >  0 ; index--) {
            array[index] = array[index-1];
        }
        array[0] = value ;
        size++ ;

    }

    private void pushFrontRightShifting(T value) {


        T prevValue = null ;
        T temp = null ;
        if (size != 0 ) prevValue = array[0] ;
        for (int index = 1 ; index <= size ; index++) {

            temp = array[index] ;
            array[index] = prevValue;
            prevValue = temp;

        }
        array[0] = value ;
        size++ ;
    }




    @Override
    public void pushAt(int insertAt, T value) {
        if (size == capacity)  throw new RuntimeException("the static array is full");
        if (insertAt < 0 || insertAt > size ) throw  new IndexOutOfBoundsException("index out of range") ;
        for (int index = size  ; index > insertAt ;index-- ) {
            array[index]  = array[index-1] ;
        }
        array[insertAt] = value ;
        size++ ;
    }


    @Override
    public T get(int index) {
        if (index < 0 || index >= size) {
            throw  new IndexOutOfBoundsException("Index: " + index + ", Size: " + size);
        }
        return this.array[index];
    }

    @Override
        public void set(int index, T value) {
            if (index < 0 || index >= this.size  ) throw  new IndexOutOfBoundsException("Index: " + index + ", Size: " + size);
        this.array[index] = value ;

    }

    @Override
    public int indexOf(T value) {
        for (int i = 0; i < size ; i++) {
            if (value == array[i]) return i ;
        }

        return -1;
    }

    @Override
    public boolean contains(T value) {
        return indexOf(value) != -1;
    }

    @Override
    public void clear() {
        for (int index = 0 ; index < size ; index++) {
            array[index] = null ;
        }
        this.size = 0 ;

    }

    @Override
    public T popBack() {
        if (size == 0 ) throw new RuntimeException("the array is empty");

        var temp = array[size-1];
        array[size-1] = null ;
        size--;
        return temp;


    }

    @Override
    public T popFront() {
        return popAt(0);
    }

    @Override
    public T popAt(int popAt) {

        if (size == 0 ) throw new RuntimeException("the array is empty");
        var temp = array[popAt];
        for (int index = popAt + 1 ; index < size ; index++){
            array[index-1] = array[index];
        }
        array[size-1]  = null ;
        size--;
        return temp;

    }

}
