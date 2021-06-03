package Main;

import java.awt.*;
import java.util.ArrayList;
import java.util.List;
import java.util.TreeMap;

public class Zhuichanghuiwenzichuan {

    public static String solution(String s){
        int n = s.length();
        boolean[][] dp = new boolean[n][n];
        String ans = "";
        for(int l =0; l < n; ++l){
            for(int i =0; i+l < n;++i){
                if(l==0){
                    dp[i][i+l] =  true;
                }else if(l==1){
                    dp[i][i+l] = (s.charAt(i)==s.charAt(i+l));
                }else{
                    dp[i][i+l] = (s.charAt(i)==s.charAt(i+l))&&(dp[i+1][i+l-1]);
                }
                if(dp[i][i+l]&&((l+1)>ans.length())){
                    ans = s.substring(i,i+l+1);
                }
            }

        }
        return ans;
    }

    public static void main(String[] args) {
        String s =  "cbbd";
        String res = solution(s);
        System.out.print(res);

    }


}
