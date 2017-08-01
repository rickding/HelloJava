package com.hello;

import java.util.*;

/**
 * Created by user on 2017/8/1.
 */
public class CustomSort {
    public static void main(String[] args) {
//        int[] arr = {3, 1, 2, 2, 4};
        int[] arr = {8, 5, 5, 5, 5, 1, 1, 1, 4, 4};
        int[] results = customSort(arr);
        System.out.println(results);
    }

    public static class Item {
        private int value;
        private int frequency;

        public Item(int value) {
            this.value = value;
            this.frequency = 1;
        }

        public void addFrequency() {
            this.frequency++;
        }

        public int getFrequency() {
            return frequency;
        }

        public int getValue() {
            return value;
        }
    }

    public static class ItemComparator implements Comparator<Item> {
        @Override
        public int compare(Item o1, Item o2) {
            int ret = o1.getFrequency() - o2.getFrequency();
            if (ret == 0) {
                ret = o1.getValue() - o2.getValue();
            }
            return ret;
        }
    }

    public static int[] customSort(int[] arr) {
        if (arr == null || arr.length <= 0) {
            return null;
        }

        // Scan and calculate the frequency
        HashMap<Integer, Item> itemHashMap = new HashMap<Integer, Item>();
        for (int v : arr) {
            Item item = itemHashMap.get(v);
            if (item == null) {
                item = new Item(v);
                itemHashMap.put(v, item);
            } else {
                item.addFrequency();
            }
        }

        // Sort the new items
        Collection<Item> itemSet = itemHashMap.values();
        Item[] items = new Item[itemSet.size()];
        itemSet.toArray(items);
        Arrays.sort(items, new ItemComparator());

        // Restore the items as expected results
        int i = 0;
        for (Item item : items) {
            for (int j = 0; j < item.getFrequency(); j++) {
                arr[i++] = item.getValue();
            }
        }

        // Print
        for (int v : arr) {
            System.out.println(v);
        }

        return arr;
    }
}
