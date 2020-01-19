package com.dp;

import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.function.*;
import java.util.regex.*;
import java.util.stream.*;

import static java.util.stream.Collectors.joining;
import static java.util.stream.Collectors.toList;


class NumberOfPathInMatrix {

    public static int numberOfPaths(List<List<Integer>> lists) {
        // Write your code here
       return 1;

    }


    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        int aRows = Integer.parseInt(bufferedReader.readLine().trim());
        int aColumns = Integer.parseInt(bufferedReader.readLine().trim());

        List<List<Integer>> a = new ArrayList<>();

        IntStream.range(0, aRows).forEach(i -> {
            try {
                a.add(
                        Stream.of(bufferedReader.readLine().replaceAll("\\s+$", "").split(" "))
                                .map(Integer::parseInt)
                                .collect(toList())
                );
            } catch (IOException ex) {
                throw new RuntimeException(ex);
            }
        });

        int result = NumberOfPathInMatrix.numberOfPaths(a);

        bufferedWriter.write(String.valueOf(result));
        bufferedWriter.newLine();

        bufferedReader.close();
        bufferedWriter.close();
    }

}
