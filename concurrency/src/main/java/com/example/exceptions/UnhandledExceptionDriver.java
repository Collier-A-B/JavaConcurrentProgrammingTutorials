package com.example.exceptions;

public class UnhandledExceptionDriver {
    // Throws uncaught exception (ArithmeticException for division by zero)
    public static void main(String[] args) throws InterruptedException {
        System.out.println("Starting Unhandled Exception Driver");

        Thread t = new Thread( () -> {
                System.out.println( Thread.currentThread() ); 
                System.out.println( 1 / 0 );
            }, "Waiting for the sumer rain" 
        );

        t.start();
        System.out.println( t.isAlive() );
        Thread.sleep( 1000 );   // throws declaration
        System.out.println( Thread.currentThread() );
        System.out.println( t.isAlive());
        
    }
}
