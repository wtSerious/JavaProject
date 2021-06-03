package Algorithm.BinaryResearch;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
//给定一个按照升序排列的整数数组 nums，和一个目标值 target。找出给定目标值在数组中的开始位置和结束位置。
//
//        如果数组中不存在目标值 target，返回[-1, -1]。
//
//        进阶：
//
//        你可以设计并实现时间复杂度为O(log n)的算法解决此问题吗？
//
//
//        示例 1：
//
//        输入：nums = [5,7,7,8,8,10], target = 8
//        输出：[3,4]
//        示例2：
//
//        输入：nums = [5,7,7,8,8,10], target = 6
//        输出：[-1,-1]
//https://leetcode-cn.com/problems/find-first-and-last-position-of-element-in-sorted-array/
public class Solution2 {
    public static void main(String[] args) {
        int[] input = readInput();
        int[] nums = Arrays.copyOf(input,input.length-1);
        int target = input[input.length-1];
        int[] result = new int[]{-1,-1};
        int left = solution(nums,target);
        int right = solution2(nums,target);

        if (left<=right&&right<nums.length&&nums[left]==target&&nums[right]==target){
            result[0] = left;
            result[1] = right;
        }
        System.out.println(result[0]);
        System.out.println(result[1]);
    }

    public static int solution(int[] nums,int target){
        int l=0;
        int r=nums.length-1;
        int mid;
        while (l<=r){
            mid = (l+r)/2;
            if (nums[mid]>=target)
                r = mid-1;
            else
                l = mid+1;
        }

        return l;
    }

    public static int solution2(int[] nums,int target){
        int l=0;
        int r=nums.length-1;
        int mid;
        while (l<=r){
            mid = (l+r)/2;
            if (nums[mid]<=target){
                l = mid+1;
            }

            else
                r = mid-1;
//            System.out.println(l);
        }

        return r;
    }

    //不能用solution3的原因是l=r时的那个值也是需要判断的。如果传入的只有一个值，那么就会直接返回了
    public static int solution3(int[] nums,int target){
        int l=0;
        int r=nums.length-1;
        int mid;
        while (l<r){
            mid = (l+r)/2;
            if (nums[mid]<=target){
                l = mid+1;
            }
            else
                r = mid;
//            System.out.println(l);
        }

        return r;
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
