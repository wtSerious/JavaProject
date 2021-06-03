package Algorithm.Dp;

import java.util.Scanner;

public class Solution5 {
    public static void main(String[] args) {
        String input =  readInput();
        int[] dp = new int[input.length()];
        for (int i=0;i<input.length();i++){
            if (input.charAt(i)!='0'){
                if (i==0)
                    dp[i]=1;
                else
                    dp[i] = dp[i-1];
            }
            if (i-1>0){
                if (input.charAt(i-1)=='0')
                    continue;
                int num = Integer.valueOf(input.substring(i-1,i+1));
                if (num>0&&num<27){
                    dp[i] += dp[i-2];
                }
            }else if (i-1==0){
                if (input.charAt(i-1)=='0')
                    continue;
                int num = Integer.valueOf(input.substring(i-1,i+1));
                if (num>0&&num<27){
                    dp[i] += 1;
                }
            }
        }
        System.out.println(dp[input.length()-1]);
    }

    public static String readInput(){
        Scanner scanner = new Scanner(System.in);
        String input = scanner.nextLine();
        input = input.replaceAll("s = ","");
        input = input.replaceAll("\"","");

        return input;
    }
}
