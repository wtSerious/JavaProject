package Duoxiancheng;

public class ThreadABC3 {
    public static void main(String[] args) throws InterruptedException {
        Object a = new Object();
        Object b = new Object();
        Object c = new Object();
        Integer integer = Integer.valueOf(0);
        new Thread(new ThreadMy(integer,"c",2)).start();

        new Thread(new ThreadMy(integer,"b",1)).start();
        new Thread(new ThreadMy(integer,"a",0)).start();


    }


}

class ThreadMy implements Runnable{
    private Integer integer ;
    private String name;
    private int num;

    public ThreadMy(Integer integer,String name,int num){
        this.integer = integer;
        this.name = name;
        this.num = num;
    }

    @Override
    public void run() {
        for (int count=0;count<10;count++){
            synchronized (integer){
                while (integer%3!=num){
                    try {
                        integer.wait();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
                integer++;
                System.out.println(name);
                integer.notifyAll();
            }
        }
    }
}

//class ThreadMy implements Runnable{
//    private Object pre;
//    private Object self;
//    private String name;
//    private int i;
//    private Integer state;
//    private int count = 10;
//    public ThreadMy(Object pre,Object self,String name,int i,Integer state){
//        this.pre = pre;
//        this.self = self;
//        this.name = name;
//        this.state  =state;
//        this.i = i;
//    }
//    @Override
//    public void run() {
//        while (count>0){
//            synchronized (pre){
//                synchronized (self){
////                    if (state%3==i){
////                        System.out.println(name);
////                        count--;
////                    }
//                    System.out.println(name);
//                    count--;
//                    self.notifyAll();
//                }
//                if (count==0){
//
//                }else {
//                    try {
//                        pre.wait();
//                    } catch (InterruptedException e) {
//                        e.printStackTrace();
//                    }
//                }
////                if (count==0){
////
////                }else {
////                    try {
////                        pre.wait();
////                    } catch (InterruptedException e) {
////                        e.printStackTrace();
////                    }
////                }
//            }
//        }
//    }
//}
