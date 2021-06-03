package Algorithm.dfs;

//给定一个 没有重复 数字的序列，返回其所有可能的全排列。
//
//        示例:
//
//        输入: [1,2,3]
//        输出:
//        [
//        [1,2,3],
//        [1,3,2],
//        [2,1,3],
//        [2,3,1],
//        [3,1,2],
//        [3,2,1]
//        ]

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Solution2 {
    static List<Integer> l = new ArrayList<>();
    static int[] flag;
    static int n ;
    static List<List<Integer>> result = new ArrayList<>();
    public static void main(String[] args) {
        int[] num = readInput();
        n = num.length;
        flag = new int[num.length];
        for (int i =0;i<flag.length;i++)
            flag[i] = 0;
        dfs(0,num);
        for (List<Integer> iterator:result){
            System.out.println(iterator);
        }
    }

    public static void dfs(int count,int[] num){
        if(count==n){
            List<Integer> temp = new ArrayList<>(l);
            result.add(temp);
            return;
        }
        for (int i =0;i<n;i++){
            if (flag[i]==0){
                l.add(num[i]);
                flag[i] = 1;
                count ++;
                dfs(count,num);
                l.remove(l.size()-1);
                count--;
                flag[i] = 0;
            }
        }

    }

    public static int[] readInput(){
        List<Integer> list = new ArrayList<>();
        Scanner scanner = new Scanner(System.in);
        String str = scanner.nextLine();
        String substr = str.substring(1,str.length()-1);
        String[] num = substr.split(",");
        for (int i=0;i<num.length;i++){
            list.add(new Integer(num[i]));
        }
        int[] int_num= list.stream().mapToInt(Integer::valueOf).toArray();
        return  int_num;
    }
}
