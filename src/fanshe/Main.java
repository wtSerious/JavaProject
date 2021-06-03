package fanshe;
import fanshe.Student;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public class Main {
    public static void main(String[] args) throws ClassNotFoundException, NoSuchMethodException, IllegalAccessException, InvocationTargetException, InstantiationException, NoSuchFieldException {
        Class c = Class.forName("fanshe.Student");
        System.out.print(c);
        Class[] type = new Class[]{Class.forName("java.lang.String"),int.class};
        Constructor constructor = c.getConstructor(type);
        Object obj = constructor.newInstance("a",5);

        Field f = c.getField("name");
        f.set(obj,"dd");
        Student s = (Student) obj;
        System.out.print(s.name);

        Method m = c.getMethod("show1", String.class, int.class);
        m.invoke(obj,"a",5);
    }
}
