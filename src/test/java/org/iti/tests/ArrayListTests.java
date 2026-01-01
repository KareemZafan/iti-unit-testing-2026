package org.iti.tests;


import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
public class ArrayListTests {

    @Mock
    ArrayList<Integer> list;


    @Test
    void testAddReturnItemsFromArrayList() {
        when(list.get(10)).thenReturn(1000).thenReturn(500);

        assertEquals(1000,list.get(10));
        assertEquals(500,list.get(10));


    }

    @Test
    void testArrayListSize() {
        when(list.size()).thenReturn(200);

        assertEquals(200, list.size());


    }



}
