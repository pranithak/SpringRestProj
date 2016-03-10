package com.pranitha.test;

/**
 * Created by naveen on 3/2/16.
 */
public class Main {
    public static void main(String[] args){
        IShape circle = new Circle();
        circle.Draw();
        Rectangle rectangle = new Rectangle();
        rectangle.Draw();
        Rectangle rectangle1 = new Square();
        rectangle1.Draw();


        }
}
