package com.hello;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

/**
 * Created by user on 2017/6/17.
 */
public class DictOrder {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        long n = sc.nextLong();

        // Read the input
        ArrayList arA = new ArrayList<Long>(256);
        for (int i = 0; i < n; i++) {
            arA.add(sc.nextLong());
        }

        ArrayList arB = new ArrayList<Long>(256);
        for (int i = 0; i < n; i++) {
            arB.add(sc.nextLong());
        }

        sc.close();

        System.out.println(findPath(n, arA, arB));
    }

    /**
     * 求到达小区n-1的方案中，字典序最小的字符串。
     • 当没有合法的选择序列时，输出 “No solution!”。
     • 当字典序最小的字符串无限长时，输出 “Infinity!”。
     • 否则，输出这个选择字符串。
     * @param n
     * @param arA
     * @param arB
     * @return
     */
    public static String findPath(long n, ArrayList arA, ArrayList arB) {
        if (n <= 0 || arA == null || arB == null) {
            return "No solution!";
        }

        /*
        在每个小区 i 里有两种选择：
        1) 选择a：向前 a[i] 个小区。
        2) 选择b：向前 b[i] 个小区。
        把每步的选择写成一个关于字符 ‘a’ 和 ‘b’ 的字符串。
        求到达小区n-1的方案中，字典序最小的字符串。
        如果做出某个选择时，你跳出了这n个小区的范围，则这个选择不合法。*/

        String path = ""; // The path to the current area so far
        int index = 0; // the index of current area
        Set<Long> pathA = new HashSet<Long>();
        Set<Long> pathB = new HashSet<Long>(); // The past paths of area B

//        while (

        return path;
    }
}