package Main;

import java.util.*;

public class aiqiyi01 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String[] strs = scanner.nextLine().split(" ");
        int len = strs.length;
        int[] nums = new int[len];
        for (int i = 0;i < len;i++){
            nums[i] = Integer.parseInt(strs[i]);
        }
        System.out.println(value(nums));
    }

    public static int value(int[] nums){
        if(nums == null || nums.length < 2){
            return 0;
        }
        int res = Integer.MIN_VALUE;
        int peak = nums[0], valley = nums[0];
        for(int i = 1; i < nums.length;i++){
            if(nums[i] >= nums[i-1]){
                peak = nums[i];
            }else{
                valley = nums[i];
            }
            if(peak - valley > res){
                res = peak - valley;
            }
        }
        return res;
    }
}
