package Try;

public class SingleTon {
    public static volatile SingleTon singleTon;

    private SingleTon(){

    }
    public static SingleTon getInstance(){
        if (singleTon==null){
            synchronized (singleTon){
                if (singleTon == null){
                    singleTon = new SingleTon();
                }
            }
        }
        return singleTon;
    }

    public static void main(String[] args) {
        System.out.println(SingleTon.getInstance());
    }
}
