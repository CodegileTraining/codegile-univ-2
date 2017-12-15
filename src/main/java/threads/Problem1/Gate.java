package threads.Problem1;

import java.util.concurrent.CountDownLatch;

public class Gate {
    private static Gate instance = null;
    private CountDownLatch latch = new CountDownLatch(3);
    private Gate(){}

    public static Gate getInstance() {
        if(instance ==null){
            instance = new Gate();
        }
        return instance;
    }

    public void await(){
        try {
            latch.countDown();
            latch.await();
        }catch (InterruptedException e){
            e.printStackTrace();
        }
    }
}
