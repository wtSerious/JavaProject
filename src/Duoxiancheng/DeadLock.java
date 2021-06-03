package Duoxiancheng;

public class DeadLock {
    public static void main(String[] args) {
        Makeup up1 = new Makeup(1, "白雪公主");
        up1.start();
        Makeup up2 = new Makeup(0,"老妖婆");
        up2.start();

    }
}

class Lipstick{}

class Mirror{}

class Makeup extends Thread{
    //需要的资源只有一份
    static Lipstick lipstick = new Lipstick();
    static Mirror mirror = new Mirror();

    private int choice;
    private String girlName;

    Makeup(int choice,String girlName){
        this.choice = choice;
        this.girlName = girlName;
    }
    @Override
    public void run() {
        makeup();
    }

    //互相持有对方的锁
    private void makeup(){
        if(choice==0){
            synchronized (lipstick){//获得口红的锁
                System.out.println(this.girlName+"获得口红");
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }

            }
            synchronized (mirror){
                System.out.println(this.girlName+"获得镜子");
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }else {
            synchronized (mirror){
                System.out.println(this.girlName+"获得镜子");
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }

            }
            synchronized (lipstick){
                System.out.println(this.girlName+"获得口红");
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}
