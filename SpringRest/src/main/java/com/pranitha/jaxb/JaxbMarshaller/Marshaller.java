package com.pranitha.jaxb.JaxbMarshaller;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Unmarshaller;
import java.io.StringReader;

/**
 * Created by naveen on 2/11/16.
 */
//unmarshalling converting xml to obj
public class Marshaller {


//
//        public Customer convertionXMLtoObj(String xmlfile) throws JAXBException {
//
//
//
//            JAXBContext jaxbContext = JAXBContext.newInstance(Customer.class);
//
//            Unmarshaller jaxbUnmarshaller = jaxbContext.createUnmarshaller();
//            Customer customer = (Customer) jaxbUnmarshaller.unmarshal(new StringReader(xmlfile));
//            System.out.println(customer);
//
//            return customer;
//
//        }
//
//
//        public static void main(String args[]) throws JAXBException {
//            String str = "<customer>\n" +
//                    "  <id>3</id>\n" +
//                    "  <name>string</name>\n" +
//                    "  <age>3</age>\n" +
//                    "  <salary>3</salary>\n" +
//                    "</customer>";
//            Marshaller marshaller = new Marshaller();
//            marshaller.convertionXMLtoObj(str);
//
//        }
//

    }


