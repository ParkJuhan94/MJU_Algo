package graph;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class boj11437 {
    static ArrayList<ArrayList<Integer>> tree;
    static int[] check;
    static int[] parent;
    static int[] child;
    static int[] depth;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        int N = Integer.parseInt(br.readLine());
        tree = new ArrayList<>();
        check = new int[N + 1];
        parent = new int[N + 1];
        depth = new int[N + 1];

        for (int i=0; i<=N; i++){
            tree.add(new ArrayList<Integer>());
        }

        for (int i=0; i<N-1; i++){
            st = new StringTokenizer(br.readLine());
            int s = Integer.parseInt(st.nextToken());
            int e = Integer.parseInt(st.nextToken());
            tree.get(s).add(e);
            tree.get(e).add(s);
        }
        DFS(1,0);
        int M = Integer.parseInt(br.readLine());
        for (int i=0; i<M; i++){
            st = new StringTokenizer(br.readLine());
            int v1 = Integer.parseInt(st.nextToken());
            int v2 = Integer.parseInt(st.nextToken());
            System.out.println(findAncestor(v1,v2));
        }
    }

    public static void DFS(int n, int L){
        check[n]=1;
        depth[n]=L;
        for (int child: tree.get(n)){
            if(check[child]==0) {
                DFS(child,L+1);
                parent[child]=n;
            }
        }
    }

    public static int findAncestor(int v1, int v2){

        while(depth[v1]>depth[v2]) { // a가 더 밑에 있다면
            v1=parent[v1];
        }
        while(depth[v1]<depth[v2]) { //b가 더 밑에 있다면
            v2=parent[v2];
        }

        while(v1!=v2){
            v1 = parent[v1];
            v2 = parent[v2];
        }
        return v1;
    }
}
