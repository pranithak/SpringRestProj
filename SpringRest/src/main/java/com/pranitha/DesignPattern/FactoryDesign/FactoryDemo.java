package com.pranitha.DesignPattern.FactoryDesign;

/**
 * Created by naveen on 3/6/16.
 */
public class FactoryDemo {

    public static void main(String args[]){
        ShapeFactory sf = new ShapeFactory();

        Shape shape = sf.getShape("circle");
        shape.draw();

        Shape shape1 = sf.getShape("rectangle");
        shape1.draw();

        Shape shape2 = sf.getShape("Square");
        shape2.draw();


    }
}
