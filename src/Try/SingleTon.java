package Try;

public class SingleTon {
    public static volatile SingleTon singleTon;

    private SingleTon(){

    }
    public static void getInstance(){
        if (singleTon==null){
            synchronized (singleTon.getClass()){
                if (singleTon == null){
                    singleTon = new SingleTon();
                }
            }
        }
    }
}
