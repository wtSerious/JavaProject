package Algorithm.Dp;
//有 n 个气球，编号为0 到 n - 1，每个气球上都标有一个数字，这些数字存在数组 nums 中。
//
//        现在要求你戳破所有的气球。戳破第 i 个气球，你可以获得 nums[i - 1] * nums[i] * nums[i + 1] 枚硬币。 这里的 i - 1 和 i + 1 代表和 i 相邻的两个气球的序号。如果 i - 1或 i + 1 超出了数组的边界，那么就当它是一个数字为 1 的气球。
//
//        求所能获得硬币的最大数量。
//https://leetcode-cn.com/problems/burst-balloons/

//输入：nums = [3,1,5,8]
//输出：167
//解释：
//nums = [3,1,5,8] --> [3,5,8] --> [3,8] --> [8] --> []
//coins =  3*1*5    +   3*5*8   +  1*3*8  + 1*8*1 = 167

import java.util.Scanner;

public class Solution7 {
    public static void main(String[] args) {
        int[] input = readInput();
        int[][] dp = new int[input.length+2][input.length+2];
        int[] val = new int[input.length+2];
        for (int i=0;i<input.length;i++){
            val[i+1] = input[i];
        }
        val[0]=val[val.length-1] = 1;
        for (int i=input.length-1;i>=0;i--){
            for (int j=i+2;j<=input.length+1;j++){
                for (int k=i+1;k<j;k++){
//                    System.out.println(input[i-1]+" "+input[k-1]+" "+input[j-1]);
                    dp[i][j] = Math.max(val[k]*val[j]*val[i]+dp[i][k]+dp[k][j],dp[i][j]);
                }
            }
        }
        System.out.println(dp[0][input.length+1]);
    }

    public static int[] readInput(){
        Scanner scanner = new Scanner(System.in);
        String input = scanner.nextLine();
        input = input.replace("nums = ","");
        input = input.replace("[","");
        input = input.replace("]","");
        System.out.println(input);
        String[] strs = input.split(",");
        int[] nums = new int[strs.length];
        for (int i=0;i<nums.length;i++)
            nums[i] = Integer.valueOf(strs[i]);
        return nums;
    }
}
