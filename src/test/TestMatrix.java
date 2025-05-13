package test;

import domain.MatrixAnalyzer;

public class TestMatrix {
    public static void main(String[] args) {
        int[][] matrix = {
            {1, 2, 3},
            {4, 1, 6},
            {7, 1, 9}
        };

        int mostFrequent = MatrixAnalyzer.findMostFrequentNumber(matrix);
        System.out.println("Найчастіше число: " + mostFrequent); 
    }
}
