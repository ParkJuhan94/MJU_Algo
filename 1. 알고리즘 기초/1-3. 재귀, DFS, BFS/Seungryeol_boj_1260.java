import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class boj1260 {
    static int N, Edge, start;
    static int[] dCheck;
    static int[] qCheck;
    static int[][] graph;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        Edge = Integer.parseInt(st.nextToken());
        start = Integer.parseInt(st.nextToken());

        dCheck = new int[N + 1];
        qCheck = new int[N + 1];
        graph = new int[N + 1][N + 1];

        for (int i = 0; i < Edge; i++) {
            StringTokenizer str = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(str.nextToken());
            int b = Integer.parseInt(str.nextToken());
            graph[a][b] = 1;
            graph[b][a] = 1;
        }
        dCheck[start] = 1;
        DFS(start);
        System.out.println();
        BFS(start);
    }

    public static void DFS(int v) {

        System.out.print(v+" ");

        for (int j = 1; j <= N; j++) {
            if (dCheck[j] == 0 && graph[v][j] == 1) {
                dCheck[j] = 1;
                DFS(j);
            }
        }

    }

    public static void BFS(int v) {
        Queue<Integer> queue = new LinkedList<>();
        queue.offer(v);

        while(!queue.isEmpty()){
            int a =queue.poll();
            qCheck[a]=1;
            System.out.print(a+" ");

            for (int i=1; i<=N; i++){
                if(graph[a][i]==1 && qCheck[i]==0){
                    queue.offer(i);
                    if(!queue.contains(i)) queue.offer(i);
                }
            }
        }
    }
}
