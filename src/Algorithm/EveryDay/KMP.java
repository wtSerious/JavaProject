package Algorithm.EveryDay;

//实现strStr()函数。
//
//        给你两个字符串haystack 和 needle ，请你在 haystack 字符串中找出 needle 字符串出现的第一个位置（下标从 0 开始）。如果不存在，则返回 -1 。
//
//
//
//        说明：
//
//        当needle是空字符串时，我们应当返回什么值呢？这是一个在面试中很好的问题。
//
//        对于本题而言，当needle是空字符串时我们应当返回 0 。这与 C 语言的strstr()以及 Java 的indexOf()定义相符。

import java.util.Scanner;

/*


haystack = "adcadcaddcadde", needle = "adcadde"
 */
public class KMP {
    public static void main(String[] args) {
        String[] input = readInput();
        int result = Solution(input[0],input[1]);
        System.out.println(result);

    }

    public static int Solution(String s1,String s2){
        if (s2.equals(""))
            return 0;
        int[] next = new int[s2.length()];
        int i=1;
        int j;
        next[0] = 0;
        //先生成next数组
        while (i<s2.length()){
            j = next[i-1];
            while (j>0&&s2.charAt(i)!=s2.charAt(j)){
                j=next[j-1];
            }
            if (s2.charAt(i)==s2.charAt(j)){
                j++;
            }
            next[i] = j;
            i++;
        }

        //复用一下，意义不一样了
        i=0;
        j=0;
        while (j<s1.length()&&i<s2.length()){
            if (s1.charAt(j)==s2.charAt(i)){
                i++;
                j++;
            }else {
                if (i==0){
                    j++;
                }else {
                    i = next[i-1];
                }
            }
        }
        if (i==s2.length())
            return j-s2.length();
        return -1;
    }

    public static String[] readInput(){
        Scanner scanner = new Scanner(System.in);
        String str = scanner.nextLine();
        String[] s = str.split(",");
        s[0] = s[0].replace("haystack = ","");
        s[0] = s[0].replaceAll("\"","");
        s[1] = s[1].replace(" needle = ","");
        s[1] = s[1].replaceAll("\"","");

        return s;
    }


}
