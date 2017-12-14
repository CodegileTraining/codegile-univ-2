package threads;

import java.util.concurrent.*;

public class Main2 {

    static ExecutorService executorService;

    public static void main(String[] args) throws InterruptedException {

        Thread thread2 = new MyThread(null);
        Thread thread1 = new MyThread(thread2);
        thread1.start();

        thread1.join();
        thread2.join();

        System.out.println("main " + System.currentTimeMillis());

        CountDownLatch countDownLatch = new CountDownLatch(3);

        countDownLatch.await();

        countDownLatch.countDown();
        countDownLatch.countDown();
        countDownLatch.countDown();

        Semaphore semaphore = new Semaphore(3);

        semaphore.acquire();
        semaphore.acquire();
        semaphore.acquire();

        semaphore.acquire();
        semaphore.acquire();
        semaphore.acquire();

        semaphore.release();
        semaphore.release();
        semaphore.release();

//        System.out.println("Thread has been started");

//        executorService = Executors.newSingleThreadExecutor();
//        executorService.submit(new MyRunnable2());
//        executorService.submit(new MyRunnable2());

//        executorService = Executors.newFixedThreadPool(2);
//        executorService.submit(new MyRunnable2());
//        executorService.submit(new MyRunnable2());
//        executorService.submit(new MyRunnable2());

//        executorService = Executors.newCachedThreadPool();
//        executorService.submit(new MyRunnable2());
//        executorService.submit(new MyRunnable2());
//        executorService.submit(new MyRunnable2());
//
//        executorService.shutdown();
//        try {
//            executorService.awaitTermination(20, TimeUnit.SECONDS);
//            executorService.shutdownNow();
//        } catch (InterruptedException e) {
//            e.printStackTrace();
//        }
    }
}

class MyRunnable2 implements Runnable {
    private Thread nextThread;

    public MyRunnable2(Thread nextThread) {
        this.nextThread = nextThread;
    }

    @Override
    public void run() {
//        try {
//            Thread.sleep(3000);
//        } catch (InterruptedException e) {
//            e.printStackTrace();
//        }
        System.out.println(System.currentTimeMillis());
        startNextThread();
    }

    public void startNextThread() {
        if (nextThread != null) {
            nextThread.start();
        }
    }
}

class MyThread extends Thread {

    public MyThread(Thread nextThread) {
        super(new MyRunnable2(nextThread));
    }
}
