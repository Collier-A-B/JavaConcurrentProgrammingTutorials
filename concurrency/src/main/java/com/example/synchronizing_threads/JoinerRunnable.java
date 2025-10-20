package com.example.synchronizing_threads;

import java.time.LocalDate;

/**
 * Self contained example of joining threads
 */
public class JoinerRunnable implements Runnable{
    private int result;

    @Override
    public void run() {
        result = LocalDate.now().getDayOfYear();
    }

    public static void main(String[] args) throws InterruptedException {
        JoinerRunnable runnable = new JoinerRunnable();
        Thread t = new Thread( runnable );

        t.start();
        t.join();   // will return 0 if join is not used
        System.out.println( runnable.result);
    }
}
