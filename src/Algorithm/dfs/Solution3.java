package Algorithm.dfs;

//无重复字符串的排列组合。编写一种方法，计算某字符串的所有排列组合，字符串每个字符均不相同。
//
//        示例1:
//
//        输入：S = "qwe"
//        输出：["qwe", "qew", "wqe", "weq", "ewq", "eqw"]
//        示例2:
//
//        输入：S = "ab"
//        输出：["ab", "ba"]
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class Solution3 {
    static int[] flag;
    static List<String> result;
    static int n;
    static String s;
    public static void main(String[] args) {
        String[] array = readInput();
//        Arrays.sort(array);
//        for (String i:array)
//            System.out.println(i);
        result = new ArrayList<>();
        n = array.length;
        flag = new int[n];
        for (int i = 0; i < n; i++) {
            flag[i] = 0;
        }
        s = new String();
        dfs(array,0);
        String[] r = result.toArray(new String[result.size()]);
        for(String d:r)
                System.out.println(d);
        return;
    }

    public static void dfs(String[] array,int count){
        if(count==n){
            result.add(new String(s));
        }
        for (int i=0;i<n;i++){
            if (flag[i]==0){
                s += array[i];
                count++;
                flag[i] = 1;
                dfs(array,count);
                count--;
                flag[i] = 0;
                s = s.substring(0,s.length()-1);
            }
        }
    }

    public static String[] readInput(){
        List<Integer> list = new ArrayList<>();
        Scanner scanner = new Scanner(System.in);
        String str = scanner.nextLine();
        String[] arr = new String[str.length()];
        for (int i=0;i<arr.length;i++)
            arr[i] = str.substring(i,i+1);
        return arr;
    }
}
