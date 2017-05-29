package com.hello.junit;

import org.junit.Test;

import java.util.LinkedList;
import java.util.List;

import static org.mockito.Mockito.*;

/**
 * Created by user on 2017/5/29.
 * http://blog.csdn.net/zhanganbo/article/details/52288080
 */
public class AppJUnit4MockitoTest {

    @Test
    public void testVerify() {
        // mock creation
        List mockedList = mock(List.class);

// using mock object - it does not throw any "unexpected interaction" exception
        mockedList.add("one");
        mockedList.clear();

// selective, explicit, highly readable verification
        verify(mockedList).add("one");
        verify(mockedList).clear();
    }

    @Test
    public void testStub() {
// you can mock concrete classes, not only interfaces
        LinkedList mockedList = mock(LinkedList.class);

// stubbing appears before the actual execution
        when(mockedList.get(0)).thenReturn("first");

// the following prints "first"
        System.out.println(mockedList.get(0));

// the following prints "null" because get(999) was not stubbed
        System.out.println(mockedList.get(999));
    }
}
