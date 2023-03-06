package DFS_BFS활용;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Tomato {
    static int N,M;
    static int[][] box,dis;
    static int[] dx = {-1,0,1,0};
    static int[] dy = {0,-1,0,1};
    static int max=-1;
    static Queue<Point> queue = new LinkedList<>();

    static class Point{
        int x,y;
        public Point(int x, int y) {
            this.x=x;
            this.y=y;
        }
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        boolean flag = true;
        st = new StringTokenizer(br.readLine());
        M = Integer.parseInt(st.nextToken()); // 가로 (열)
        N = Integer.parseInt(st.nextToken()); // 세로 (행)

        box = new int[N + 1][M + 1];
        dis = new int[N + 1][M + 1];
        for (int i=1; i<=N; i++){
            st = new StringTokenizer(br.readLine());
            for (int j=1; j<=M; j++){
                box[i][j] = Integer.parseInt(st.nextToken());
                if(box[i][j]==1){
                    queue.offer(new Point(i,j));
                } else if (box[i][j]==0){
                    flag = false;
                }
            }
        }
        if (flag==true){
            System.out.println(0);
            return;
        }

        BFS();
        for (int i=1; i<=N; i++){
            for (int j=1; j<=M; j++){
                if(box[i][j]==0){
                    System.out.println(-1);
                    return;
                }
            }
        }

        System.out.println(max);


    }

    public static void BFS(){

        while(!queue.isEmpty()){
            Point tmp = queue.poll();

            for (int i=0; i<4; i++){
                int nx= tmp.x+dx[i];
                int ny= tmp.y+dy[i];
                if(nx>0 && nx<=N && ny>0 && ny<=M && box[nx][ny]==0){
                    box[nx][ny]=1;
                    dis[nx][ny]=dis[tmp.x][tmp.y]+1;
                    max = dis[nx][ny];
                    max = Math.max(max,dis[nx][ny]);
                    queue.offer(new Point(nx, ny));
                }
            }

        }
    }

}
