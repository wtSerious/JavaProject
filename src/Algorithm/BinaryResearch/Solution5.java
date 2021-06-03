package Algorithm.BinaryResearch;

import java.util.Arrays;
import java.util.Scanner;
//假设按照升序排序的数组在预先未知的某个点上进行了旋转。
//
//        ( 例如，数组[0,1,2,4,5,6,7] 可能变为[4,5,6,7,0,1,2])。
//
//        请找出其中最小的元素。
//
//        注意数组中可能存在重复的元素。
//
//        示例 1：
//
//        输入: [1,3,5]
//        输出: 1
//
public class Solution5 {
    public static void main(String[] args) {
        int[] input = readInput();
        int[] nums = Arrays.copyOf(input,input.length-1);
        int target = input[input.length-1];
        int result = Solution(nums,target);
        System.out.println(result);

    }

    public static int Solution(int[] nums,int target) {
        int l=0;
        int r=nums.length-1;
        int mid;
        while (l<r){
            mid = (l+r)/2;
            if (nums[mid]==nums[r])
                r = r+1;
            else {
                if (nums[mid]<nums[r])
                    r = mid;
                else
                    l = mid+1;

            }

        }
        return nums[l];
    }


    public static int[] readInput(){
        Scanner scanner = new Scanner(System.in);
        String str = scanner.nextLine();
        str = str.replaceAll("\\[","");
        str = str.replaceAll("\\]","");
        String[] s = str.split(",");
        int[] nums = new int[s.length];
        for (int i=0;i<nums.length;i++)
            nums[i] = Integer.valueOf(s[i]);

        return nums;
    }
}
