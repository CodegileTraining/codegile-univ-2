package threads;

import java.util.Random;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Semaphore;

public class Main {


    public static void main(String[] args) throws InterruptedException {

        Semaphore semaphore = new Semaphore(3);

        semaphore.acquire();

        semaphore.release();


        CountDownLatch countDownLatch = new CountDownLatch(3);

        ExecutorService executorService = Executors.newCachedThreadPool();
        executorService.submit(new UpdateRunnable(countDownLatch));
        executorService.submit(new UpdateRunnable(countDownLatch));
        executorService.submit(new UpdateRunnable(countDownLatch));

        System.out.println("Waiting for updates");
        countDownLatch.await();


        System.out.println("done");
    }
}

interface UpdateReceiver {

    void onSuccessCallback(String updatedString);
}

class Whatever implements UpdateReceiver {
    @Override
    public void onSuccessCallback(String updatedString) {

    }
}

class UpdateRunnable implements Runnable {

    private final CountDownLatch latch;
    private static int x;
    private int myX;

    UpdateRunnable(CountDownLatch latch) {
        x++;
        myX = x;
        this.latch = latch;
    }

    @Override
    public void run() {
        try {
            System.out.println("Updating " + myX);
            Thread.sleep(myX * 1000);
            System.out.println("Finished update " + myX);
            latch.countDown();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
