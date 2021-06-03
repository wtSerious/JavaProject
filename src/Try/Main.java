package Try;
/**
 * @                           _ooOoo_
 *                            o8888888o
 *                            88" . "88
 *                            (| -_- |)
 *                            O\  =  /O
 *                         ____/`---'\____
 *                       .'  \\|     |//  `.
 *                      /  \\|||  :  |||//  \
 *                     /  _||||| -:- |||||-  \
 *                     |   | \\\  -  /// |   |
 *                     | \_|  ''\---/''  |   |
 *                     \  .-\__  `-`  ___/-. /
 *                   ___`. .'  /--.--\  `. . __
 *                ."" '<  `.___\_<|>_/___.'  >'"".
 *               | | :  `- \`.;`\ _ /`;.`/ - ` : | |
 *               \  \ `-.   \_ __\ /__ _/   .-` /  /
 *          ======`-.____`-.___\_____/___.-`____.-'======
 *                             `=---='
 *          ^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^
 *           *                     佛祖保佑        永无BUG
 **/
import java.util.Arrays;
import java.util.List;
import java.util.concurrent.locks.ReentrantLock;

public class Main {
    static int a = 1;
    static  int b =2;
    public static void main(String[] args) {
//        Long a = 2l;
//        Integer b = 1;
//        Integer c = 1;
//        System.out.println(a.equals(b+c));

        String a = "a";
        String b = "b";
        String c = "ab";
        System.out.println(c==(a+"b"));
    }
}
