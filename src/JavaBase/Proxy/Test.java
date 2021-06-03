package JavaBase.Proxy;

import java.lang.reflect.Proxy;

public class Test {
    public static void main(String[] args) {
        Service aService = new AService();
        MyInvocationHandler handler = new MyInvocationHandler(aService);
        Service aServiceProxy = (Service) Proxy.newProxyInstance(aService
                .getClass().getClassLoader(), aService.getClass()
                .getInterfaces(), handler);
    }
}
