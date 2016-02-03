package com.pranitha.springrest.model;

/**
 * Created by naveen on 1/25/16.
 */
public class SumImpl implements Sum{


    public int add(int a, int b) {
        int c = a+b;
        return c;
    }
}
