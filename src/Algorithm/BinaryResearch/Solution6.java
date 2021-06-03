package Algorithm.BinaryResearch;

import java.util.Scanner;
//符合下列属性的数组 arr 称为 山脉数组 ：
//        arr.length >= 3
//        存在 i（0 < i< arr.length - 1）使得：
//        arr[0] < arr[1] < ... arr[i-1] < arr[i]
//        arr[i] > arr[i+1] > ... > arr[arr.length - 1]
//        给你由整数组成的山脉数组 arr ，返回任何满足 arr[0] < arr[1] < ... arr[i - 1] < arr[i] > arr[i + 1] > ... > arr[arr.length - 1] 的下标 i 。
//
//
//        示例 1：
//
//        输入：arr = [0,1,0]
//        输出：1
//https://leetcode-cn.com/problems/peak-index-in-a-mountain-array/
//public class Solution6 {
//    public static void main(String[] args) {
//        int[] nums = readInput();
//        int result = Solution(nums);
//        System.out.println(result);
//    }
//
//    public static int Solution(int[] arr){
//        int l = 0;
//        int r = arr.length-1;
//        int mid = 0;
//        while (l<r-1){
//            mid = (l+r)/2;
//            if (arr[mid]>arr[mid-1]&&arr[mid]>arr[mid+1])
//                return mid;
//            else if(arr[mid]>arr[mid-1]&&arr[mid]<arr[mid+1])
//                l = mid;
//            else
//                r = mid;
//        }
//        return mid;
//    }
//
//    public static int[] readInput(){
//        Scanner scanner = new Scanner(System.in);
//        String str = scanner.nextLine();
//        str = str.replaceAll("arr = \\[","");
//        str = str.replaceAll("\\]","");
//        String[] s = str.split(",");
//        int[] nums = new int[s.length];
//        for (int i=0;i<nums.length;i++)
//            nums[i] = Integer.valueOf(s[i]);
//
//        return nums;
//    }
//}
