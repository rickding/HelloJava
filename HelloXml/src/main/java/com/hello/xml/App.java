package com.hello.xml;

import org.dom4j.DocumentException;

import java.io.*;

/**
 * Created by user on 2017/5/26.
 */
public class App {
    public static void main(String[] args) {
        HelloXmlMapper.mapToString();
        HelloXmlMapper.fromString("<Simple><x>3</x><y>4</y></Simple>");

        HelloStAX.mapToString();
        HelloStAX.fromFile("C:\\Work\\x.xml");

        // dom4j, string
        try {
            HelloDOM4j.fromString("<Simple><x>5</x><y>6</y></Simple>");
        } catch (DocumentException e) {
            e.printStackTrace();
        }

        // dom4j, saxReader, inputstream, file
        try {
            HelloDOM4j.fromFile("C:\\Work\\x.xml");
        } catch (DocumentException e) {
            e.printStackTrace();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }
}
