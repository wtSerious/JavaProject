package Try;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

public class Main2 {
    public static void main(String[] args) {
        Map<Integer,Integer> a = new HashMap<>();
        a.put(1,2);
        a.put(3,4);
        Iterator<Map.Entry<Integer,Integer>> s = a.entrySet().iterator();
        while (s.hasNext()){
            Map.Entry<Integer,Integer> e = s.next();
            System.out.println(e.getKey());
            System.out.println(e.getValue());
        }
    }
}
