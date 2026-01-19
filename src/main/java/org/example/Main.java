package org.example;

import java.util.Random;

public class Main {
    public static void main(String[] args){

        int[][] arr = new int[3][];

        arr[0] = new int[7];
        arr[1] = new int[2];
        arr[2] = new int[9];

        Random random = new Random();

        for(int i=0;i<arr.length;i++){
            for(int j=0;j<arr[i].length;j++){
                arr[i][j] = random.nextInt(100);
            }
        }

        for(int i=0;i<arr.length;i++){
            for(int j=0;j<arr[i].length;j++){
                System.out.print(arr[i][j]+" ");
            }
            System.out.println();
        }
    }
}