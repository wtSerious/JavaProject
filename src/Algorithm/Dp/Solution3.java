package Algorithm.Dp;


import Algorithm.BinaryResearch.Solution;

import java.util.*;

/*
s1 = "great", s2 = "rgeat"
s1 = "eebaacbcbcadaaedceaaacadccd", s2 = "eadcaacabaddaceacbceaabeccd"

 */
public class Solution3 {
    public static Set<String> visited ;
    public static void main(String[] args) {
        String[] input= readInput();
        String s1 = input[0];
        String s2 = input[1];
        visited = new HashSet<>();
//        boolean result = Solution(s1,s2);
//        System.out.println(result);
        boolean result = Solution2(s1,s2,0,0,s1.length());
        System.out.println(result);
    }

    public static boolean Solution2(String s1,String s2,int num1,int num2,int k){
        if (s1.substring(num1,num1+k).equals(s2.substring(num2,num2+k)))
            return true;
        if (!isOrder(s1.substring(num1,num1+k),s2.substring(num2,num2+k),num1,num2,k))
            return false;
        if (visited.contains(s1.substring(num1,num1+k)+"-"+s2.substring(num2,num2+k)))
            return false;
        visited.add(s1.substring(num1,num1+k)+"-"+s2.substring(num2,num2+k));

        for (int l=1;l<k;l++){
            if(Solution2(s1,s2,num1,num2,l)&&Solution2(s1,s2,num1+l,num2+l,k-l))
                return true;
            else if (Solution2(s1,s2,num1,num2+k-l,l)&&Solution2(s1,s2,num1+l,num2,k-l)){
                return true;
            }
        }
        return false;
    }

    public static boolean isOrder(String s1,String s2,int i,int j,int k){
        Map<Integer,Integer> map = new HashMap<>();
        int[] num1 = new int['z'+1];
        int[] num2 = new int['z'+1];
        for (int n=0;n<s1.length();n++){
            num1[s1.charAt(n)]++;
            num2[s2.charAt(n)]++;

        }
        for (int n=0;n<num1.length;n++){
            if (num1[n]!=num2[n])
                return false;
        }
        return true;
    }

    public static boolean Solution(String s1,String s2){
        if (s1.length()!=s2.length())
            return false;
        if (s1.equals(s2))
            return true;
        boolean[][][] dp = new boolean[s1.length()][s1.length()][s1.length()+1];

        //初始化
        for (int i=0;i<s1.length();i++){
            for (int j=0;j<s2.length();j++){
                if (s1.charAt(i)==s2.charAt(j))
                    dp[i][j][1] = true;
            }
        }

        for (int n=2;n<=s1.length();n++){
            for (int i=0;i<=s1.length()-n;i++){
                for (int j=0;j<=s1.length()-n;j++){
                    for (int k=1;k<=n-1;k++){
                        if ((dp[i][j][k]&&dp[i+k][j+k][n-k])){
                            dp[i][j][n] = true;
                            break;
                        }else if ((dp[i][j+n-k][k]&&dp[i+k][j][n-k])){
                            dp[i][j][n] = true;
                            break;
                        }

                    }
                }
            }
        }
        return dp[0][0][s1.length()-1];
    }


    public static String[] readInput(){
        Scanner scanner = new Scanner(System.in);
        String input = scanner.nextLine();
        input = input.replace("s1 = ","");
        input = input.replace(" s2 = ","");
        input = input.replaceAll("\"","");
        String[] arr = input.split(",");
        return arr;


    }
}
