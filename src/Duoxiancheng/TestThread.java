package Duoxiancheng;

import java.util.concurrent.ThreadPoolExecutor;

public class TestThread implements Runnable {
    public static void main(String[] args) {
        TestThread ticket = new TestThread();
        new Thread(ticket,"小明").start();
        new Thread(ticket,"小强").start();
        new Thread(ticket,"换换").start();
    }

    private int ticketNums = 10;
    @Override
    public void run() {
        while (true){
            if(ticketNums<=0){
                break;
            }
            System.out.println(Thread.currentThread().getName()+"拿到了第"+ticketNums--+"票");

        }

    }
}
