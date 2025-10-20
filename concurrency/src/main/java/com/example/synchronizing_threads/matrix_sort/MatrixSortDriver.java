package com.example.synchronizing_threads.matrix_sort;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ThreadLocalRandom;

/**
 * Custom example for sorting each row in a 2d array
 * 
 * Note: Each row will be sorted independently of all other rows
 */
public class MatrixSortDriver {

    // these values set the number of rows and columns of the matrix (2d array)
    private final static int numRows = 10;
    private final static int numCols = 50;

    public static void main(String[] args) {
        // generate matrix of random numbers [0,999]
        List<List<Integer>> matrix = new ArrayList<>(numRows);
        for (int i = 0; i < numRows; i++) {
            List<Integer> row = new ArrayList<>(numCols);
            for (int j = 0; j < numCols; j++) {
                row.add(ThreadLocalRandom.current().nextInt(0,1_000));
            }
            matrix.add(row);
        }

        // Print initial matrix
        printMatrix(matrix);

        List<Thread> threadPool = new ArrayList<>(numRows);

        for (int i = 0; i < numRows; i++) {
            MatrixRow runnable = new MatrixRow(matrix.get(i));
            Thread t = new Thread( runnable );
            threadPool.add(t);
            t.start();
        }
        for (int i = 0; i < numRows; i++) {
            try {
                threadPool.get(i).join();
            } catch (InterruptedException e) {
                System.err.println("exception thrown when joining row: " + i);
            }
        }
        printMatrix(matrix);
    }

    private static void printMatrix(List<List<Integer>> matrix) {
        System.out.println("\nPrinting Matrix");
        for (int row = 0; row < numRows; row++) {
            System.out.print("row "+ row + ": [");
            for (int col = 0; col < numCols; col++) {
                System.out.print(" " + matrix.get(row).get(col) + ",");
            }
            System.out.println("]");
        }
    }
}
