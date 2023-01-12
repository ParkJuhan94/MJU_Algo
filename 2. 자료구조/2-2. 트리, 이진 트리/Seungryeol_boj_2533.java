import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;


public class boj2533 {
    static int N;
    static ArrayList<ArrayList<Integer>> list= new ArrayList<>();
    static int[][] dp;
    static boolean[] visited;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine()); // 정점 수
        dp = new int[N+1][2];
        visited = new boolean[N + 1];
        for (int i=1; i<=N; i++){
            list.add(new ArrayList<Integer>());
        }

        for (int i=1; i<=N; i++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            list.get(a).add(b);
            list.get(b).add(a);
        }
        DFS(1);
        System.out.println(Math.min(dp[1][0], dp[1][1]));

    }

    public static void DFS(int num){
        visited[num] = true;
        dp[num][0] =0; //해당 정점이 얼리어답터가 아닌 경우
        dp[num][1] =1; //해당 정점이 얼리어답터인 경우

        for (int child: list.get(num)){
            DFS(child); // dfs 재귀호출을 통해 자식 노드의 dp값을 미리 구한다.
            dp[num][0]+=dp[child][1]; // 자식 노드가 무조건 얼리어답터여야한다.
            dp[num][1] +=Math.min(dp[child][0],dp[child][1]);	// 왜냐하면 최소의 얼리어답터 인원을 뽑기 때문에 자식 노드가 얼리어답터 일수도, 아닐수도 있다.

        }
    }
}
