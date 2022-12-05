package PS_01.P14889;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Main {
    static int N;
    static int min = Integer.MAX_VALUE;
    static int[][] arr;
    static boolean visited[];
    static ArrayList<Integer> arr1;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        arr = new int[N+1][N+1];
        visited = new boolean[N+1];
        arr1 = new ArrayList<>();

        for (int i = 1; i <= N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int j = 1; j <= N; j++) {
                arr[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        comb(arr, visited, 1, N, N/2);
        System.out.println(min);
    }

    //백트래킹을 이용해 조합 구현
    //* 항상 DFS를 구현할 때는 IF문과 FOR문을 사용
    public static void comb(int[][] arr, boolean[] visited, int start, int n, int r){
        if(r == 0){ // 해당 수만큼 다 뽑은 경우
            team();
            arr1.clear();
            return;
        } else {
            for (int i = start; i <= n; i++) {
                visited[i] = true;
                arr1.add(i);
                comb(arr, visited, i + 1, n, r - 1);
                visited[i] = false;
            }
        }
    }

    //팀능력치 합 구하기
    public static void team(){
        int start = 0;
        int link = 0;

        for (int i = 1; i <= N; i++) { // N-1
            for (int j = i+1; j <= N; j++) {
                if(visited[i] == true && visited[j] == true) {
                    start += arr[i][j];
                    start += arr[j][i];
                } else if (visited[i] == false && visited[j] == false) {
                    link += arr[i][j];
                    link += arr[j][i];
                }
            }
        }
        int val = Math.abs(start-link); //팀 능력치 차 절대값 반환으로 반환

        if(val == 0) {
            System.out.println(val);
            System.exit(0);
        }
        min = Math.min(min, val);
    }
}
