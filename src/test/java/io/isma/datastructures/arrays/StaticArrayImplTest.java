package io.isma.datastructures.arrays;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class StaticArrayImplTest {


    @Test
    void testingPushBack() {
        StaticArray<Integer> array = new StaticArrayImpl<>(5);

        assertEquals("[]",array.toString()) ;

        array.pushBack(10);
        assertEquals("[10]",array.toString()) ;
        assertEquals(1,array.size());

        array.pushBack(11);
        assertEquals("[10,11]",array.toString()) ;
        assertEquals(2,array.size());


        array.pushBack(12);
        assertEquals("[10,11,12]",array.toString()) ;
        assertEquals(3,array.size());

        array.pushBack(14);
        array.pushBack(15);
        assertEquals("[10,11,12,14,15]",array.toString()) ;
        assertEquals(5,array.size());

        assertThrows(RuntimeException.class, ()-> array.pushBack(16));
        assertEquals(5,array.size());
    }


    @Test
    void testingPushFront() {
        StaticArray<Integer> array = new StaticArrayImpl<>(5);

        assertEquals("[]",array.toString()) ;

        array.pushFront(10);
        assertEquals("[10]",array.toString()) ;
        assertEquals(1,array.size());

        array.pushFront(11);
        assertEquals("[11,10]",array.toString()) ;
        assertEquals(2,array.size());


        array.pushFront(12);
        assertEquals("[12,11,10]",array.toString()) ;
        assertEquals(3,array.size());

        array.pushFront(14);
        array.pushFront(15);
        assertEquals("[15,14,12,11,10]",array.toString()) ;
        assertEquals(5,array.size());

        assertThrows(RuntimeException.class, ()-> array.pushFront(16));
        assertEquals(5,array.size());
    }


    @Test
    void testingPushAt() {
        StaticArray<Integer> array = new StaticArrayImpl<>(5);

        assertEquals("[]",array.toString()) ;

        array.pushAt(0,10);
        assertEquals("[10]",array.toString()) ;
        assertEquals(1,array.size());

        array.pushAt(0,11);
        assertEquals("[11,10]",array.toString()) ;
        assertEquals(2,array.size());
//
//
        array.pushAt(1,12);
        assertEquals("[11,12,10]",array.toString()) ;
        assertEquals(3,array.size());
//
        array.pushAt(2,14);
//        array.pushAt(15);
        assertEquals("[11,12,14,10]",array.toString()) ;
        assertEquals(4,array.size());
//

        array.pushAt(4,15);
        assertThrows(RuntimeException.class, ()-> array.pushAt(0,16));
        assertEquals(5,array.size());
    }


}