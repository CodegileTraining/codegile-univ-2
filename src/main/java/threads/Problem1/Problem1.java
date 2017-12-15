package threads.Problem1;

import java.util.Random;
import java.util.concurrent.CountDownLatch;

public class Problem1 {
    public static void main(String args[]){
        Thread thread1 = new MihaiThread(null,"T1.1");
        thread1.start();
        Thread thread2 = new MihaiThread(thread1,"T1.2");
        thread2.start();
        Thread thread3 = new MihaiThread(thread2,"T1.3");
        thread3.start();
        Thread thread4 = new MihaiThread(thread3,"t1.4");
        thread4.start();
        Thread thread5 = new MihaiThread(thread4,"t1.5");
        thread5.start();
        Thread thread6 = new MihaiThread(null,"t2.1");
        thread6.start();
        Thread thread7 = new MihaiThread(thread6,"t2.2");
        thread7.start();
        Thread thread8 = new MihaiThread(thread7,"t2.3");
        thread8.start();
        Thread thread9 = new MihaiThread(thread8,"t2.4");
        thread9.start();
        Thread thread10 = new MihaiThread(thread9,"t2.5");
        thread10.start();
        Thread thread11 = new MihaiThread(null,"t3.1");
        thread11.start();
        Thread thread12 = new MihaiThread(thread11,"t3.2");
        thread12.start();
        Thread thread13 = new MihaiThread(thread12,"t3.3");
        thread13.start();
        Thread thread14 = new MihaiThread(thread13,"t3.4");
        thread14.start();
        Thread thread15 = new MihaiThread(thread14,"t3.5");
        thread15.start();

    }
}

class Runner implements Runnable{

    private Thread previousThread;

    public Runner(Thread thread){
        this.previousThread = thread;
    }

    @Override
    public void run() {
        System.out.println("in " + Thread.currentThread().getName());
        try {
            if(previousThread != null){
                previousThread.join();
            }
            Gate.getInstance().await();
            System.out.println("out " + Thread.currentThread().getName());
            long startTime = System.currentTimeMillis();
            Thread.sleep(new Random().nextInt(3000));
            long endTime = System.currentTimeMillis();
            System.out.println(Thread.currentThread().getName() + " : " + (endTime-startTime) + " ms.");
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}

class MihaiThread extends Thread{
    public MihaiThread(Thread thread1, String name){
        super(new Runner(thread1), name);
    }
}