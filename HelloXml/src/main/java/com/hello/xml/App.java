package com.hello.xml;

import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.dataformat.xml.XmlMapper;

import javax.xml.stream.*;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.StringWriter;

/**
 * Created by user on 2017/5/26.
 */
public class App {
    public static void main(String[] args) {
        ObjectMapper xmlMapper = new XmlMapper();

        try {
            String xml = xmlMapper.writeValueAsString(new Simple());
            System.out.println(xml);
        } catch (JsonProcessingException e) {
            e.printStackTrace();
        }

        try {
            xmlMapper.writeValue(new File("x.xml"), new Simple());
        } catch (IOException e) {
            e.printStackTrace();
        }

        try {
            Simple v = xmlMapper.readValue("<Simple><x>3</x><y>4</y></Simple>", Simple.class);
            System.out.println(v);
        } catch (Exception e) {
            e.printStackTrace();
        }

        // Create xml
        XMLInputFactory xmlInputFactory = XMLInputFactory.newFactory();
        XMLOutputFactory xmlOutputFactory = XMLOutputFactory.newFactory();

        try {
            StringWriter out = new StringWriter();
            XMLStreamWriter sw = xmlOutputFactory.createXMLStreamWriter(out);

            XmlMapper mapper = new XmlMapper(xmlInputFactory);
            sw.writeStartDocument();
            ;
            sw.writeStartElement("root");

            Simple s1 = new Simple();
            mapper.writeValue(sw, s1);
            s1.setX(3);
            mapper.writeValue(sw, s1);

            sw.writeComment("comment some");
            sw.writeEndElement();
            sw.writeEndDocument();

            sw.flush();
            sw.close();

            System.out.println(out.toString());
        } catch (XMLStreamException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

        try {
            // Parse xml
            XMLInputFactory f = XMLInputFactory.newFactory();
            File inputFile = new File("C:\\Work\\x.xml");
            XMLStreamReader sr = f.createXMLStreamReader(new FileInputStream(inputFile));

            XmlMapper mapper = new XmlMapper();
            sr.next();

            while (sr.hasNext()) {
                sr.next();
                if (!sr.isStartElement())
                    continue;

                Simple s1 = mapper.readValue(sr, Simple.class);
                System.out.println(s1);
            }

            sr.close();
        } catch (XMLStreamException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
