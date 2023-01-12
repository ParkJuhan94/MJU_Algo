import java.util.LinkedList;
import java.util.Scanner;

public class boj_11725 {

    //그래프로 트리 구현 -> dfs/bfs를 통해 탐색하여 부모노드 지정 -> 출력
    //루트노드는 1로 지정했으므로 1번부터 밑으로 내려간다.
    //리스트를 만들어서 서로 연결된 노드들을 넣어준다.
    //dfs메소드에서 for문을 이용해 차례대로 노드들을 뽑는다.
    //뽑은 노드들을 다시 dfs로 후출한다.

    static int N;
    static LinkedList<Integer>[] list;
    static boolean[] visited;
    static int[] parents;

    public static void main(String[] args){
        Scanner scan = new Scanner(System.in);
        N= scan.nextInt();

        list = new LinkedList[N+1];
        visited = new boolean[N+1];
        parents = new int[N+1];

        for(int i =1; i<=N ; i++){
            list[i]=new LinkedList<>();
        }

        //정점 삽입
        for(int i=0; i<N-1; i++){
            int a = scan.nextInt();
            int b = scan.nextInt();
            list[a].add(b);
            list[b].add(a);

            //양방향 (인접행렬)
            //list[a][b]=list[b][a]=1;
        }
        dfs(1);
        for (int i =2; i<=N; i++){
            System.out.println(parents[i]);
        }
    }

    public static void dfs(int v){              //dfs(int[][]list, boolean visited, int v)
        visited[v] = true;          //현재 vertex 방문 처리

        //list 배열의 모든 요소 가져와서 i에 넣음
        for(int i: list[v]){
            if(!visited[i]){            //방문하지 않은 정점이라면  //if(list[v][i]=1 && !visted[i]) (인접행렬)
                parents[i]=v;
                dfs(i);
            }
        }
    }
}
