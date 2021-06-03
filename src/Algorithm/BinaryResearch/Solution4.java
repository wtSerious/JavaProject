package Algorithm.BinaryResearch;
import java.util.Scanner;

//
//已知一个长度为 n 的数组，预先按照升序排列，经由 1 到 n 次 旋转 后，得到输入数组。例如，原数组 nums = [0,1,2,4,5,6,7] 在变化后可能得到：
//        若旋转 4 次，则可以得到 [4,5,6,7,0,1,2]
//        若旋转 7 次，则可以得到 [0,1,2,4,5,6,7]
//        注意，数组 [a[0], a[1], a[2], ..., a[n-1]] 旋转一次 的结果为数组 [a[n-1], a[0], a[1], a[2], ..., a[n-2]] 。
//
//        给你一个元素值 互不相同 的数组 nums ，它原来是一个升序排列的数组，并按上述情形进行了多次旋转。请你找出并返回数组中的 最小元素 。
//https://leetcode-cn.com/problems/find-minimum-in-rotated-sorted-array/
//要想找到最小值得从右边开始比较
public class Solution4 {
    public static void main(String[] args) {
        int[] inputs = readInput();
        int result = Solution(inputs);
        System.out.println(result);
    }

    public static int Solution(int[] nums){
        int left=0;
        int right = nums.length-1;
        int mid;
        while (left<right){
            mid = (left+right)/2;
            if (nums[mid]>nums[right]){
                left = mid+1;
            }else {
                right = mid;
            }
        }
        return nums[left];
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
