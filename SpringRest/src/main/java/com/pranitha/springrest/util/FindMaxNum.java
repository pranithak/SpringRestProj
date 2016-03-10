package com.pranitha.springrest.util;

/**
 * Created by naveen on 2/3/16.
 */
public class FindMaxNum {

    public int getMax(int a[]){

        int max =a[0];

        for(int i=1;i<a.length;i++){

            if(a[i] > max){
                max = a[i];
            }

           }

        return max;
    }

    public static void main(String args[]){

        System.out.println("finding the maximum number");

        int a[] = { 10,20,8,39,89};

        FindMaxNum fn = new FindMaxNum();
        System.out.println(fn.getMax(a));


    }

}
