package WEEK04.P7576;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
    static int N, M, res;
    static boolean allAgedTomato;
    static int[][] map, ch;             // 빈칸의 좌표를 ch[][]에 1로 저장
    static int[] dx = {-1, 0, 1, 0};
    static int[] dy = {0, 1, 0, -1};
    static Queue<Point> Q;              // 익은 토마토의(퍼뜨릴) 좌표를 담는 배열

    public static void main(String[] args) throws IOException {
        System.setIn(new FileInputStream("src/WEEK04/P7576/input.txt"));

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        map = new int[N][M];
        ch = new int[N][M];
        allAgedTomato = true;

        for(int i = 0; i < N; i++){
            st = new StringTokenizer(br.readLine());
            for(int j = 0; j < M; j++){
                map[i][j] = Integer.parseInt(st.nextToken());

                // 빈칸일 때
                if(map[i][j] == -1) {
                    ch[i][j] = 1;
                }

                // 안익은 토마토가 하나라도 있으면
                if(map[i][j] == 0){
                    allAgedTomato = false;
                }
            }
        }

        if(allAgedTomato == true){
            System.out.println(0);
        }

        BFS();

        System.out.println(res);
    }

    static void BFS(){
        Q = new LinkedList<>();

        for(int i = 0; i < N; i++){
            for(int j = 0; j < M; j++){
                if(map[i][j] == 1)          // 토마토일 때
                {
                    Q.add(new Point(i, j));
                }
            }
        }

        while(!Q.isEmpty()){
            Point head = Q.poll();

            // 익은 토마토의 상하좌우 탐색
            for(int i = 0; i < 4; i++){
                int tx = head.x + dx[i];
                int ty = head.y + dy[i];

                // 퍼뜨릴 조건
                if(0 <= tx && tx < N && 0 <= ty && ty < M
                        && ch[tx][ty] == 0){
                    Q.add(new Point(tx, ty));
                }
            }


        }
    }
}

class Point {
    int x, y;

    public Point(int x, int y) {
        this.x = x;
        this.y = y;
    }
}
