package WEEK21.P9251;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/*
LCS(Longest Common Subsequence, 최장 공통 부분 수열)문제는 두 수열이 주어졌을 때,
모두의 부분 수열이 되는 수열 중 가장 긴 것을 찾는 문제이다.

예를 들어, ACAYKP와 CAPCAK의 LCS는 ACAK가 된다.
 */
public class Main {
    //static int N;
    static char[] str1;
    static char[] str2;
    static Integer[][] dp;
    static int max = Integer.MIN_VALUE;

    public static void main(String[] args) throws IOException {
        System.setIn(new FileInputStream("src/WEEK21/P9251/input.txt"));

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        str1 = br.readLine().toCharArray();
        str2 = br.readLine().toCharArray();

        dp = new Integer[str1.length][str2.length];


        System.out.println(lcs(str1.length-1, str2.length-1));
    }

    public static int lcs(int a, int b) {

        // 재귀의 탈출 조건
        if(a<0||b<0)
            return 0;

        if(dp[a][b]==null) {
            dp[a][b]=0;
            if(str1[a] == str2[b])
                dp[a][b] = lcs(a-1, b-1)+1;
            else
                dp[a][b] = Math.max(lcs(a-1,b), lcs(a,b-1));
        }

        return dp[a][b];
    }
}
