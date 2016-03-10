package com.pranitha.jaxb.JaxbMarshaller;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import java.io.StringWriter;

/**
 * Created by naveen on 2/11/16.
 */
public class UnMarshaller {


//   public String convertionOfXmltoObj(Customer customer) throws JAXBException {
//
//
//        JAXBContext jaxbContext = JAXBContext.newInstance(Customer.class);
//        Marshaller jaxbMarshaller = (Marshaller) jaxbContext.createMarshaller();
//
//        // output pretty printed
//       jaxbMarshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);
//
//       StringWriter stringWriter = new StringWriter();
//       jaxbMarshaller.marshal(customer, stringWriter);
//
//       // Convert StringWriter to String
//       String xml = stringWriter.toString();
//       //System.out.println(xml);        jaxbMarshaller.marshal(customer, System.out);
//
//        return xml;
//}
//
//public static void main(String args[]) throws JAXBException {
//
//    Customer customer = new Customer();
//    customer.setId(1);
//    customer.setAge(23);
//    customer.setName("prani");
//    customer.setSalary(20000);
//    UnMarshaller unMarshaller = new UnMarshaller();
//    System.out.println(unMarshaller.convertionOfXmltoObj(customer));
//}

}
