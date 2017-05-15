package org.tac.tests.long_atomic;

public class LongAtomic {
    
    private static int longAtomic = 0;
    private static Integer aaa = new Integer(1);
    
    public LongAtomic() {
        Thread thread1 = new BasicThread();
        Thread thread2 = new BasicThread();
        thread1.start();
        thread2.start();
        try {
            thread1.join();
            thread2.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("longAtomic = " + longAtomic);
    }

    class BasicThread extends Thread {
        public void run() {
            for (int i = 0; i < 10000; i++) {
                // synchronized (aaa) {
                    longAtomic++;                                    
                // }
            }
            System.out.println("BasicThread1 finished");
        }
    }
    
    public static void main(String args[]) {
        LongAtomic longAtomic = new LongAtomic();
    }
}