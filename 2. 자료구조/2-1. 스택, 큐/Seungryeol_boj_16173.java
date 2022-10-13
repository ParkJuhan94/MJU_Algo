import javax.swing.plaf.IconUIResource;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class boj16173 {
    static int[][] check;
    static int[][] arr;
    static int[] dx = {1,0};
    static int[] dy = {0,1};
    static int N;
    static int nx,ny=0;


    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        N = sc.nextInt(); //N*N 행렬
        arr = new int[N][N];
        check = new int[N][N];

        for (int i=0; i<N; i++){
            for (int j=0; j<N; j++) arr[i][j] = sc.nextInt();
        }

        DFS(0,0);
        System.out.println("Hing");
    }

    public static void DFS(int x, int y) {
        check[x][y]=1;
        if (arr[x][y]==-1){
            System.out.println("HaruHaru");
            System.exit(0);
        } else{
            for (int i=0; i<2; i++){
                int newX = x+(dx[i]*arr[x][y]);
                int newY = y+(dy[i]*arr[x][y]);
                if (newX>=N || newY>=N || newX<0 || newY<0) continue;
                if (check[newX][newY]==0){
                    DFS(newX,newY);
                }

            }
        }

    }
}
