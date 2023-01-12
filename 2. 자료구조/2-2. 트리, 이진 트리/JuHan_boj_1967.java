package WEEK16.P1967;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

/*
트리의 지름은 리프노드와 리프노드 간의 거리
-> 모든 리프 노드에서 DFS탐색을 하여 다른 리프노드까지의 거리를 구하고, 최대 거리를 갱신하면 된다.
 */
public class Main {
    static int N, max;
    static ArrayList<Node>[] adj;
    static boolean[] visited;
    static ArrayList<Integer> leaf;

    public static void main(String[] args) throws IOException {
        System.setIn(new FileInputStream("src/WEEK16/P1967/input.txt"));

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        max = 0;
        adj = new ArrayList[N + 1];
        leaf = new ArrayList<>();

        for(int i = 1; i <= N; i++){
            adj[i] = new ArrayList<>();
        }

        for(int i = 1; i <= N-1; i++){
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());
            adj[a].add(new Node(b, c));
            adj[b].add(new Node(a, c));
        }

        // 리프노드 구하기 : 루트 제외, 연결 간선이 하나 뿐인 노드
        for(int i = 2; i <= N; i++){
            if(adj[i].size() == 1){
                leaf.add(i);
            }
        }

        // 리프노드끼리의 거리 구하기 : 리프노드 각각을 시작점으로 해서 search 반복하기!!
        for(int i = 0; i < leaf.size(); i++){
            visited = new boolean[N + 1];
            visited[leaf.get(i)] = true;
            search(leaf.get(i), leaf.get(i),0);
        }

        System.out.println(max);
    }

    static void search(int start, int cur, int sum){
        //System.out.println("cur : " + cur + ", sum : " + sum);

        //if(leaf.contains(cur) && sum >= 1){     // 시간초과 범인!!!!!!!!!!!!

        if(adj[cur].size() == 1 && cur != start){     // 리프노드라면
            if(sum > max){ max = sum; }
            return;
        }

        for(int i = 0; i < adj[cur].size(); i++){
            Node nextNode = adj[cur].get(i);

            if(!visited[nextNode.idx]) {
                visited[nextNode.idx] = true;
                search(start, nextNode.idx, sum + nextNode.weight);
                //visited[nextNode.idx] = false;    // 재방문하지 않도록 false 하지 않는다.
            }
        }
    }

    static class Node {
        int idx;
        int weight;

        public Node(int idx, int weight) {
            this.idx = idx;
            this.weight = weight;
        }
    }
}









