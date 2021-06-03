package Duoxiancheng;

import java.util.concurrent.CopyOnWriteArrayList;

public class JUC {
    public static void main(String[] args) throws InterruptedException {
        CopyOnWriteArrayList<String> alist = new CopyOnWriteArrayList<String>();
        for (int i = 0; i < 1000; i++) {
            new Thread(()->{
                alist.add(Thread.currentThread().getName());
            }).start();

            }
        Thread.sleep(3000);
        System.out.println(alist.size());
    }

}
