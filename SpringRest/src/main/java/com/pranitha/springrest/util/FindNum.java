package com.pranitha.springrest.util;

/**
 * Created by naveen on 2/3/16.
 */
public class FindNum {
    public int findnum(int a[], int b){
        for(int i=0;i<a.length;i++){
            if(b == a[i]){
              return i;
            }
        }
        return -1;
    }

    public static void main(String args[]){
        FindNum num = new FindNum();
        int a[] = {10,38,90,28,100};
        System.out.println(num.findnum(a,100));

    }
}
