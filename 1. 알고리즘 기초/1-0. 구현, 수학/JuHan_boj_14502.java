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
3개의 벽을 세우는 모든 경우의 수 -> 완전탐색 (브루트포스)
벽을 만든 후 바이러스를 퍼트린다 -> BFS : 인접한 다른 정점으로 갈때 가중치가 1
 */
public class Main {
    static int N, M;
    static int[][] map, copyMap;
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

        search(0);

        System.out.println(max);
    }

    static void search(int cnt){
        // 벽 3개 세우고나서 BFS() 호출
        if(cnt == 3){
            BFS();
            return;
        }else{
            for(int i = 0; i < N; i++){
                for(int j = 0; j < M; j++){
                    // map[i][j] 에 1을 넣고 DFS 돌렸다가 나오면서 0으로 원상복귀
                    // i와 j가 일정하게 증가만 하니까 ch 배열이 필요 없음. 어차피 재방문 안함.
                    if(map[i][j] == 0){
                        map[i][j] = 1;
                        search(cnt + 1);
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

        // 이렇게 깊은 복사를 해버리면 원본 map 이 바뀐다.
        // copyMap = map;
        // 벽의 위치가 바뀌면 바이러스를 초기화 시켜야하니까, BFS() 한 번 마다 새로운 copyMap 을 쓴다.

        copyMap = new int[N][M];
        for(int i = 0; i < N; i++){
            for(int j = 0; j < M; j++){
                copyMap[i][j] = map[i][j];
            }
        }

        // 원본 map 을 건드리지 않고 copyMap 에서만 바이러스 뿌리고, 정답 처리한다.
        while(!Q.isEmpty()){
            Node n = Q.poll();

            for(int i = 0; i < 4; i++){
                int tx = n.x + dx[i];
                int ty = n.y + dy[i];

                if(0 <= tx && tx < N && 0 <= ty && ty < M
                        && copyMap[tx][ty] == 0){
                    copyMap[tx][ty] = 2;
                    Q.add(new Node(tx, ty));
                }
            }
        }

        // 정답 처리
        int cnt = 0;
        for(int i = 0; i < N; i++){
            for(int j = 0; j < M; j++){
                if(copyMap[i][j] == 0){
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
