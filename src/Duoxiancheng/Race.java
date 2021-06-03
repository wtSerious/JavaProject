package Duoxiancheng;

import javax.swing.plaf.TableHeaderUI;

public class Race implements Runnable{
    private static String winner;
    @Override
    public void run() {
        for(int i = 0;i<=100;i++){
            if(Thread.currentThread().getName().equals("tuzi")&&(i+1)%10==0) {
                try {
                    Thread.sleep(100);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
            boolean flag = gameover(i);
            if(flag)
                break;
            System.out.println(Thread.currentThread().getName()+"->跑了"+i+"步");

        }
    }

    private boolean gameover(int steps){
        if (winner!=null){
            return true;
        }{
            if(steps==100){
                winner = Thread.currentThread().getName();
                System.out.println("winner is "+winner);
                return true;
            }
        }
        return false;
    }

    public static void main(String[] args) {
        Race race = new Race();
        new Thread(race,"tuzi").start();
        new Thread(race,"wugui").start();
    }
}
