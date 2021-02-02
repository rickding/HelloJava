package com.hello;

/**
 * Hello world!
 */
public class App {
    public static void main(String[] args) {
        System.out.println("Hello World!");


        String fileName = "测试.pdf";
        PDFUtil.readPDF(fileName);
    }
}
