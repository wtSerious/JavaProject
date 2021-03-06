package Algorithm.BinaryResearch;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

//已知存在一个按非降序排列的整数数组 nums ，数组中的值不必互不相同。
//
//        在传递给函数之前，nums 在预先未知的某个下标 k（0 <= k < nums.length）上进行了 旋转 ，使数组变为 [nums[k], nums[k+1], ..., nums[n-1], nums[0], nums[1], ..., nums[k-1]]（下标 从 0 开始 计数）。例如， [0,1,2,4,4,4,5,6,6,7] 在下标 5 处经旋转后可能变为 [4,5,6,6,7,0,1,2,4,4] 。
//
//        给你 旋转后 的数组 nums 和一个整数 target ，请你编写一个函数来判断给定的目标值是否存在于数组中。如果 nums 中存在这个目标值 target ，则返回 true ，否则返回 false 。
//
//
//
//        示例：
//
//        输入：nums = [2,5,6,0,0,1,2], target = 0
//        输出：true
//https://leetcode-cn.com/problems/search-in-rotated-sorted-array-ii/
public class Solution3 {
    public static void main(String[] args) {
        int[] input = readInput();
        int[] nums = Arrays.copyOf(input,input.length-1);
        int target = input[input.length-1];
        boolean ok = Solution(nums,target);
        System.out.println(ok);

    }

        public static boolean Solution(int[] nums,int target) {
            int l=0;
            int r=nums.length-1;
            int mid;
            while (l<=r){
                mid = (l+r)/2;
//                System.out.println(mid);
                if (nums[mid]==target)
                    return true;
                if (nums[l]==nums[r]){
                    l = l+1;
                }else {
                    if (nums[l]<=nums[mid]){
                        if (target>=nums[l]&&target<nums[mid])
                            r = mid-1;
                        else
                            l = l + 1;
                    }else {
                        if (target>nums[mid]&&target<=nums[r])
                            l = mid+1;
                        else
                            r = mid-1;
                    }
                }

            }
            return false;
        }

    public static int[] readInput() {
        Scanner scanner = new Scanner(System.in);
        String input = scanner.nextLine();
        input = input.replace("nums = [","");
        input = input.replace("]","");
        input = input.replace("target =","").replace(" ","");
        String[] str = input.split(",");
        int[] out = new int[str.length];
        for (int i=0;i<out.length;i++)
            out[i] = Integer.valueOf(str[i]);
        return out;
    }
}
