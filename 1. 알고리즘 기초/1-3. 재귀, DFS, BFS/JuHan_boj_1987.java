package WEEK13.P1987;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static int R, C;
    static int max;
    static int[] ch;        
    static char[][] map;    
    static int[][] chMap;   
    static int[] dx = {1, 0, -1, 0};
    static int[] dy = {0, -1, 0, 1};

    public static void main(String[] args) throws IOException {
        System.setIn(new FileInputStream("src/WEEK13/P1987/input.txt"));

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        R = Integer.parseInt(st.nextToken());
        C = Integer.parseInt(st.nextToken());
        map = new char[R][C];
        chMap = new int[R][C];  //지나온 자리 체크
        ch = new int[26];       //이미 나온 알파벳 체크
        max = 0;

        for(int i = 0; i < R; i++){
            String input = br.readLine();
            for(int j = 0; j < C; j++){
                map[i][j] = input.charAt(j);
            }
        }

        chMap[0][0] = 1;
        ch[map[0][0] - 'A'] = 1;
        dfs(1, 0, 0);

        System.out.println(max);
    }

    static void dfs(int cnt, int x, int y){
        int flag = 0;       // 갈 곳이 있는지 체크 변수
        for(int i = 0; i < 4; i++){
            int xx = x + dx[i];
            int yy = y + dy[i];
            if(0 <= xx && xx < R && 0 <= yy && yy < C
                    && chMap[xx][yy] == 0 && ch[map[xx][yy] - 'A'] == 0){
                flag = 1;       //갈 곳이 있으면
                chMap[xx][yy] = 1;
                ch[map[xx][yy] - 'A'] = 1;
                dfs(cnt + 1, xx, yy);
                chMap[xx][yy] = 0;
                ch[map[xx][yy] - 'A'] = 0;
            }
        }

        if(flag == 0){      //갈 곳이 없으면
            if(max < cnt){
                max = cnt;
            }
        }
    }
}
