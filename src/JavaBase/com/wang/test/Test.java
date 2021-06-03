package JavaBase.com.wang.test;

import JavaBase.com.wang.annotaion.Autowired;
import JavaBase.com.wang.controller.UserController;

import java.util.stream.Stream;

public class Test {
    public static void main(String[] args) {
        UserController userController = new UserController();
        Class<? extends UserController> aClass = userController.getClass();
        Stream.of(aClass.getDeclaredFields()).forEach(field -> {
            Autowired annotation = field.getAnnotation(Autowired.class);
            if (annotation!=null){
                field.setAccessible(true);
                Class<?> type = field.getType();

                try {
                    Object o = type.newInstance();
                    field.set(userController,o);
                } catch (InstantiationException e) {
                    e.printStackTrace();
                } catch (IllegalAccessException e) {
                    e.printStackTrace();
                }
            }

        });
        System.out.println(userController.getUserService());
    }
}
