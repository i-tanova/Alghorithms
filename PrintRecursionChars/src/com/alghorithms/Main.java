package com.alghorithms;

public class Main {

    public static void main(String[] args) {
	  printChar(4);
    }

    static void printChar(int index){
        if(index == 0){
            return;
        }

        for(int i =0; i< index; i++){
            System.out.print(".");
        }
        System.out.println();
        printChar(index-1);

        for(int i =0; i< index; i++){
            System.out.print("#");
        }
        System.out.println();
    }
}
