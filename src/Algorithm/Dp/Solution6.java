package Algorithm.Dp;

import javax.sound.midi.Soundbank;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
//给你一个由 无重复 正整数组成的集合 nums ，请你找出并返回其中最大的整除子集 answer ，子集中每一元素对 (answer[i], answer[j]) 都应当满足：
//        answer[i] % answer[j] == 0 ，或
//        answer[j] % answer[i] == 0
//        如果存在多个有效解子集，返回其中任何一个均可。
//
//
//
//        示例 1：
//
//        输入：nums = [1,2,3]
//        输出：[1,2]
//        解释：[1,3] 也会被视为正确答案。
//        示例 2：
//
//        输入：nums = [1,2,4,8]
//        输出：[1,2,4,8]
public class Solution6 {

    public static void main(String[] args) {
        int[] input = readInput();
        List<Integer> l = Solution(input);
        for (int i:l){
            System.out.println(i);
        }
    }

    public static List<Integer> Solution(int[] nums){
        int[] dp = new int[nums.length];
        dp[0] = 0;
        int max = 0;
        Arrays.sort(nums);
        int index =0;
        for (int i=1;i<nums.length;i++){
            for (int j=i-1;j>=0;j--){
                if (nums[i]%nums[j]==0){
                    dp[i] = Math.max(dp[i],dp[j]+1);
                }
            }
            if (max<dp[i]){
                max = dp[i];
                index = i;
            }
        }

        List<Integer> l = new ArrayList<>();
        l.add(nums[index]);
        int temp = nums[index];
        max--;
        index--;
        while (max>=0){
            if (dp[index]==max&&temp%nums[index]==0){
                l.add(nums[index]);
                max--;
                temp = nums[index];
            }
            index--;
        }
        return l;
    }

    public static int[] readInput(){
        Scanner scanner = new Scanner(System.in);
        String str = scanner.nextLine();
        str = str.replace("nums = [","");
        str = str.replace("]","");
        String[] nums = str.split(",");
        int[] n = new int[nums.length];
        for (int i=0;i<nums.length;i++){
            n[i] = Integer.valueOf(nums[i]);
        }
        return n;
    }
}
