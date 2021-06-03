package Algorithm.Dp;

import Algorithm.BinaryResearch.Solution;

import java.awt.image.ImageProducer;
import java.util.Map;
import java.util.Scanner;

public class Solution4 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String input =scanner.nextLine();
        input = input.replaceAll("\"","");
        int result = Solution(input);
        System.out.println(result);
    }

    public static int Solution(String s){
        int[][] dp = new int[s.length()][s.length()];
        if (s.length()==1){
            return 1;
        }else if (s.length()==2){
            return s.charAt(0)==s.charAt(1)?2:1;
        }
//        for (int i=0;i<s.length()-1;i++) {
//            dp[i][i] = 1;
//            if (s.charAt(i)==s.charAt(i+1))
//                dp[i][i+1] = 2;
//            else
//                dp[i][i+1] = 1;
//        }
        dp[s.length()-1][s.length()-1] = 1;

        for (int len=2;len<=s.length();len++){
            for (int i=0;i<=s.length()-len;i++){
                if (s.charAt(i)==s.charAt(i+len-1)){
                    dp[i][i+len-1] = dp[i+1][i+len-2] + 2;
                }else {
                    dp[i][i+len-1] = Math.max(dp[i][i+len-2],dp[i+1][i+len-1]);
                }
            }
        }
        return dp[0][s.length()-1];
    }


}
