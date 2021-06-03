//给定一个整数数组A，返回 A中最长等差子序列的长度。
//
//回想一下，A的子序列是列A[i_1], A[i_2], ..., A[i_k] 其中0 <= i_1 < i_2 < ... < i_k <= A.length - 1。并且如果B[i+1] - B[i]0 <= i < B.length - 1) 的值都相同，那么序列是等差的。
//        示例 1：
//输入：[3,6,9,12]
//输出：4
//解释：
//整个数组是公差为 3 的等差数列。


package Algorithm.Dp;

import java.util.*;

public class Solution1 {
    public static void main(String[] args) {
        int[] A = readInput();
        int N = 100000;
        Map<Integer,Integer> dp = new HashMap<>();
        int ans = -1;
        for (int i=0;i<A.length;i++){
            for (int j=0;j<i;j++){
                int temp = 1;
                if(dp.get(j*N+A[i]-A[j])!=null){
                    temp = dp.get(j*N+A[i]-A[j]) + 1;
                    if (dp.get(i*N+A[i]-A[j])!=null){
                        if(dp.get(i*N+A[i]-A[j])<temp)
                            dp.put(i*N+A[i]-A[j],temp);
                    }else {
                        dp.put(i*N+A[i]-A[j],temp);
                    }
                }else {
                    dp.put(i*N+A[i]-A[j],temp);
                    dp.put(j*N+A[i]-A[j],0);
                }
                if(temp>ans)
                    ans = temp;
            }
        }
        System.out.println(ans+1);
    }

    public static int[] readInput(){
        List<Integer> list = new ArrayList<>();
        Scanner scanner = new Scanner(System.in);
        String str = scanner.nextLine();
        String[] num = str.split(",");
        for (int i=0;i<num.length;i++){
            list.add(new Integer(num[i]));
        }
        int[] int_num= list.stream().mapToInt(Integer::valueOf).toArray();
        return  int_num;
    }
}
