package WEEK02.P15686;

import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.StringTokenizer;

/*
2차원 배열이 나오면 bfs, dfs 를 의심하게 된다.
하지만 문제를 읽어보면 거리 계산은 단순 수식으로 할 수 있다.
-> 백트래킹 문제

주어진 M이 폐업 후 남은 치킨집의 개수이니
치킨집을 조합(Combi)으로 선택해서 치킨 거리 MIN 을 구해주면 끝이다.
 */
public class Main {
    static int size, chicken;
    static StringBuilder sb = new StringBuilder();
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static int[][] arr;
    static int[] temp;
    static List<Point> clist;
    static List<Point> hlist;
    static int globalMin = Integer.MAX_VALUE;

    public static void main(String[] args) throws IOException {
        System.setIn(new FileInputStream("src/WEEK02/P15686/input.txt"));

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");

        size = Integer.parseInt(st.nextToken());
        chicken = Integer.parseInt(st.nextToken());
        arr = new int[size][size];

        clist = new ArrayList<>();
        hlist = new ArrayList<>();

        for(int i = 0; i < size; i++){
            st = new StringTokenizer(br.readLine(), " ");

            for(int j = 0; j<size; j++){
                int cHorHo = Integer.parseInt(st.nextToken());
                arr[i][j] = cHorHo;

                if(cHorHo == 2){ // 치킨집
                    clist.add(new Point(i+1, j+1));
                }else if( cHorHo ==1)
                    hlist.add(new Point(i+1, j+1));
            }
        }

        temp = new int[chicken];
        search(chicken, 0, 0);

        System.out.println(globalMin);
    }

    // 백트래킹으로 완전탐색하는 함수
    public static void search(int limit, int n , int idx){
        if(limit == n){
            int minSum = 0;
            int[] mins = new int[hlist.size()]; // 모든 집 min 저장
            Arrays.fill(mins, 10000);

            for(int i = 0 ; i < hlist.size(); i++){ // 집
                Point hnode = hlist.get(i);
                for(int j = 0; j<limit; j++){ // 치킨
                    Point cnode = clist.get(temp[j]);

                    int n1 = Math.abs(hnode.x - cnode.x) + Math.abs(hnode.y - cnode.y);

                    mins[i] = Math.min(mins[i], n1);
                }
            }

            for(int e : mins)
                minSum += e;

            globalMin = Math.min(globalMin, minSum);
            return;
        }

        for(int i = idx ; i<clist.size(); i++){
            temp[n] = i;
            search(limit , n + 1, i + 1);
        }
    }
}

// 좌표
class Point {
    int x;
    int y;
    public Point(int x, int y){
        this.x = x;
        this.y = y;
    }
    public String toString(){
        return this.x + " " + this.y;
    }
}
