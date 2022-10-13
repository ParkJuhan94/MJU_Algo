package P3190;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.StringTokenizer;

public class Main {
    static int N;
    static int K;
    static int r, c;
    static int L;
    static int[][] map;
    static int[] dx = { 1, 0, -1, 0 };
    static int[] dy = { 0, 1, 0, -1 };
    static List<int[]> snake;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        K = Integer.parseInt(br.readLine());

        map = new int[N + 1][N + 1];

        snake = new LinkedList<int[]>();
        snake.add(new int[] { 1, 1 });

        StringTokenizer st;
        for (int i = 0; i < K; i++) {
            st = new StringTokenizer(br.readLine());
            r = Integer.parseInt(st.nextToken());
            c = Integer.parseInt(st.nextToken());
            map[r][c] = 1;
        }

        L = Integer.parseInt(br.readLine());
        Map<Integer, String> dir = new HashMap<>();

        for (int i = 0; i < L; i++) {
            st = new StringTokenizer(br.readLine());
            dir.put(Integer.parseInt(st.nextToken()), st.nextToken());
        }

        int time = dfs(1, 1, 0, dir);
        System.out.println(time);
    }

    private static int dfs(int y, int x, int nowDir, Map<Integer, String> dir) {
        int time = 0; // 현재 진행 시간
        while(true) {
            time++; // while문이 한번 돌때 마다 ++
            int nx = x + dx[nowDir]; // 진행 방향에 맞게
            int ny = y + dy[nowDir]; // 방향 설정 후 이동

            if(nx < 1 || ny < 1 || nx >= N + 1 || ny >= N + 1) {
                break;
            } // 범위를 벗어나면 while문 break;

            for (int i = 0; i < snake.size(); i++) {

                if(nx == snake.get(i)[1] && ny == snake.get(i)[0]) {
                    return time;
                }
            } // 뱀이 벽이나 자신의 몸에 머리가 부딛히면 함수 종료

            if(map[ny][nx] == 1) { // 사과일 경우
                map[ny][nx] = 0; // 사과를 먹는다
                snake.add(new int[] {ny, nx}); // 뱀의 길이가 길어짐
            }else {
                snake.add(new int[] {ny, nx}); // 뱀이 움직임
                snake.remove(0); // 원래 있던 꼬리 부분을 없앰
            }

            x = nx; // 현재 이동 좌표
            y = ny; // 현재 이동 좌표

            if(dir.containsKey(time)) { // dir에 time과 같은 경우가 있으면
                if(dir.get(time).equals("D")) { // D일 경우
                    nowDir++; // 오른쪽으로 턴
                    if(nowDir == 4) { // 다시 0으로
                        nowDir = 0;
                    }
                }
                else if(dir.get(time).equals("L")) { // L일 경우
                    nowDir--; // 왼쪽으로 턴
                    if(nowDir == -1) { // 다시 3으로
                        nowDir = 3;
                    }
                }
            }
        }
        return time;
    }
}
