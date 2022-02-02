package com.company;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        int n;
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        int[][] isConnected = new int[n][n];
        for(int i = 0; i<n; i++){
            for (int j = 0; j < n; j++) {
                isConnected[i][j] = sc.nextInt();
               /*System.out.println("arr[" + i + "][" + j + "] = "
                + isConnected[i][j]);*/
            }
        }


        Solution e = new Solution();
        System.out.println("No of Province: " + e.findCircleNum(isConnected));
        /*System.out.println("arr[" + i + "][" + j + "] = "
                + isConnected[i][j]);*/
    }

}
