package com.hello.xml;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.dataformat.xml.XmlMapper;

import java.io.File;
import java.io.IOException;

/**
 * Created by user on 2017/5/27.
 */
public class HelloXmlMapper {
    public static void fromString(String xml) {
        ObjectMapper xmlMapper = new XmlMapper();

        try {
            Simple v = xmlMapper.readValue(xml, Simple.class);
            System.out.println("XmlMapper: " + v);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void mapToString() {
        ObjectMapper xmlMapper = new XmlMapper();

        try {
            String xml = xmlMapper.writeValueAsString(new Simple());
            System.out.println("XmlMapper: "+ xml);
        } catch (JsonProcessingException e) {
            e.printStackTrace();
        }

        try {
            xmlMapper.writeValue(new File("x.xml"), new Simple());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
