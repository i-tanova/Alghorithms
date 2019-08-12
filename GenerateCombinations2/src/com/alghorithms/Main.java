package com.alghorithms;

public class Main {

    public static void main(String[] args) {
        generateComb(new int[]{1, 2, 3, 4}, new int[]{0,0}, 0, 0);
    }

    private static void generateComb(int[] input, int[] result, int begin, int border){
        if(begin == result.length){
            for (int resultElement: result){
                System.out.print(resultElement + ", ");
            }
            System.out.println();
            return;
        }

        for(int i = border; i< input.length; i ++){
            result[begin] = input[i];
            generateComb(input, result, begin + 1, i+1);
        }

    }
}
