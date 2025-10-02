package com.example.interupts;

public class InteruptsDriver extends Thread{
    public static void main(String[] args) {
        
        Runnable kilingMeSoftly = () -> {
            System.out.println( "There is life before death." );

            while ( !Thread.currentThread().isInterrupted() ) {
                System.out.println( "It runs, and runs, and runs, and runs.");
                try {
                    Thread.sleep(500);
                } catch (InterruptedException e) {
                    Thread.currentThread().interrupt();
                    System.out.println( "Interruption in sleep()." );
                }
            }

            System.out.println( "This is the end, beutiful friend.");
        };

        Thread t = new Thread( kilingMeSoftly );
        t.start();
        try {
            Thread.sleep( 2000 );
        } catch (InterruptedException e) {
            
        }
        
        t.interrupt();
    }
}
