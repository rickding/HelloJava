package com.hello.xml;

import com.fasterxml.jackson.dataformat.xml.XmlMapper;
import org.dom4j.Document;
import org.dom4j.DocumentException;
import org.dom4j.DocumentHelper;
import org.dom4j.Element;
import org.dom4j.io.SAXReader;

import java.io.*;

/**
 * Created by user on 2017/5/27.
 */
public class HelloDOM4j {

    public static void fromFile(String path) throws DocumentException, FileNotFoundException {
        InputStream is = null;
        try {
            File file = new File(path);
            is = new FileInputStream(file);

            SAXReader reader = new SAXReader();
            Document doc = reader.read(is);

            Element root = doc.getRootElement();
            root = root.element("Simple");

            parseData(root);
            parseDataWithXmlMapper(root);
        } finally {
            if (is != null) {
                try {
                    is.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    private static void parseDataWithXmlMapper(Element ele) {
        if (null == ele) {
            System.out.println("DOM4J: " + "Element is null");
            return;
        }

        String str = ele.asXML();

        XmlMapper mapper = new XmlMapper();
        try {
            Simple data = mapper.readValue(str, Simple.class);
            System.out.println("DOM4J: " + data.toString());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static void parseData(Element ele) {
        if (null == ele) {
            System.out.println("DOM4J: " + "Element is null");
            return;
        }

        Element x = ele.element("x");
        Element y = ele.element("y");

        Simple data = new Simple();
        data.setX(Integer.valueOf(x.getTextTrim()));
        System.out.println("DOM4J: " + data.toString() + ", " + y.getTextTrim());
    }

    public static void fromString(String xml) throws DocumentException{
        Document doc = DocumentHelper.parseText(xml);
        Element root = doc.getRootElement();

        parseData(root);
        parseDataWithXmlMapper(root);
    }
}
