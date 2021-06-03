package Algorithm.EveryDay;

import java.util.Arrays;
import java.util.Scanner;

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
//给定一组非负整数 nums，重新排列每个数的顺序（每个数不可拆分）使之组成一个最大的整数。
//
//        注意：输出结果可能非常大，所以你需要返回一个字符串而不是整数。
//        示例 1：
//        输入：nums = [10,2]
//        输出："210"
//        示例2：
//        输入：nums = [3,30,34,5,9]
//        输出："9534330"
//        示例 3：
//        输入：nums = [1]
//        输出："1"
//        示例 4：
//        输入：nums = [10]
//        输出："10"
//  https://leetcode-cn.com/problems/largest-number/
    //直接实现比较器，比较的时候要注意的是，当有一个串比较到尾部时，应该让他返回到index=0重新开始比，同时如果一个串为另个一串的子串时，为了停下循环，最多跑到 a.length+b.length 就能确定
    //其中一个串是另一个串的子串
public class Solution1 {
    public static void main(String[] args) {
        String[] input = readInput();
        Arrays.sort(input,(a,b)->{
            int i = 0;
            int j = 0;
            while ((i<a.length()+b.length())&&j<(b.length()+a.length())){
                int temp1 = i%(a.length());
                int temp2 = j%(b.length());
                if (Integer.valueOf(a.charAt(temp1))>Integer.valueOf(b.charAt(temp2)))
                    return -1;
                else if (Integer.valueOf(a.charAt(temp1))<Integer.valueOf(b.charAt(temp2)))
                    return 1;
                else{
                    i++;
                    j++;
                }
            }
            return 0;
        });
        String result = "";
        for (String i:input)
            result+=i;
        if (result.charAt(0)=='0'){
            result="0";
        }
        System.out.println(result);

    }

    public static String[] readInput(){
        Scanner scanner = new Scanner(System.in);
        String str = scanner.nextLine();
        str = str.replace("nums = [","");
        str = str.replaceAll("\\]","");
        String[] nums = str.split(",");
        return nums;
    }


}
