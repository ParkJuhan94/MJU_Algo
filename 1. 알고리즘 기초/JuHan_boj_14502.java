package WEEK00.P14502;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

/*
N 제한이 8 : 매우 작은 수
3개의 벽을 세우는 모든 경우의 수 -> DFS
벽을 만든 후 바이러스를 퍼트린다 -> BFS : 인접한 다른 정점으로 갈때 가중치가 1
 */
public class Main {
    static int N, M;
    static int[][] map;
    static int[][] ch;
    static int[] dx = {-1, 0, 1, 0};
    static int[] dy = {0, 1, 0, -1};
    static int max = 0;

    public static void main(String[] args) throws IOException {
        System.setIn(new FileInputStream("src/WEEK00/P14502/input.txt"));

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        map = new int[N][M];
        ch = new int[N][M];

        for(int i = 0; i < N; i++){
            st = new StringTokenizer(br.readLine());
            for(int j = 0; j < M; j++){
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        DFS(0);

        System.out.println(max);
    }

    static void DFS(int cnt){
        // 벽 3개 세우고나서 BFS() 호출
        if(cnt == 3){
            BFS();
            return;
        }else{
            for(int i = 0; i < N; i++){
                for(int j = 0; j < M; j++){
                    if(map[i][j] == 0){
                        map[i][j] = 1;
                        DFS(cnt + 1);
                        map[i][j] = 0;
                    }
                }
            }
        }
    }

    static void BFS(){
        Queue<Node> Q = new LinkedList<>();

        // 바이러스의 위치를 Q에 삽입
        for(int i = 0; i < N; i++){
            for(int j = 0; j < M; j++){
                if(map[i][j] == 2){
                    Q.add(new Node(i, j));
                }
            }
        }

        while(!Q.isEmpty()){
            Node n = Q.poll();

            for(int i = 0; i < 4; i++){
                int tx = n.x + dx[i];
                int ty = n.y + dy[i];

                if(0 <= tx && tx < N && 0 <= ty && ty < M
                        && map[tx][ty] != 2){
                    map[tx][ty] = 2;
                    Q.add(new Node(tx, ty));
                }
            }
        }

        int cnt = 0;
        for(int i = 0; i < N; i++){
            for(int j = 0; j < M; j++){
                if(map[i][j] == 0){
                    cnt++;
                }
            }
        }
        if(cnt > max){
            max = cnt;
        }
    }

    // Q에 좌표값 x,y를 넣기 위함.
    static class Node {
        int x;
        int y;

        Node(int x, int y){
            this.x = x;
            this.y = y;
        }
    }
}
