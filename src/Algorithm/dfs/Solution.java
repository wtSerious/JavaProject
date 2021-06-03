package Algorithm.dfs;

//给定一个可包含重复数字的序列 nums ，按任意顺序 返回所有不重复的全排列。
//
//         
//
//        示例 1：
//
//        输入：nums = [1,1,2]
//        输出：
//        [[1,1,2],
//        [1,2,1],
//        [2,1,1]]
//        示例 2：
//
//        输入：nums = [1,2,3]
//        输出：[[1,2,3],[1,3,2],[2,1,3],[2,3,1],[3,1,2],[3,2,1]]


import java.lang.reflect.Array;
import java.util.*;

public class Solution {
    static List<Integer> l;
    static int[] flag;
    static int n ;
    static List<List<Integer>> result;
    public static void main(String[] args) {
        l = new ArrayList<>();
        result = new ArrayList<>();
        int[] nums = readInput();
        n = nums.length;
        Arrays.sort(nums);
        flag = new int[nums.length];
        for (int i =0;i<flag.length;i++)
            flag[i] = 0;
        dfs(0,nums);
        for (List<Integer> iterator:result){
            System.out.println(iterator);
        }
    }

    public static void dfs(int count,int[] num){
        if(count==n){
            List<Integer> temp = new ArrayList<>(l);
            result.add(temp);
            return;
        }
        for (int i =0;i<n;i++){
//            System.out.println(i);
            if (flag[i]==0){
                if(i>0)
                    if(num[i-1]==num[i]&&flag[i-1]==0)
                        continue;//之前在这里写了 return ,导致第一个初始循环会结束后面的进不来所以用 continue;
                l.add(num[i]);
                flag[i] = 1;
                count ++;
                dfs(count,num);
                l.remove(l.size()-1);
                count--;
                flag[i] = 0;
            }
        }

    }

    public static int[] readInput(){
        List<Integer> list = new ArrayList<>();
        Scanner scanner = new Scanner(System.in);
        String str = scanner.nextLine();
        String substr = str.substring(1,str.length()-1);
        String[] num = substr.split(",");
        for (int i=0;i<num.length;i++){
            list.add(new Integer(num[i]));
        }
        int[] int_num= list.stream().mapToInt(Integer::valueOf).toArray();
        return  int_num;
    }
}
