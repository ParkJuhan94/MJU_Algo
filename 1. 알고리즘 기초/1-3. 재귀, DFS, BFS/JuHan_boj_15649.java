package WEEK10.P15649;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

/*
입력  
4 2
출력 
1 2 
1 3 
1 4 
2 1 
2 3 
2 4 
3 1 
3 2 
3 4 
4 1 
4 2 
4 3
*/
public class Main {
    static int N, M;
    static int[] ch, arr;

    public static void main(String[] args) throws IOException {
        System.setIn(new FileInputStream("src/WEEK10/P15649/input.txt"));

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        ch = new int[N + 1];
        arr = new int[N + 1];

        dfs(0);
    }

    static void dfs(int idx){
        if(idx == M){
            for (int i = 0; i < M; i++) {
                System.out.print(arr[i] + " ");
            }
            System.out.println();
            return;
        }

        for(int i = 1; i <= N; i++){
            if(ch[i] == 0){
                ch[i] = 1;
                arr[idx] = i;
                dfs(idx + 1);
                ch[i] = 0;
            }
        }
    }
}
