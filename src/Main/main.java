package Main;

public class main {
    public static void main(String[] args) {
        System.out.println("Hello world!");
        final int max = 10;
        int [][]  odds = new int[max+1][];
        for(int n = 0; n<=max; n++)
            odds[n] = new int[n+1];

        for(int n = 0; n < odds.length; n++)
            for(int k =0; k<odds[n].length;k++)
            {
                int lotteryOdds = 1;
                for(int i =1; i<=k; i++)
                    lotteryOdds = lotteryOdds *(n-i+1)/i;

                odds[n][k] = lotteryOdds;

            }

        for (int[] n: odds)
        {
            for (int odd: n)
                System.out.printf("%4d",odd);
            System.out.println();
        }

    }
}
