package com.pranitha.springrest.util;

/**
 * Created by naveen on 2/3/16.
 */
public class FindMinNum {


    public int getMinNum(int a[]){

        int min=a[0];

        for(int i=1;i<a.length;i++){

            if(a[i]<min){

                min=a[i];
            }
        }
        return min;
    }


    public static void main(String args[]){

       int a[]={5,10,8,70,9,1};

        FindMinNum fm = new FindMinNum();
        System.out.println(fm.getMinNum(a));
    }

}
