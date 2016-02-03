package com.pranitha.springDI;

/**
 * Created by naveen on 1/27/16.
 */
public class Triangle {

   private Point pointA;
    private Point pointB;
    private Point pointC;

    public Point getPointA() {
        return pointA;
    }

    public void setPointA(Point pointA) {
        System.out.println("test method in point a");
        this.pointA = pointA;
    }

    public Point getPointC() {
        return pointC;
    }

    public void setPointC(Point pointC) {
        this.pointC = pointC;
    }

    public Point getPointB() {
        return pointB;
    }

    public void setPointB(Point pointB) {
        this.pointB = pointB;
    }

    public void draw(){

        System.out.println("PointA = (" + getPointA().getX() + "," + getPointA().getY() + ")");
        System.out.println("PointB = (" + getPointB().getX() + "," + getPointB().getY() + ")");
        System.out.println("PointC = (" + getPointC().getX() + "," + getPointC().getY() + ")");

    }

}
