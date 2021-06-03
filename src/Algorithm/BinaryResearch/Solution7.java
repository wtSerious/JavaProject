package Algorithm.BinaryResearch;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
//给定两个大小分别为 m 和 n 的正序（从小到大）数组nums1 和nums2。请你找出并返回这两个正序数组的 中位数 。
//        示例 1：
//
//        输入：nums1 = [1,3], nums2 = [2]
//        输出：2.00000
//        解释：合并数组 = [1,2,3] ，中位数 2
//        示例 2：
//
//        输入：nums1 = [1,2], nums2 = [3,4]
//        输出：2.50000
//        解释：合并数组 = [1,2,3,4] ，中位数 (2 + 3) / 2 = 2.5
//https://leetcode-cn.com/problems/median-of-two-sorted-arrays/
//难，好多细节啊，细节处理怎么办呢。
public class Solution7 {

    public static void main(String[] args) {
        List<List<Integer>> input = readInput();
        int[] nums1 = new int[input.get(0).size()];
        int[] nums2 = new int[input.get(1).size()];
        for (int i=0;i<nums1.length;i++)
            nums1[i] = input.get(0).get(i);
        for (int i=0;i<nums2.length;i++)
            nums2[i] = input.get(1).get(i);
        double result = Solution(nums1,nums2);
        System.out.println(result);
    }

    public static double Solution(int[] nums1,int[] nums2){
        int m = nums1.length;
        int n = nums2.length;
        if ((m+n)%2==1){
            return search(nums1,nums2,(m+n)/2+1);
        }else {
            return (search(nums1,nums2,(m+n)/2)+ search(nums1,nums2,(m+n)/2+1))/2.0;
        }

    }

    public static int search(int[] nums1,int[] nums2,int k){
        int index1 = 0;
        int index2 = 0;

        while (true){
            //判断边界，为什么要先判断边界呢
            if (index1==nums1.length){
                return nums2[index2+k-1];
            }
            else if(index2==nums2.length){
                return nums1[index1+k-1];
            }
            if (k==1)
                return Math.min(nums1[index1],nums2[index2]);
            //为什么是Min，还有各种-1？
            int s = Math.min(index1+(k/2)-1,nums1.length-1);
            int t = Math.min(index2+(k/2)-1,nums2.length-1);
            int temp1 = nums1[s];
            int temp2 = nums2[t];
            //如何修改index和减少k值
            if (temp1>=temp2){
                k = k - (t-index2) - 1;
                index2 = t+1;
            }else{
                k = k - (s-index1) - 1;
                index1 = s + 1;
            }
        }
    }



    public static List<List<Integer>> readInput() {
        Scanner scanner = new Scanner(System.in);
        String input = scanner.nextLine();
        String[] str = input.split(", ");
        str[0] = str[0].replace("nums1 = [","");
        str[0] = str[0].replace("]","");
        str[1] = str[1].replace("nums2 = [","");
        str[1] = str[1].replace("]","");
        List<List<Integer>> result = new ArrayList<>();
        for (int i=0;i<str.length;i++){
            List<Integer> l = new ArrayList<>();
            String[] nums = str[i].split(",");
            for (int j=0;j<nums.length;j++){
                l.add(Integer.valueOf(nums[j]));
            }
            result.add(l);
        }
        return result;
    }

}
