package Algorithm.Dp;

import java.util.Scanner;

//https://leetcode-cn.com/problems/edit-distance/
public class Solution2 {
    public static void main(String[] args) {
        String[] input = readInput();
        String word1 = input[0];
        String word2 = input[1];
        System.out.println(word1);
        System.out.println(word2);

        int result = solution(word1,word2);
        System.out.println(result);
    }

    public static int solution(String word1,String word2){
        int[][] dp = new int[word1.length()+1][word2.length()+1];
        for (int i = 0; i < word1.length() + 1; i++) {
            dp[i][0] = i;
        }
        for (int j = 0; j < word2.length() + 1; j++) {
            dp[0][j] = j;
        }
        for (int i=1;i<=word1.length();i++){
            char c1 = word1.charAt(i-1);
            for (int j=1;j<=word2.length();j++){
                char c2 = word2.charAt(j-1);
                if (c1==c2){
                    dp[i][j] = dp[i-1][j-1];
                }else {
                    dp[i][j] = Math.min(dp[i-1][j]+1,Math.min(dp[i][j-1]+1,dp[i-1][j-1]+1));
                }
            }
        }
        return dp[word1.length()][word2.length()];
    }

    public static String[] readInput(){
        Scanner scanner = new Scanner(System.in);
        String input = scanner.nextLine();
        String[] str_array = input.split(",");
        String[] result = new String[str_array.length];
        for (int i=0;i<str_array.length;i++){
            int flag =1;
            int start = str_array[i].indexOf("\"");
            int end = str_array[i].lastIndexOf("\"");
            result[i] = str_array[i].substring(start+1,end);

        }
        return result;
    }
}
