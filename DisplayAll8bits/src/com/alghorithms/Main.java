package com.alghorithms;

public class Main {

    public static void main(String[] args) {
        printVector(0, new int []{0,0,0});
    }

    static void printVector(int index, int[] vector) {
        if (index >= vector.length) {
            for (int i =0; i<vector.length; i++){
                System.out.print(vector[i] + ", ");
            }
            System.out.println();
            System.out.println();

            return;
        }

        vector[index] = 0;
        printVector(index + 1, vector);

        vector[index] = 1;
        printVector(index + 1, vector);
    }
}
