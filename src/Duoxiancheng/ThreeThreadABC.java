package Duoxiancheng;

public class ThreeThreadABC implements Runnable{
    public static int state = 0;
    public static void main(String[] args) throws InterruptedException {
        new Thread(new ThreeThreadABC()).start();
        new Thread(new ThreeThreadABC()).start();
        new Thread(new ThreeThreadABC()).start();
    }

    public void print(){
        for (int i=0;i<10;i++){
                synchronized (this.getClass()){
                    if (state%3==0){
                        System.out.println("A");
                        state++;
                    }else if(state%3==1)
                    {
                        System.out.println("B");
                        state++;
                    }else {
                        System.out.println("C");
                        state++;
                    }
            }
        }
    }

    @Override
    public void run() {
        print();
    }
}





