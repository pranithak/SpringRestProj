package com.pranitha.springDI;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * Created by naveen on 1/27/16.
 */
public class DrawingApp {

    public static void main(String args[]){

        ApplicationContext context = new ClassPathXmlApplicationContext("spring.xml");
        Triangle t = (Triangle) context.getBean("triangle");
        t.draw();
    }
}
