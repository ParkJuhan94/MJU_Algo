package WEEK21.P11437;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.StringTokenizer;

public class Main {
    static int N;
    static int M;
    static int[] parents;
    static int[] depths;
    static ArrayList<Integer>[] tree;

    public static void main(String[] args) throws IOException {
        System.setIn(new FileInputStream("src/WEEK21/P11437/input.txt"));

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        tree = new ArrayList[N+1];
        for (int i = 1; i <= N; i++) {
            tree[i] = new ArrayList<Integer>();
        }
        parents = new int[N+1];
        depths = new int[N+1];
        Arrays.fill(depths,-1);

        for(int i = 0; i < N - 1; i++){
            st = new StringTokenizer(br.readLine());
            int s = Integer.parseInt(st.nextToken());
            int e = Integer.parseInt(st.nextToken());
            tree[s].add(e);
            tree[e].add(s);
        }
        dfs(1,1,0);//레벨 및 부모 노드 저장

        M = Integer.parseInt(br.readLine());
        for(int i = 0; i < M; i++){
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());

            System.out.println(LCA(a, b));
        }
    }

    public static int LCA(int a, int b){
        int aDepth = depths[a];
        int bDepth = depths[b];
        // 깊이 맞추기
        while(aDepth>bDepth){
            a = parents[a];
            aDepth--;
        }
        while(bDepth>aDepth){
            b = parents[b];
            bDepth--;
        }

        // 깊이는 같은데 부모가 다를 경우 -> 같을 때 까지 양 노드를 부모 노드로 바꿔주기
        while(a!=b){
            a = parents[a];
            b = parents[b];
        }
        return a;
    }

    // 깊이 + 부모를 저장
    public static void dfs(int current, int depth, int parent){
        depths[current] = depth;
        parents[current] = parent;
        // 연결된 노드를 탐색
        for(int nextNode : tree[current]){
            if(nextNode != parent){
                dfs(nextNode,depth+1,current);
            }
        }
    }
}
