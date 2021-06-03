package JavaBase.MultiThread;

import java.util.concurrent.*;

public class CountDownLatchExample {
    public static void main(String[] args) throws InterruptedException {
        ThreadPoolExecutor threadPool = new ThreadPoolExecutor(5,10,1L, TimeUnit.SECONDS,
                new ArrayBlockingQueue<>(100),new ThreadPoolExecutor.CallerRunsPolicy());
        CountDownLatch countDownLatch = new CountDownLatch(4);
        for (int i=0;i<4;i++){
            threadPool.execute(()->{
                for (int k=0;k<100;k++)
                    System.out.println("dddd");
                countDownLatch.countDown();
            });
        }
        countDownLatch.await();
        threadPool.shutdown();
        System.out.println("finish");

    }
}
