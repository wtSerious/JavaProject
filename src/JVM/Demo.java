package JVM;

public class Demo {
    public static void main(String[] args) {
        new Thread(()->{

        },"my thread name").start();
    }
    //native:
    //会进入本地方法栈
    //调用本地方法接口 JNI：java native interface
    //JNI作用：扩展 java 的使用，融合不同的编程语言为 java 所用！
    //在内存区域中专门开辟了一块标记区域：nativate method stack，登记 native 方法
    //在最终执行的时候，加载本地方法库中的方法通过JNI
    //
    private native void hell();
}
