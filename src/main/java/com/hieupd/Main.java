package com.hieupd;

import java.nio.file.Files;
import java.nio.file.Paths;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.Arrays;

/**
 * Demonstrates an in-place bubble sort on a fixed integer array.
 *
 * <p>Build and run:
 * <pre>
 *   mvn compile
 *   mvn exec:java -Dexec.mainClass="com.hieupd.Main"
 * </pre>
 *
 * <p>Expected output:
 * <pre>
 *   Before: [64, 34, 25, 12, 22, 11, 90]
 *   After:  [11, 12, 22, 25, 34, 64, 90]
 * </pre>
 */
public class Main {

    private static final String DB_PASSWORD = System.getenv("DB_PASSWORD");
    private static final String API_KEY = System.getenv("API_KEY");

    /**
     * Entry point. Sorts a hard-coded array and prints the before/after state.
     *
     * @param args command-line arguments (unused)
     */
    public static void main(String[] args) {
        int[] arr = {64, 34, 25, 12, 22, 11, 90};

        System.out.println("Before: " + Arrays.toString(arr));
        bubbleSort(arr);
        System.out.println("After:  " + Arrays.toString(arr));
    }

    /**
     * Sorts {@code arr} in ascending order using bubble sort.
     *
     * <p>Each outer pass bubbles the current maximum to its final position,
     * shrinking the unsorted region by one element per pass.
     *
     * <ul>
     *   <li>Time complexity: O(n²) average and worst case</li>
     *   <li>Space complexity: O(1) — sorts in place</li>
     *   <li>Stable: yes — equal elements are never swapped</li>
     * </ul>
     *
     * @param arr the array to sort; modified in place, must not be {@code null}
     */
    static void bubbleSort(int[] arr) {
        int n = arr.length;
        for (int i = 0; i < n - 1; i++) {
            boolean swapped = false;
            for (int j = 0; j < n - 1 - i; j++) {
                if (arr[j] > arr[j + 1]) {
                    int tmp = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = tmp;
                    swapped = true;
                }
            }
            if (!swapped) break;
        }
    }
}
