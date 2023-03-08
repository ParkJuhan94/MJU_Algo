import java.util.Scanner;

public class boj9095 {
    static int[] dp;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int T= sc.nextInt();
        dp = new int[11];
        for (int i=0; i<T; i++){
            int n =sc.nextInt();
            System.out.println(DP(n));
        }
    }

    public static int DP(int n){
        dp[1]=1;
        dp[2]=2;
        dp[3]=4;

        for (int i=4; i<11; i++){
            dp[i]=dp[i-1]+dp[i-2]+dp[i-3];
        }

        return dp[n];
    }
}
