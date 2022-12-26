//package WEEK14.P2110;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    static int N, C;
    static int max;
    static int[] homes;

    public static void main(String[] args) throws IOException {
    //    System.setIn(new FileInputStream("src/WEEK14/P2110/input.txt"));

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        C = Integer.parseInt(st.nextToken());
        homes = new int[N];

        for(int i = 0; i < N; i++){
            homes[i] = Integer.parseInt(br.readLine());
        }
        Arrays.sort(homes);

        int s = 1;
        int e = homes[N-1];
        int mid = 0;    // 가장 인접한 두 공유기 사이의 거리
        int res = 1;

        int flag = 0;
        while(s <= e){
            mid = (s + e) / 2;
            //System.out.println("mid : " + mid);

            if(cntWifi(homes, mid) >= C){     // 거리가 커져야 해(정답 후보)
                s = mid + 1;
                res = mid;                
            } else {                          // 거리가 작아져야 해
                e = mid - 1;
            }
        }

        System.out.println(res);
    }

    static int cntWifi(int[] homes, int width){
        int cnt = 1;
        int tmpSum = 0;
        int nowWidth;
        for(int i = 0; i < N - 1; i++){
            nowWidth = homes[i + 1] - homes[i];
            if((tmpSum + nowWidth) < width){
                tmpSum += nowWidth;
            } else {
                tmpSum = 0;
                cnt++;
            }
        }
        //System.out.println("cnt : " + cnt);
        return cnt;
    }
}
