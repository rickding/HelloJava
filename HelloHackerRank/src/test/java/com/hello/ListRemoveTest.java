package com.hello;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/**
 * @author dingxl
 * @date 3/16/2021 7:05 PM
 */
public class ListRemoveTest {
    @Test
    public void testListRemoveException() {
        List<String> list = new ArrayList<String>() {{
            add("0");
            add("1");
            add("2");
            add("3");
            add("4");
        }};

        for (int i = 0; i < list.size(); i++) {
            if (i % 2 == 0) {
                System.out.printf("remove: %s\n", list.get(i));
                list.remove(i);
            } else {
                System.out.printf("keep: %s\n", list.get(i));
            }
        }
    }

    @Test
    public void testListRemove() {
        List<String> list = new ArrayList<String>() {{
            add("0");
            add("1");
            add("2");
            add("3");
            add("4");
        }};

        for (int i = list.size() - 1; i >= 0; i--) {
            if (i % 2 == 0) {
                System.out.printf("remove: %s\n", list.get(i));
                list.remove(i);
            } else {
                System.out.printf("keep: %s\n", list.get(i));
            }
        }
    }

    @Test
    public void testIteratorRemove() {
        List<String> list = new ArrayList<String>() {{
            add("0");
            add("1");
            add("2");
            add("3");
            add("4");
        }};

        Iterator<String> it = list.iterator();
        while (it.hasNext()) {
            String str = it.next();
            if (Integer.parseInt(str) % 2 == 0) {
                System.out.printf("remove: %s\n", str);
                it.remove();
            } else {
                System.out.printf("keep: %s\n", str);
            }
        }
    }
}
