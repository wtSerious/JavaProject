package Try;

import java.lang.reflect.InvocationHandler;
import java.util.Scanner;

//5
//50,50 20,5 40,10 30,5 10,4
//100

//2
//50,60 30,25
//55
public class huawei {
    public static int[] m;
    public static int nodeNums;
    public static int[] n;
    public static int[] mins;
    public static int total;


    public static void main(String[] args) {
        readInput();
        int result = solution();
        for (int l:mins){
            System.out.println(l);
        }
//        System.out.println(result);
    }

    public static void readInput(){
        Scanner scanner = new Scanner(System.in);
        nodeNums = scanner.nextInt();
        scanner.nextLine();
        String nodes = scanner.nextLine();
        String[] splitNodes = nodes.split(" ");
        m = new int[splitNodes.length];
        n = new int[splitNodes.length];
        for (int i = 0;i<splitNodes.length;i++){
            String[] values = splitNodes[i].split(",");
            m[i] = Integer.valueOf(values[0]);
            n[i] = Integer.valueOf(values[1]);
        }
        total = scanner.nextInt();
        mins = new int[nodeNums];
    }



    public static int solution(){
        mins[0] = Math.min(total,m[0]+n[0]);
        if (nodeNums>1){
            mins[1] = Math.min(mins[0],m[1] + n[1]);
        }
        for (int i=2;i<nodeNums;i++){
            int minFirst = mins[i-1];
            int sum = 0;
            if (minFirst<m[i-1]){
                sum += Math.max(minFirst,m[i]);
            }else {
                sum += Math.max(m[i-1],m[i]);
                int minSecond = minFirst - mins[i-1];
                if (minSecond>=2*m[i]){
                    sum += 2*m[i];
                }else {
                    sum += minSecond;
                }
            }

             minFirst = mins[i-2];
            int sum2 = 0;
            if (minFirst<m[i-2]){
                sum2 += Math.max(minFirst,m[i]);
            }else {
                sum += Math.max(m[i-2],m[i]);
                int minSecond = minFirst - mins[i-2];
                if (minSecond>=2*m[i]){
                    sum2 += 2*m[i];
                }else {
                    sum2 += minSecond;
                }
            }

            mins[i] = Math.min(sum,sum2);
        }
        return mins[mins.length-1];
    }

//    public static int[] readInput(){
//        Scanner scanner = new Scanner(System.in);
//        String str = scanner.nextLine();
//        str = str.replace("nums = [","");
//        str = str.replace("]","");
//        String[] nums = str.split(",");
//        int[] n = new int[nums.length];
//        for (int i=0;i<nums.length;i++){
//            n[i] = Integer.valueOf(nums[i]);
//        }
//        return n;
//    }
}
