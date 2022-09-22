import java.util.LinkedList;

import java.util.Queue;
import java.util.Scanner;

public class boj2606 {
    static int[][] arr; //인접행렬
    static int[] check;
    static Queue<Integer> q = new LinkedList<>();

    public static int BFS(int start) {
        int cnt = 0; //웜 감영 컴 갯수
        q.offer(start);
        check[start] = 1;
        while (!q.isEmpty()) {
            int x = q.poll();
            for (int i = 1; i < arr.length; i++) { //1번부터 시작해서 연결된 컴퓨터를 큐에 넣고 차례대로 탐색
                if (check[i] == 0 && arr[x][i] == 1) {
                    q.offer(i);
                    check[i] = 1;
                    cnt++;
                }
            }
        }
        return cnt;
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt(); //컴퓨터 갯수 1~n
        int edge = sc.nextInt();
        arr= new int[n+1][n+1];
        check = new int[n + 1];
        for (int i=0; i<edge; i++){
            int F = sc.nextInt();
            int L = sc.nextInt();
            arr[F][L]=1;
            arr[L][F]=1;
        }

        System.out.println(BFS(1));
    }
}
