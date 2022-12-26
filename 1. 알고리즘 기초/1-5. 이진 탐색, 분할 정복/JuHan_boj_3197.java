package WEEK14.P3197;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static int R, C;
    static char[][] map;
    static int[][] ch;
    static int[][] ch2;
    static int res;
    static char input;
    static String inputStr;
    static int[] dx = {-1, 0, 1, 0};
    static int[] dy = {0, 1, 0, -1};
    static ArrayList<Point> L;

    public static void main(String[] args) throws IOException {
        System.setIn(new FileInputStream("src/WEEK14/P3197/input.txt"));

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        R = Integer.parseInt(st.nextToken());
        C = Integer.parseInt(st.nextToken());
        L = new ArrayList<>();
        map = new char[R][C];
        ch = new int[R][C];
        ch2 = new int[R][C];

        for(int i = 0; i < R; i++){
            inputStr = br.readLine();
            for(int j = 0; j < C; j++){
                input = inputStr.charAt(j);
                map[i][j] = input;

                if(input == 'L') { L.add(new Point(i, j)); }
            }
        }

        printMap(map);
        oneDay(map);
        printMap(map);
        oneDay(map);
        printMap(map);
        oneDay(map);
        printMap(map);

        res = 1;

        while(true){
            if(isPossible(map, L.get(0), L.get(1))) break;
            oneDay(map);

            res++;
        }
        System.out.println(res);
    }

    // 하루 지나서 물이 얼음을 녹이는 시뮬레이션
    static void oneDay(char[][] map){
        ch = new int[R][C];

        for(int i = 0; i < R; i++){
            for(int j = 0; j < C; j++){
                if(map[i][j] == '.' && ch[i][j] == 0){
                    ch[i][j] = 1;   // 새로 생긴 물인지 판별

                    for(int k = 0; k < 4; k++){
                        int xx = i + dx[k];
                        int yy = j + dy[k];

                        if(0 <= xx && xx < R && 0 <= yy && yy < C &&
                        map[xx][yy] == 'X' && ch[xx][yy] == 0){
                            map[xx][yy] = '.';
                            ch[xx][yy] = 1;     // 새로 생긴 물을 체킹
                        }
                    }
                }
            }
        }
    }

    // 백조 둘이 만날 수 있는지 반환(bfs)
    static boolean isPossible(char[][] map, Point L1, Point L2){
        Queue<Point> Q = new LinkedList<>();
        Q.add(L1);
        ch2[L1.x][L1.y] = 1;

        while(!Q.isEmpty()){
            Point front = Q.remove();
            if(front.x == L2.x && front.y == L2.y){
                return true;
            }

            for(int i = 0; i < 4; i++){
                int xx = front.x + dx[i];
                int yy = front.y + dy[i];

                if(0 <= xx && xx < R && 0 <= yy && yy < C
                        && ch2[xx][yy] == 0){
                    ch2[xx][yy] = 1;
                    //System.out.println("add : " + xx + ", " + yy);
                    Q.add(new Point(xx, yy));
                }
            }
        }

        ch2 = new int[R][C];
        return false;
    }

    static void printMap(char[][] map){
        for(int i = 0; i < R; i++){
            for(int j = 0; j < C; j++){
                System.out.print(map[i][j]);
            }
            System.out.println();
        }
        System.out.println();
    }
}

class Point{
    int x;
    int y;

    public Point(int x, int y) {
        this.x = x;
        this.y = y;
    }
}
