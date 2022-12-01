//package Practice.P1260;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static int N, M, V;
    static int[] ch;
    static Queue<Integer> Q = new LinkedList<>();
    static ArrayList<Integer> adj[];

    public static void main(String[] args) throws IOException {
      //  System.setIn(new FileInputStream("src/Practice/P1260/input.txt"));

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        V = Integer.parseInt(st.nextToken());
        ch = new int[N + 1];
        adj = new ArrayList[N + 1];
        for(int i = 0 ; i <= N; i++){
            adj[i] = new ArrayList<>();
        }

        for(int i = 0 ; i < M; i++){
            st = new StringTokenizer(br.readLine());
            int from =  Integer.parseInt(st.nextToken());
            int to =  Integer.parseInt(st.nextToken());

            if(adj[from].size() == 0 && adj[to].size() == 0){
                adj[from].add(to);
                adj[to].add(from);
            }

            int j;
            for(j = 0; j < adj[from].size(); j++){
                if(to < adj[from].get(j)){
                    break;
                }
            }
            adj[from].add(j, to);

            for(j = 0; j < adj[to].size(); j++){
                if(from < adj[to].get(j)){
                    break;
                }
            }
            adj[to].add(j, from);
        }

        ch[V] = 1;
        System.out.print(V + " ");
        dfs(V, 1);
        System.out.println();

        // BFS
        int x;
        ch = new int[N + 1];
        ch[V] = 1;
        Q.add(V);
        System.out.print(V + " ");

        while(!Q.isEmpty()){
            x = Q.poll();
            for(int i = 0; i < adj[x].size(); i++){
                if(ch[adj[x].get(i)] == 0){
                    ch[adj[x].get(i)] = 1;
                    System.out.print(adj[x].get(i) + " ");

                    Q.add(adj[x].get(i));
                }

            }
        }

    }

    static void dfs(int v, int n){
        if(n == N){
            return;
        }else{
            for(int i = 0 ; i < adj[v].size(); i++){
                if(ch[adj[v].get(i)] == 0){
                    System.out.print(adj[v].get(i) + " ");

                    ch[adj[v].get(i)] = 1;
                    dfs(adj[v].get(i), n + 1);
                }
            }
        }
    }
}
