package Duoxiancheng;
//管程法
public class TestPC {
    public static void main(String[] args) {
        SynContainer  synContainer= new SynContainer();
        new Productor(synContainer).start();
        new Consumer(synContainer).start();
    }
}

class Productor extends Thread{
    SynContainer synContainer;
    public Productor(SynContainer container){
        this.synContainer = container;
    }

    @Override
    public void run() {
        for (int i = 0; i < 100; i++) {
            System.out.println("生产第"+(i+1)+"只鸡");
            try {
                this.synContainer.push(new Chicken(i+1));
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}

class Consumer extends Thread{
    SynContainer synContainer;
    public Consumer(SynContainer container){
        this.synContainer = container;
    }

    @Override
    public void run() {
        for (int i = 0; i < 100; i++) {
            Chicken chicken = this.synContainer.pop();
            System.out.println("消费了-->"+chicken.id+"只鸡");
        }
    }
}

class Chicken {
    int id;
    Chicken(int id){
        this.id = id;
    }

}

class SynContainer{
    Chicken[] chickens = new Chicken[10];
    int count = 0;

    public synchronized void push(Chicken chicken) throws InterruptedException {
        if(count== chickens.length){
            this.wait();
        }
        chickens[count] = chicken;
        count++;
        this.notifyAll();
    }

    public synchronized Chicken pop(){
        if(count==0){
            try {
                this.wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        count--;
        Chicken chicken = chickens[count];
        this.notifyAll();
        return chicken;
    }
}