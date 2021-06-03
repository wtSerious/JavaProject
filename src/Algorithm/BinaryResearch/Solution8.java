package Algorithm.BinaryResearch;

import java.util.Arrays;
import java.util.Scanner;

public class Solution8 {
//    public static void main(String[] args) {
//        double distance = 1e-17;
//        int input = readInput();
//        double l = 0;
//        double r = input;
//        double mid;
//        while (true){
//            mid = (l+r)/2;
//            if (Math.abs(mid*mid-input)<distance)
//                break;
//            if (mid*mid<input){
//                l = mid;
//            }else
//                r = mid;
//        }
//        System.out.println(mid);
//    }

    public static void main(String[] args) {
        double distance = 1e-17;
        int x = readInput();

        int l = 0;
        int r = x;
        int mid;
        while(l<=r){
            mid = l+(r-l)/2;
            if((long)mid*mid>x){
                r = mid -1;
            }else{
                l = mid+1;
            }
            System.out.println(l);
//            System.out.println(r);
        }
        System.out.println(r);
    }

    public static int readInput(){
        Scanner scanner = new Scanner(System.in);
        int input = scanner.nextInt();
        return input;
    }
}
