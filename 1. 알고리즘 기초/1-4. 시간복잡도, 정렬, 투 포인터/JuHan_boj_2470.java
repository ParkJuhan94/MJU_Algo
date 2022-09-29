package WEEK05.P2470;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

/**
 * 백준 2470 두 용액 (https://www.acmicpc.net/problem/2470)
 * 투 포인터 (+ 이분탐색)
 *
 * 1. 투 포인터 사용!
 * 2. 절댓값 사용하기
 */

public class Main {
    public static void main(String[] args) throws IOException {
        System.setIn(new FileInputStream("src/WEEK05/P2470/input.txt"));

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int[] liquid = new int[n];

        st = new StringTokenizer(br.readLine());

        for (int i = 0; i < n; i++) {
            liquid[i] = Integer.parseInt(st.nextToken());
        }

        // 오름차순 정렬 : 사전조건
        Arrays.sort(liquid);

        // 출력할 두 개의 int
        int[] output = new int[2];

        solution(n, liquid, output);

        System.out.println(output[0] + " " + output[1]);
    }

    private static void solution(int n, int[] liquid, int[] output) {
        // 양쪽에서 투포인터
        int start = 0;
        int end = n-1;
        int min = Integer.MAX_VALUE;    // 21억

        while (start < end) {
            int sum = liquid[start] + liquid[end];

            if (Math.abs(sum) < min){
                output[0] = liquid[start];
                output[1] = liquid[end];
                min = Math.abs(sum);
            }

            // sum에 따라서 투 포인터를 조정
            if (sum > 0) {
                end--;
            } else {
                start++;
            }
        }

    }
}
