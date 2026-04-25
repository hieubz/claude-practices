package com.hieupd;

import java.util.Arrays;

/**
 * Demonstrates an in-place quick sort on a fixed integer array.
 *
 * <p>Build and run:
 * <pre>
 *   mvn compile
 *   mvn exec:java -Dexec.mainClass="com.hieupd.QuickSort"
 * </pre>
 *
 * <p>Expected output:
 * <pre>
 *   Before: [64, 34, 25, 12, 22, 11, 90]
 *   After:  [11, 12, 22, 25, 34, 64, 90]
 * </pre>
 */
public class QuickSort {

    /**
     * Entry point. Sorts a hard-coded array and prints the before/after state.
     *
     * @param args command-line arguments (unused)
     */
    public static void main(String[] args) {
        int[] arr = {64, 34, 25, 12, 22, 11, 90};

        System.out.println("Before: " + Arrays.toString(arr));
        quickSort(arr, 0, arr.length - 1);
        System.out.println("After:  " + Arrays.toString(arr));
    }

    /**
     * Sorts {@code arr[low..high]} in ascending order using quick sort.
     *
     * <p>Recursively partitions the array around a pivot chosen by
     * {@link #partition(int[], int, int)}, then sorts each sub-array.
     *
     * <ul>
     *   <li>Time complexity: O(n log n) average, O(n²) worst case (already-sorted input)</li>
     *   <li>Space complexity: O(log n) average stack depth</li>
     *   <li>Stable: no — equal elements may be reordered</li>
     * </ul>
     *
     * @param arr  the array to sort; modified in place, must not be {@code null}
     * @param low  starting index of the sub-array (inclusive)
     * @param high ending index of the sub-array (inclusive)
     */
    static void quickSort(int[] arr, int low, int high) {
        if (low < high) {
            int pi = partition(arr, low, high);
            quickSort(arr, low, pi - 1);
            quickSort(arr, pi + 1, high);
        }
    }

    /**
     * Partitions {@code arr[low..high]} around the last element as pivot.
     *
     * <p>All elements smaller than the pivot are moved to its left;
     * all elements greater are moved to its right. Returns the final index
     * of the pivot.
     *
     * @param arr  the array to partition; modified in place
     * @param low  starting index of the sub-array (inclusive)
     * @param high ending index of the sub-array (inclusive); used as pivot
     * @return     the index at which the pivot is placed after partitioning
     */
    static int partition(int[] arr, int low, int high) {
        int pivot = arr[high];
        int i = low - 1;

        for (int j = low; j < high; j++) {
            if (arr[j] <= pivot) {
                i++;
                int tmp = arr[i];
                arr[i] = arr[j];
                arr[j] = tmp;
            }
        }

        int tmp = arr[i + 1];
        arr[i + 1] = arr[high];
        arr[high] = tmp;

        return i + 1;
    }
}
