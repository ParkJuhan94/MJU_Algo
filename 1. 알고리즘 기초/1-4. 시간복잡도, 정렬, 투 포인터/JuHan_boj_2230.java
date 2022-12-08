package WEEK12.P2230;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    static int N, M;
    static int[] arr;
    static int p1, p2;
    static int min;

    public static void main(String[] args) throws IOException {
        System.setIn(new FileInputStream("src/WEEK12/P2230/input.txt"));

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        arr = new int[N];
        min = Integer.MAX_VALUE;
        p1 = 0;
        p2 = 0;
        for(int i = 0; i < N; i++){
            arr[i] = Integer.parseInt(br.readLine());
        }
        Arrays.sort(arr);

        while(p1 < N && p2 < N){
            // arr[p2] 가 arr[p1] 보다 크도록 유지
            int sub = arr[p2] - arr[p1];

            if(sub == M){       // 최솟값 M을 만족할 때는 return
                System.out.println(M);
                return;
            } else if(sub < M){
                p2++;
            } else {
                if(sub < min){
                    min = sub;
                }
                p1++;
            }
        }

        System.out.println(min);
    }
}
