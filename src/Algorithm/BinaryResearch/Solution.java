package Algorithm.BinaryResearch;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

//整数数组 nums 按升序排列，数组中的值 互不相同 。
//
//        在传递给函数之前，nums 在预先未知的某个下标 k（0 <= k < nums.length）上进行了 旋转，使数组变为 [nums[k], nums[k+1], ..., nums[n-1], nums[0], nums[1], ..., nums[k-1]]（下标 从 0 开始 计数）。例如， [0,1,2,4,5,6,7] 在下标 3 处经旋转后可能变为 [4,5,6,7,0,1,2] 。
//
//        给你 旋转后 的数组 nums 和一个整数 target ，如果 nums 中存在这个目标值 target ，则返回它的下标，否则返回-1。
//
//
//        示例 1：
//
//        输入：nums = [4,5,6,7,0,1,2], target = 0
//        输出：4
//https://leetcode-cn.com/problems/search-in-rotated-sorted-array/
public class Solution {
    public static void main(String[] args) {
        int[] input = readInput();
        int[] nums = Arrays.copyOf(input,input.length-1);
        int target = input[input.length-1];
        int result = Solution(nums,target);
        System.out.println(result);
    }

    public static int Solution(int[] nums,int target){
        int l=0;
        int r=nums.length-1;
        int mid;
        while (l<=r){
            mid = (l+r)/2;
            if (nums[mid]==target)
                return mid;
            else if (nums[l]<=nums[mid]){
                if (target>=nums[l]&&target<nums[mid])
                    r = r-1;
                else
                    l = mid+1;
            }else {
                if (target>nums[mid]&&target<=nums[r])
                    l = mid+1;
                else
                    r = r-1;

            }
        }
        if (nums[l]==target)
            return l;
        else
            return -1;
    }

    public static int[] readInput() {
        Scanner scanner = new Scanner(System.in);
        String input = scanner.nextLine();
        List<Integer> l = new ArrayList<>();
        for (int i = 0; i < input.length(); i++) {
            char temp = input.charAt(i);
            if (temp >= '0' && temp <= '9')
                l.add(Integer.valueOf(temp - '0'));
        }
        int[] result = new int[l.size()];
        for (int i = 0; i < result.length; i++)
            result[i] = l.get(i);

        return result;
    }
}
