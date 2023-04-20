/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package jessesitespractice6;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.util.Arrays;
import java.util.Random;

/**
 *
 * @author jesse - module 6
 */
public class JesseSitesPractice6 {

    static int arraySize = 100_000;
    static long[] sortResults = new long[10];
    static long[] threadedSortResults = new long[10];
    static long[] testResults = new long[10];

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        for (int i = 0; i < 10; i++) {
            testBubbleSorts(i);
        }

        saveTestResults();
    }

    public static void testBubbleSorts(int a) {
        Random rd = new Random();
        int[] intArray = new int[arraySize];

        for (int i = 0; i < arraySize; i++) {
            intArray[i] = rd.nextInt(arraySize) + 1;
        }

        sortResults[a] = bubbleSort(intArray);
        threadedSortResults[a] = bubbleSortThreaded(intArray);
        testResults[a] = sortResults[a] - threadedSortResults[a];
    }

    public static long bubbleSort(int[] array) {
        int[] intArray = Arrays.copyOf(array, arraySize);
        boolean isSorted = false;
        int counter = 0;
        long startTime;
        long elapsedTime;

        startTime = System.nanoTime();

        while (!isSorted) {
            isSorted = true;

            for (int i = 0; i < arraySize - 1 - counter; i++) {
                if (intArray[i] > intArray[i + 1]) {
                    swapElements(intArray, i, i + 1);
                    isSorted = false;
                }
            }

            counter++;
        }

        elapsedTime = System.nanoTime() - startTime;
        return elapsedTime;
    }

    public static long bubbleSortThreaded(int[] array) {
        int[] intArray = Arrays.copyOf(array, arraySize);
        int[] intArray1;
        int[] intArray2;
        long startTime;
        long elapsedTime;

        startTime = System.nanoTime();
        intArray1 = Arrays.copyOfRange(intArray, 0, intArray.length / 2);
        intArray2 = Arrays.copyOfRange(intArray, intArray.length / 2, intArray.length);
        Sort1 sort1 = new Sort1(intArray1);
        Sort2 sort2 = new Sort2(intArray2);

        try {
            sort1.t.join();
            sort2.t.join();
        } catch (Exception x) {
            x.printStackTrace();
        }

        mergeArrays(intArray1, intArray2);
        elapsedTime = System.nanoTime() - startTime;
        return elapsedTime;
    }

    public static void swapElements(int[] array, int i, int j) {
        int temp = array[i];

        array[i] = array[j];
        array[j] = temp;
    }

    public static int[] mergeArrays(int[] a, int[] b) {
        int[] array = new int[a.length + b.length];
        int i = a.length - 1;
        int j = b.length - 1;
        int k = array.length;

        while (k > 0) {
            array[--k] = (j < 0 || (i >= 0 && a[i] >= b[j])) ? a[i--] : b[j--];
        }

        return array;
    }

    public static void saveTestResults() {
        try {
            FileWriter fw = new FileWriter("results.txt", false);
            BufferedWriter bw = new BufferedWriter(fw);
            double averageSortTime = 0;
            double averageThreadedSortTime = 0;

            for (int i = 0; i < 10; i++) {
                bw.write((double) testResults[i] / 1_000_000_000 + " seconds difference "
                        + "between sort types for test " + (i + 1) + "\n");
                averageSortTime += sortResults[i];
                averageThreadedSortTime += threadedSortResults[i];
            }

            averageSortTime /= 10;
            averageThreadedSortTime /= 10;
            bw.write("\nAverage single sort time: " + averageSortTime / 1_000_000_000
                    + " seconds\n");
            bw.write("Average threaded sort time: " + averageThreadedSortTime / 1_000_000_000
                    + " seconds\n");
            double averageTimeDifference = averageSortTime - averageThreadedSortTime;
            double averageTimeDifferencePercentage = (averageTimeDifference
                    / averageSortTime) * 100;
            bw.write("Difference between average times: " + Double.toString(averageTimeDifferencePercentage)
                    + "%");
            bw.close();
        } catch (Exception x) {
            x.printStackTrace();
        }
    }
}

class Sort1 implements Runnable {

    Thread t;
    int[] intArray;

    Sort1(int[] array) {
        intArray = array;
        t = new Thread(this);
        t.start();
    }

    @Override
    public void run() {
        boolean isSorted = false;
        int counter = 0;

        while (!isSorted) {
            isSorted = true;

            for (int i = 0; i < intArray.length - 1 - counter; i++) {
                if (intArray[i] > intArray[i + 1]) {
                    JesseSitesPractice6.swapElements(intArray, i, i + 1);
                    isSorted = false;
                }
            }

            counter++;
        }
    }
}

class Sort2 implements Runnable {

    Thread t;
    int[] intArray;

    Sort2(int[] array) {
        intArray = array;
        t = new Thread(this);
        t.start();
    }

    @Override
    public void run() {
        boolean isSorted = false;
        int counter = 0;

        while (!isSorted) {
            isSorted = true;

            for (int i = 0; i < intArray.length - 1 - counter; i++) {
                if (intArray[i] > intArray[i + 1]) {
                    JesseSitesPractice6.swapElements(intArray, i, i + 1);
                    isSorted = false;
                }
            }

            counter++;
        }
    }
}
