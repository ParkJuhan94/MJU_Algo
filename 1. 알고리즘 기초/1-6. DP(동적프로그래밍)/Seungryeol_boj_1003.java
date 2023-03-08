import java.util.Scanner;

public class boj1003 {
    static int[] dp;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int T =sc.nextInt();
        int dp[][]= new int[41][2]; // 0출력되는 횟수


        dp[0][0]=1; //0번째 피보나치 0출력횟수
        dp[1][1]=1; //1번째 피보나치 1출력횟수
        dp[2][0]=1;
        dp[2][1]=1;
        for (int j=3; j<=40; j++){
            dp[j][0]=dp[j-1][0]+dp[j-2][0];
            dp[j][1]=dp[j-1][1]+dp[j-2][1];
        }

        for (int i=0; i<T; i++){
            int n =sc.nextInt();
            System.out.println(dp[n][0]+" "+dp[n][1]);
        }
    }

}
