package com.company;

import java.util.ArrayList;
import java.util.Scanner;

public class Solution {

    class Node {
        int name;
        boolean visited = false;
        ArrayList<Integer> directlConnectedWith = new ArrayList<Integer>();
        ArrayList<Integer> indirectlyConnectedWith = new ArrayList<Integer>();
    }


    public static int count;
    Scanner scan = new Scanner(System.in);
    static int n;
    ArrayList<Node> nodes = new ArrayList<Node>();
    public int findCircleNum(int[][] isConnected) {
        n = isConnected.length;
        for (int i = 0; i < n; i++){
            Node node = new Node();
            node.name = i+1;
            nodes.add(node);
         }
        DirectlyConnection(isConnected);
       printDirectConnection();
        return noOfProvince();
    }
    public void DirectlyConnection(int[][] isConnected){
        for (int i = 0; i < n; i++)
            for (int j = 0; j < n; j++){
                if(isConnected[i][j] == 1){
                    if(!nodes.get(i).directlConnectedWith.contains(j+1))
                    nodes.get(i).directlConnectedWith.add(j+1);
                }
            }
    }
    int noOfProvince(){
        int province = 0;
        for(int i = 0; i<nodes.size(); i++){
            if(nodes.get(i).indirectlyConnectedWith.size()>0){
                province = province + 1;
            }
        }
        return province;
    }
    public void printDirectConnection(){

        for (int i = 0; i < n; i++) {
            if(nodes.get(i).visited == true) continue;
            count = i;
            for(int j=0 ; j<nodes.get(i).directlConnectedWith.size(); j++){
                conn(nodes.get(i).directlConnectedWith.get(j));
            }
        }
    }
    public int conn(int element){
        for(int i = 0; i<nodes.get(element-1).directlConnectedWith.size(); i++){
            int temp = nodes.get(element-1).directlConnectedWith.get(i);

            if (!nodes.get(count).indirectlyConnectedWith.contains(temp)){
                nodes.get(count).indirectlyConnectedWith.add(temp);
                for(int k = 0; k <nodes.size(); k++){
                    if(nodes.get(k).name == temp){
                        nodes.get(k).visited = true;
                    }
                }
                conn(temp);
            }
        }
        return 0;
    }
}
/*
4
1 1 0 0
1 1 0 1
0 0 1 0
0 1 0 1
*/
/*
5
0 1 1 1 1 0
1 0 0 1 0 0
1 1 1 0 0 1
1 0 1 0 0 0
0 0 1 1 0 0
*/