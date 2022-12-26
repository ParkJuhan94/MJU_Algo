package WEEK1_5;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

//이진탐색 -> https://www.acmicpc.net/problem/2110
public class G4_boj2110 {
    static int N, C, res;
    static int[] house;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken()); // 집의 개수
        C = Integer.parseInt(st.nextToken()); // 공유기의 개수

        house = new int[N];
        for (int i = 0; i < N; i++) {
            house[i] = Integer.parseInt(br.readLine());
        }
        Arrays.sort(house); // 1 2 4 8 9

        System.out.println(BinarySearch());
    }

    public static int BinarySearch(){
        int max = house[N-1] - house[0]; // 최대거리
        //int min = house[1] - house[0]; // 최소거리(x)
        int min = 1; // 최소거리-> ** 중요!
        res = 0;

        while(min <= max) {
            int mid = (max + min) / 2; // 집마다 거리 --> mid 이상
            int cnt = 1; // house[0] 은 이미 설치했음.

            int start = house[0];
            for (int i=1; i <= N-1; i++) {
                if (house[i] >= start + mid) { // house[1] >= house[0] + mid
                    cnt++;
                    start = house[i];
                }
            }

            if (cnt >= C) { //최대거리 증가
                res = mid;
                min = mid + 1;
            } else
                max = mid - 1;
        }
        return res;
    }


}
