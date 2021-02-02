package com.hello;

import java.io.*;
import org.apache.pdfbox.*;

public class PDFUtil {
    /**
     * 读PDF文件，使用了pdfbox开源项目
     */
    public static void readPDF(String fileName) {
        File file = new File(fileName);
        FileInputStream in = null;
        try {
            in = new FileInputStream(fileName);

            // 新建一个PDF解析器对象
            PDFParser parser = new PDFParser(new RandomAccessFile(file, "rw"));

            // 对PDF文件进行解析
            parser.parse();

            // 获取解析后得到的PDF文档对象
            PDDocument pdfdocument = parser.getPDDocument();

            // 新建一个PDF文本剥离器
            PDFTextStripper stripper = new PDFTextStripper();
            stripper.setSortByPosition(sort); //sort设置为true 则按照行进行读取，默认是false

            // 从PDF文档对象中剥离文本
            String result = stripper.getText(pdfdocument);
            FileWriter fileWriter = new FileWriter(new File("pdf.txt"));
            fileWriter.write(result);
            fileWriter.flush();
            fileWriter.close();
            System.out.println("PDF文件的文本内容如下：");
            System.out.println(result);
        } catch (Exception e) {
            System.out.println("读取PDF文件" + file.getAbsolutePath() + "生失败！" + e);
            e.printStackTrace();
        } finally {
            if (in != null) {
                try {
                    in.close();
                } catch (IOException e1) {
                }
            }
        }
    }
}
