package WEEK20.P1463;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

// https://odysseyj.tistory.com/19
// DP : BOTTOM-UP
// 재귀함수 (Top-down)이나 반복문(Bottom-UP)을 사용 가능
public class Main {
    static int N;

    public static void main(String[] args) throws IOException {
        System.setIn(new FileInputStream("src/WEEK20/P1463/input.txt"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int number = Integer.parseInt(br.readLine());
        int dp[] = new int[number+1];
        dp[0] = 0;
        dp[1] = 0;
        for (int i = 2; i <= number; i++){
            dp[i] = dp[i-1] + 1;    // i가 2나 3의 배수가 아닌 경우를 위해서 따로 빼줌
            if (i % 2 == 0) dp[i] = Math.min(dp[i], dp[i/2] + 1);
            if (i % 3 == 0) dp[i] = Math.min(dp[i], dp[i/3] + 1);
        }
        System.out.println(dp[number]);
        br.close();
    }
}


/*
재귀 : top - down

public class Main{

    public static int d[];
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int number = Integer.parseInt(br.readLine());
        d = new int[number+1];
        System.out.println(calculate(number));
    }

    public static int calculate(int number){
        if (number == 1){
            return 0;
        }
        if (d[number] > 0){
            return d[number];
        }
        d[number] = calculate(number-1) + 1;
        if (number%3 == 0) {
            d[number] = Math.min(d[number],calculate(number/3) +1);
        }
        if (number%2 == 0) {
            d[number] = Math.min(d[number],calculate(number/2) +1);
        }
        return d[number];
    }
}

 */
