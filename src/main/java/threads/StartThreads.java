package threads;

import java.util.concurrent.CountDownLatch;

public class StartThreads {

    public static void main(String[] args) {
        CountDownLatch countDownLatch = new CountDownLatch(3);

        Thread thread1 = new Thread(new MyRunnable(countDownLatch));
        thread1.start();
        // sleep 5
        Thread thread2 = new Thread(new MyRunnable(countDownLatch));
        thread2.start();
        // sleep 5
        Thread thread3 = new Thread(new MyRunnable(countDownLatch));
        thread3.start();
    }
}

class MyRunnable implements Runnable {

    private static int x = 0;
    private int myX;
    private CountDownLatch countDownLatch;

    MyRunnable(CountDownLatch countDownLatch) {
        this.myX = x++;
        this.countDownLatch = countDownLatch;
    }

    @Override
    public void run() {
        try {
            countDownLatch.countDown();
            countDownLatch.await();
            System.out.println(myX + " " + System.currentTimeMillis());
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}