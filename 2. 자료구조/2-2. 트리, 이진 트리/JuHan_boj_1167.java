package WEEK17.P1167;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Main {
    static int N, res, max, farNode;
    static ArrayList<Integer> sideNodes;
    static ArrayList<Node>[] adj;
    static boolean[] visited;

    public static void main(String[] args) throws IOException {
        System.setIn(new FileInputStream("src/WEEK17/P1167/input.txt"));

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        res = 0;
        max = 0;
        adj = new ArrayList[N + 1];
        sideNodes = new ArrayList<>();

        for(int i = 1; i <= N; i++){
            adj[i] = new ArrayList<>();
        }

        for(int i = 1; i <= N; i++){
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());

            while(true){
                int b = Integer.parseInt(st.nextToken());
                if(b == -1){
                    break;
                }
                int c = Integer.parseInt(st.nextToken());

                adj[a].add(new Node(b, c));
                //adj[b].add(new Node(a, c));   //이 문제에서는 넣으면 중복됨
            }
        }

        // 단 두 번의 탐색으로 지름 찾기 가능
        // 1. 임의의 한 점으로부터 가장 먼 거리의 점 찾기
        visited = new boolean[N + 1];
        search(1, 1, 0);
        sideNodes.add(farNode);

        max = 0;
        // 2. 그 점으로부터 또, 가장 먼 거리의 점 찾기
        visited = new boolean[N + 1];
        search(farNode, farNode, 0);
        sideNodes.add(farNode);

        // 3. 두 점을 이으면 트리의 지름
        visited = new boolean[N + 1];
        res = search2(sideNodes.get(0), sideNodes.get(0), sideNodes.get(1), 0);

        System.out.println(res);
    }

    static void search(int start, int cur, int sum){
        //System.out.println("cur : " + cur + ", sum : " + sum);

        if(adj[cur].size() == 1 && cur != start){     // 리프노드라면
            if(sum > max){
                max = sum;
                farNode = cur;
            }
            return;
        }

        for(int i = 0; i < adj[cur].size(); i++){
            Node nextNode = adj[cur].get(i);

            if(!visited[nextNode.idx]) {
                visited[nextNode.idx] = true;
                search(start, nextNode.idx, sum + nextNode.weight);
            }
        }
    }

    static int search2(int start, int cur, int target, int sum){
        if(adj[cur].size() == 1 && cur != start && cur == target){
            return sum;
        }

        for(int i = 0; i < adj[cur].size(); i++){
            Node nextNode = adj[cur].get(i);

            if(!visited[nextNode.idx]) {
                visited[nextNode.idx] = true;
                search(start, nextNode.idx, sum + nextNode.weight);
            }
        }

        return 0;
    }

    static class Node {
        int idx;
        int weight;

        public Node(int idx, int weight) {
            this.idx = idx;
            this.weight = weight;
        }

        @Override
        public String toString() {
            return "{idx=" + idx +
                    ", weight=" + weight +
                    '}';
        }
    }
}









