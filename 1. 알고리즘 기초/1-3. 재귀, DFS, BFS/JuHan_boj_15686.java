package WEEK02.P15686;

import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.StringTokenizer;

/*
주어진 M이 폐업 후 남은 치킨집의 개수이니
치킨집을 조합(Combi)으로 선택해서 치킨 거리 MIN 을 구해주면 끝이다.
 */
public class Main {
    static int size, chicken;
    static StringBuilder sb = new StringBuilder();
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static int[] temp;
    static List<Point> clist;
    static List<Point> hlist;
    static int globalMin = Integer.MAX_VALUE;

    public static void main(String[] args) throws IOException {
        System.setIn(new FileInputStream("src/WEEK02/P15686/input.txt"));

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        size = Integer.parseInt(st.nextToken());
        chicken = Integer.parseInt(st.nextToken());

        clist = new ArrayList<>();
        hlist = new ArrayList<>();

        for(int i = 0; i < size; i++){
            st = new StringTokenizer(br.readLine());

            for(int j = 0; j < size; j++){
                int input = Integer.parseInt(st.nextToken());

                if(input == 2){ // 치킨집
                    clist.add(new Point(i+1, j+1));
                }else if( input == 1) // 집
                    hlist.add(new Point(i+1, j+1));
            }
        }

        temp = new int[chicken];        // 치킨집 조합을 담기 위한 배열
        search(chicken, 0, 0);

        System.out.println(globalMin);
    }

    public static void search(int limit, int n , int idx){
        // 현재 치킨집의 개수가 M이랑 같을 때
        if(limit == n){
            int minSum = 0;
            int[] mins = new int[hlist.size()]; // 모든 집 min 저장

            Arrays.fill(mins, 10000);

            for(int i = 0 ; i < hlist.size(); i++)
            { // 집
                Point hPoint = hlist.get(i);

                for(int j = 0; j < limit; j++)
                { // 치킨
                    Point cPoint = clist.get(temp[j]);

                    int n1 = Math.abs(hPoint.x - cPoint.x) + Math.abs(hPoint.y - cPoint.y);
                    mins[i] = Math.min(mins[i], n1); // 한 집에서 치킨 집 루프 돌 때 -> 그 중 최솟값 갱신
                }
            }

            for(int e : mins)
                minSum += e; // 도시의 치킨거리

            globalMin = Math.min(globalMin, minSum);  // 도시의 치킨거리의 최솟값
            return;
        }

        // 치킨집 조합
        for(int i = idx ; i < clist.size(); i++){
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
