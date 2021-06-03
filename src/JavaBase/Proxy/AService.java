package JavaBase.Proxy;

public class AService implements Service{
    @Override
    public void add() {
        System.out.println("AService add>>>>>>>>>>>>>>>>>>");
    }

    @Override
    public void update() {
        System.out.println("AService update>>>>>>>>>>>>>>>");
    }
}
