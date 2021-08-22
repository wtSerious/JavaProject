package Try;

import javax.xml.crypto.Data;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Date;

public class Main4 {
    public static void main(String[] args) {
//        int a = 1;
//        int b = a++;
//        System.out.println(""+a+b);
//        Date date = new Date((long)1625453709724);
//        System.out.println(date);
        try {
            Class.forName("java.lang.String");
//            ClassLoader.getSystemClassLoader().loadClass();
            String b = "asdf";
            b = b.replace("a","b");
            System.out.println(b);
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }
}
