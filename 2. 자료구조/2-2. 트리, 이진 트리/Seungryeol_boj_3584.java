import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class boj3584 {
    static int[] parent;
    static int[] check;
    static int answer;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        int T = Integer.parseInt(br.readLine());

        for (int i=0; i<T; i++){
            int N = Integer.parseInt(br.readLine()); // 노드의 갯수
            parent = new int[N + 1];
            check = new int[N + 1];
            for (int j=1; j<N; j++){
                st = new StringTokenizer(br.readLine());
                int p = Integer.parseInt(st.nextToken()); //부모
                int c = Integer.parseInt(st.nextToken()); //자식
                parent[c] = p;
            }
            st = new StringTokenizer(br.readLine());
            int node1 = Integer.parseInt(st.nextToken());
            int node2 = Integer.parseInt(st.nextToken());
            findAncestor(node1,node2);
            System.out.println(answer);
        }
    }

    public static void findAncestor(int node1,int node2){

        check[node1] = 1;
        while (parent[node1]!=0){
            check[parent[node1]] = 1;
            node1 = parent[node1];
        }

        check[node2] =1;
        while(parent[node2]!=0){
            if (check[parent[node2]]==1){
                answer = parent[node2];
                break;
            } else {
                check[parent[node2]] = 1;
                node2 = parent[node2];
            }
        }
    }


}
