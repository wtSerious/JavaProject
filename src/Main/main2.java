package Main;

import java.awt.print.PrinterGraphics;
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;

public class main2 {
    public static void main(String[] args) {
        int[] array = {0,1,2,3,4,5};
        int [] b = new int[4];
        System.arraycopy(array,1,b,0,3);
//        b = Arrays.copyOf(array,10);
//        b[0]=5;
        for (int n: b)
            System.out.println(n);

        ArrayList<Integer> arra = new ArrayList<Integer>(100);

        Object[] a = new Object[10];
        Class c = a.getClass();
        System.out.printf(c.toString());
        Class type = c.getComponentType();
        int lenghth = Array.getLength(a);
        Object newArray = Array.newInstance(type,lenghth);

//        Object a = new Object();
//        Object c = (Object) a.clone();

    }




}
