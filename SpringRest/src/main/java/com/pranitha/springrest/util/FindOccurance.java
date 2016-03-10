package com.pranitha.springrest.util;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by naveen on 2/3/16.
 */
public class FindOccurance {

    public int getOccurance(int a[]){

        Map<Integer,Integer> hashmap = new HashMap<Integer,Integer>();

        for(int i=0;i<a.length;i++){

           if(hashmap.get(a[i]) == null){
                hashmap.put(a[i],1);
            } else if(hashmap.get(a[i]) != null){
                int count =hashmap.get(a[i]);
                hashmap.put(a[i],count+1);
            }

        }
        for (Integer key : hashmap.keySet()) {
            System.out.println("key is "+key + " value is " + hashmap.get(key));
        }
        return -1;
    }

    public static void main(String args[]){

        int a[] = {10,10,20,1,9,1,1,9};

        FindOccurance occurance = new FindOccurance();

        System.out.println(occurance.getOccurance(a));


    }


}
