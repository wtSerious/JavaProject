package Algorithm.dfs;

import java.util.Scanner;

//给出集合[1,2,3,...,n]，其所有元素共有n! 种排列。
//
//        按大小顺序列出所有排列情况，并一一标记，当n = 3 时, 所有排列如下：
//
//        "123"
//        "132"
//        "213"
//        "231"
//        "312"
//        "321"
//        给定n 和k，返回第个排列。
//
//
//
//        示例 1：
//
//        输入：n = 3, k = 3
//        输出："213"
//https://leetcode-cn.com/problems/permutation-sequence/
public class Solution4 {
    static int count;
    static String r;
    public static void main(String[] args) {
        int[] result = readInput();
        int n =result[0];
        int k = result[1];

        solution(n,k);
    }

    public static void solution(int n,int k){
        count = 0;
        String l = "";
        int[] visist = new int[n+1];
        for (int i=1;i<=n;i++){
            if (count<k){
                dfs(n,k,l,visist);
            }
        }
    }

    public static void dfs(int n,int k,String l,int[] visit){
        if (count>=k)
            return;
        if (l.length()==n){
            count++;
            if (count==k){
                r = l;
                return;
            }
        }
        for (int i=1;i<=n;i++){
            if (visit[i]==0){
                visit[i]=1;
                l += String.valueOf(i);
                dfs(n,k,l,visit);
                l = l.substring(0,l.length()-1);
                visit[i] = 0;
            }
        }
    }


    public static int[] readInput(){
        Scanner scanner = new Scanner(System.in);
        String input = scanner.nextLine();
        int[] result = new int[2];
        for(int i=0;i<input.length();i++){
            char temp = input.charAt(i);
            if(temp>='0'&&temp<='9'){
                if (result[0]==0)
                    result [0] = temp-'0';
                else{
                    result[1] = temp-'0';
                    break;
                }
            }
        }
        return result;
    }

}
