package com.pranitha.DesignPattern.FactoryDesign;

/**
 * Created by naveen on 3/6/16.
 */
public class ShapeFactory {

    public Shape getShape(String shapeType){
        if(shapeType== null){
            return null;
        }
        if(shapeType.equalsIgnoreCase("CIRCLE")){
            return new Circle();
        }
        if(shapeType.equalsIgnoreCase("RECTANGLE")){
            return new Rectangle();
        }
        if(shapeType.equalsIgnoreCase("SQUARE")){
            return new Square();
        }
        return null;

    }

}
