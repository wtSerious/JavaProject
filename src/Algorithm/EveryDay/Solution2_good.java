package Algorithm.EveryDay;

import java.util.Scanner;
import java.util.Set;
import java.util.TreeSet;

//363. 矩形区域不超过 K 的最大数值和
//        给你一个 m x n 的矩阵 matrix 和一个整数 k ，找出并返回矩阵内部矩形区域的不超过 k 的最大数值和。
//
//        题目数据保证总会存在一个数值和不超过 k 的矩形区域。
//https://leetcode-cn.com/problems/max-sum-of-rectangle-no-larger-than-k/
//这道题很好，涉及到很多问题，二维前缀和的保存，降低枚举的复杂度，二分，如何在一维数组里找到不大于K的最大前缀和，分有负数和无负数。

/*
matrix = [[1,0,1],[0,-2,3]], k = 2
 */
public class Solution2_good {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String str = scanner.nextLine();
        String[] s = str.split(", ");
        s[0] = s[0].replace("matrix = ","");
        s[1] = s[1].replace("k = ","");
        int k = Integer.valueOf(s[1]);
        String[] nums = s[0].split("\\],\\[");
        int[][] map = null;
        for (int i=0;i<nums.length;i++){
            nums[i] = nums[i].replaceAll("\\[","");
            nums[i] = nums[i].replaceAll("\\]","");
            String[] n = nums[i].split(",");

            map = map==null?new int[nums.length][n.length]:map;
            for (int j=0;j<n.length;j++){
                map[i][j] = Integer.valueOf(n[j]);
            }
        }
        int result = Solution(map,k);
        System.out.println(result);
    }

    public static int Solution(int[][] map,int k){
        int[][] sum = new int[map.length+1][map[0].length+1];
        for (int i=1;i<sum.length;i++){
            for (int j=1;j<sum[i].length;j++){
                sum[i][j] = sum[i-1][j] + sum[i][j-1] - sum[i-1][j-1] + map[i-1][j-1];
            }
        }

        int ans = -10000000;
        for (int top=1;top<sum.length;top++){
            for (int bottom=top;bottom<sum.length;bottom++){
                for (int r=1;r<sum[0].length;r++){
                    TreeSet<Integer> set = new TreeSet<>();
                    set.add(0);
                    int right = sum[bottom][r] - sum[top-1][r];
                    Integer left = set.ceiling(right-k);
                    if (left!=null){
                        ans = Math.max(ans,right-left);
                    }
                    set.add(right);
                }
            }

        }
        return ans;
    }

}
