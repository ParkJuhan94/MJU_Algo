package WEEK08.P2531;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static int N;
    static int numSushi;
    static int numPick;
    static int coupon;
    static int p1, p2, max;
    static int[] sushi, picked;

    public static void main(String[] args) throws IOException {
        System.setIn(new FileInputStream("src/WEEK08/P2531/input.txt"));

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        numSushi = Integer.parseInt(st.nextToken());
        numPick = Integer.parseInt(st.nextToken());
        coupon = Integer.parseInt(st.nextToken()) - 1;
        max = 0;
        p1 = 0;
        p2 = numPick - 1;
        sushi = new int[N];                 // 회전벨트 전체
        picked = new int[numSushi];         // 현재 접시의 스시 카운팅

        // 인덱스의 차이때문에 스시 번호를 1 낮추어서 0부터 시작하도록 맞춤
        for(int i = 0; i < N; i++){
            sushi[i] = Integer.parseInt(br.readLine()) - 1;
        }

        // 젤 처음 접시 셋팅
        for(int i = 0; i < numPick; i++){
            picked[sushi[i]]++;
            if(picked[sushi[i]] == 1){
                max++;
            }
        }
        // 쿠폰 처리
        if(picked[coupon] == 0){
            max++;
        }

        // 벨트 전체 탐색
        for(int i = 0; i < N; i++){
            // 슬라이드 윈도우로 탐색횟수 줄임
            picked[sushi[p1++]]--;
            picked[sushi[++p2 % N]]++;

            // 스시 카운팅
            int cnt = 0;
            for(int j = 0; j < numSushi; j++){
                if(picked[j] >= 1){
                    cnt++;
                }
            }
            // 쿠폰 처리
            if(picked[coupon] == 0){
                cnt++;
            }
            // 최댓값 갱신
            if(cnt > max){
                max = cnt;
            }
        }

        System.out.println(max);
    }
}
