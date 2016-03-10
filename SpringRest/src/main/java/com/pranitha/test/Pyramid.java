package com.pranitha.test;

import java.util.Scanner;

/**
 * Created by naveen on 3/2/16.
 */
public class Pyramid {

    public static void main(String args[]) {
        int j;
        Scanner sc = new Scanner(System.in);
        int s = sc.nextInt();
        System.out.println("this is s " + s);
        int a = (2 * s - 1);
        int k = 0;

        for (int i = 0; i < a; i++) {
            for (j = 0; j < a - i; j++) {
                if (j < i) {
                    System.out.print(" ");
                } else {
                    System.out.print("0");

                }
            }
            if(i==s-1) {
                System.out.println("");
                break;
            }
            System.out.println();
        }
        for (int row1 = 0; row1 < s; row1++) {
            for (int col1 = 0; col1 < a; col1++) {
                if (col1 == s-1) {
                    System.out.print("|");
                }else{
                    System.out.print(" ");

                }

            }
            System.out.println();

        }
        for(int l=0;l<a;l++){
            System.out.print("=");
        }
    }

}
