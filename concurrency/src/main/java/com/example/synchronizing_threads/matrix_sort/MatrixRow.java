package com.example.synchronizing_threads.matrix_sort;

import java.util.List;

public class MatrixRow implements Runnable {

    private final List<Integer> row;
    public MatrixRow(List<Integer> _row) {
        this.row = _row;
    }
    @Override
    public void run() {
        row.sort(null);
    }

}
