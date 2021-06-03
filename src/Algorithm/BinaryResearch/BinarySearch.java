package Algorithm.BinaryResearch;

public class BinarySearch {
    public static void main(String[] args) {

    }

    //这是最基本的
    public static int Solution1(int nums[],int taraget){
        int left=0;
        int right = nums.length-1;
        while (left<=right){
            int mid = left +(right-left)/2;
            if (nums[mid]==taraget){
                return mid;
            }else if (nums[mid]<nums[right]){
                right = mid-1;

            }else {
                left = left+1;
            }
        }
        return left;
    }


}
