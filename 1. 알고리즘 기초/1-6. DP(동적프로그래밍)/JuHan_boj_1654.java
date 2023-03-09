package WEEK20.P2839;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static int N;

    public static void main(String[] args) throws IOException {
        System.setIn(new FileInputStream("src/WEEK20/P2839/input.txt"));

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int sugar, cnt = 0;
        sugar = Integer.parseInt(st.nextToken());

        /*
        먼저 3키로씩 뺀 뒤에, 5키로로 나누어 떨어지는 순간 계산하여 break; (그리디)
         */
        while (true)
        {
            if (sugar % 5 == 0)
            {
                cnt += sugar / 5;
                System.out.println(cnt);
                break;
            }

            sugar -= 3;
            cnt++;

            // 3키로랑 5키로 둘 다 안되는 경우
            if (sugar <= -1)
            {
                System.out.println(-1);
                break;
            }
        }
    }

}

/*
 dp풀이 https://jhhj424.tistory.com/40

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        if(n<5) {
            if(n==3) System.out.println(1);
            else System.out.println(-1);
            return;
        }
        int dp[] = new int[n+1];
        Arrays.fill(dp, 9999);
        dp[3] = 1;
        dp[5] = 1;
        for(int i=6; i<dp.length; i++) {
            dp[i] = Math.min(dp[i-3]+1, dp[i-5]+1);
        }
        if(dp[n] > 9999) {
            System.out.println(-1);
        }else {
            System.out.println(dp[n]);
        }
    }
}
*/









