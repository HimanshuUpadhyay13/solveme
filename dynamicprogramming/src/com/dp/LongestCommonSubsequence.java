package com.dp;


public class LongestCommonSubsequence {

    public static int getLongestSubSequence(String one, String two) {
        int rows = one.length();
        int cols = two.length();
        int[][] LCS = new int[rows + 1][cols + 1];

        for (int row = 0; row <= rows; row++) {
            for (int col = 0; col <= cols; col++) {
                //as per algo , first row column in grid is 0
                if (row == 0 || col == 0)
                    LCS[row][col] = 0;
                    //if condition matches
                else if (one.charAt(row - 1) == two.charAt(col - 1)) {
                    LCS[row][col] = 1 + LCS[row - 1][col - 1];
                } else {
                    LCS[row][col] = Math.max(LCS[row][col - 1], LCS[row - 1][col]);
                }
            }
        }
        return LCS[rows][cols];
    }

    public static String printLongestSubSequence(String one, String two) {
        int rows = one.length();
        int cols = two.length();
        int[][] LCS = new int[rows + 1][cols + 1];

        for (int row = 0; row <= rows; row++) {
            for (int col = 0; col <= cols; col++) {
                //as per algo , first row column in grid is 0
                if (row == 0 || col == 0)
                    LCS[row][col] = 0;
                    //if condition matches
                else if (one.charAt(row - 1) == two.charAt(col - 1)) {
                    LCS[row][col] = 1 + LCS[row - 1][col - 1];
                } else {
                    LCS[row][col] = Math.max(LCS[row][col - 1], LCS[row - 1][col]);
                }
            }
        }
        StringBuilder st = new StringBuilder();
        while (rows > 0 && cols > 0) {
            if (one.charAt(rows - 1) == two.charAt(cols - 1)) {
                st.append(one.charAt(rows - 1));
                rows--;
                cols--;
            } else if (LCS[rows - 1][cols] > LCS[rows][cols - 1]) {
                rows--;
            } else {
                cols--;
            }
        }
        return st.reverse().toString();
    }

    public static void main(String[] args) {
        String s1 = "AGGTAB";
        String s2 = "GXTXAYB";
        System.out.print(getLongestSubSequence(s1, s2));
        System.out.print(printLongestSubSequence(s1, s2));
    }
}
