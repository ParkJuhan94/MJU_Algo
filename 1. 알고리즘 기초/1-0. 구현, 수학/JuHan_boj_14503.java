package WEEK0.P14503;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static int N;
    static int M;
    static int[][] map; //0이면 청소 전, 1이면 벽, 2이면 청소 후
    //방향은 후진 기준으로 0부터 3까지 차례대로 배치
    static int[] dx = {-1, 0, 1, 0};
    static int[] dy = {0, 1, 0, -1};
    static int startX, startY, direction;
    static int ans = 0;

    public static void main(String[] args) throws IOException {
        System.setIn(new FileInputStream("src/WEEK0/P14503/input.txt"));

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        map = new int[N][M];
        st = new StringTokenizer(br.readLine());
        startX = Integer.parseInt(st.nextToken());
        startY = Integer.parseInt(st.nextToken());
        direction = Integer.parseInt(st.nextToken());

        for(int i = 0; i < N; i++){
            st = new StringTokenizer(br.readLine());
            for(int j = 0; j < M; j++){
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        if(map[startX][startY] == 0){
            map[startX][startY] = 2;
            ans++;
        }

        search(startX, startY, direction);

        System.out.println(ans);
    }

    static void search(int x, int y, int direction){
        if(map[x][y] == 0){
            map[x][y] = 2;
            ans++;
        }

        //현재 칸의 주변 4칸 확인
        int flag = 0;
        for(int i = 0; i < 4; i++){
            int xx = x + dx[i];
            int yy = y + dy[i];
            if(0 <= xx && xx < N && 0 <= yy && yy < M
                    && map[xx][yy] == 0){
                flag = 1;
            }
        }

        if(flag == 1){  //현재 칸의 주변 4칸 중 청소되지 않은 빈 칸이 있는 경우
            //System.out.println(x + "," + y + " 에서 주변에 빈 칸 있다");
            direction = (direction + 3) % 4;  //중요. 반시계 90도 회전
            int xx = x + dx[direction];
            int yy = y + dy[direction];

            // 청소하지 않은 칸 만날떄까지 회전시켜주기
            while(map[xx][yy] != 0){
                direction = (direction + 3) % 4;
                xx = x + dx[direction];
                yy = y + dy[direction];
            }

            if(0 <= xx && xx < N && 0 <= yy && yy < M
                    && map[xx][yy] == 0){
                map[xx][yy] = 2;
                ans++;
                //printmap();

                search(xx, yy, direction);
            }
        } else {    //현재 칸의 주변 4칸 중 청소되지 않은 빈 칸이 없는 경우
            //System.out.println(x + "," + y + " 에서 주변에 빈 칸 없다");
            int xx = x - dx[direction];
            int yy = y - dy[direction];
            if(0 <= xx && xx < N && 0 <= yy && yy < M
                    && map[xx][yy] != 1){
                //바라보는 방향을 유지한 채로 한 칸 후진할 수 있다면 한 칸 후진하고 1번으로 돌아간다.
                search(xx, yy, direction);
            }else{
                //바라보는 방향의 뒤쪽 칸이 벽이라 후진할 수 없다면 작동을 멈춘다.
                //printmap();
            }
        }
    }

    static void printmap(){
        for(int i = 0; i < N; i++){
            for(int j = 0; j < M; j++){
                System.out.print(map[i][j] + " ");
            }
            System.out.println();
        }
        System.out.println();
    }
}
