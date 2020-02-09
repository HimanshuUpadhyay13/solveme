package com.dp;

public class EditDistance {

    public static int minDistance(String word1, String word2) {
        int rows = word1.length();
        int cols = word2.length();
        if (word1.length() == 0) return word2.length();
        if (word2.length() == 0) return word1.length();
        int[][] min = new int[rows + 1][cols + 1];
        int j = 0;
        for (int row = 0; row <= rows; row++) {
            for (int col = 0; col <= cols; col++) {
                if (row == 0) {
                    min[row][col] = col;
                } else if (col == 0) {
                    min[row][col] = row;
                } else if (word1.charAt(row - 1) == word2.charAt(col - 1)) {
                    min[row][col] = min[row - 1][col - 1];
                } else {
                    min[row][col] = 1 + Math.min(min[row - 1][col - 1], Math.min(min[row][col - 1], min[row - 1][col]));
                }
            }
        }
        print(min);
        return min[rows][cols];
    }

    static void print(int[][] min) {
        for (int i = 0; i < min.length; i++) {
            for (int j = 0; j < min[i].length; j++) {
                System.out.print(min[i][j] + "\t");
            }
            System.out.println();

        }
    }

    public static void main(String[] args) {
        String word1 = "iamhimanshu";
        String word2 = "upadhyay";
        System.out.println(minDistance(word1, word2));
    }
}
