package Try;

public class Main22 {
    public static void main(String[] args) {
        int x = 100;
//        x = x&(x-1);
//        x = x&(x-1);
//        System.out.println(x);
//        System.out.println(Math.sqrt(808201));
        System.out.println(202051*202051);
    }

    public static boolean find(int num){
        int left = 0, right = num;
        while (left <= right) {
            int mid = (right - left) / 2 + left;
            long square = (long) mid * mid;
            if (square < num) {
                left = mid + 1;
            } else if (square > num) {
                right = mid - 1;
            } else {
                return true;
            }
        }
        return false;
    }



}
