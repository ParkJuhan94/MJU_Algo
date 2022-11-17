package WEEK10.P4256;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static int N;
    static int T;
    static int[] pre, in;

    public static void main(String[] args) throws IOException {
        System.setIn(new FileInputStream("src/WEEK10/P4256/input.txt"));

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        T = Integer.parseInt(st.nextToken());
        for(int i = 0; i < T; i++){
            N = Integer.parseInt(br.readLine());
            pre = new int[N+1];
            in = new int[N+1];

            st = new StringTokenizer(br.readLine());
            for(int j = 0; j < N; j++){
                pre[j] = Integer.parseInt(st.nextToken());
            }
            st = new StringTokenizer(br.readLine());
            for(int j = 0; j < N; j++){
                in[j] = Integer.parseInt(st.nextToken());
            }

            postorder(0, N, 0);
            System.out.println();
        }
    }

    /*
     전위 순회는 루트부터 시작하고, 중위 순회는 루트를 중심으로 왼쪽 서브트리, 오른쪽 서브트리로 나뉜다.
     1. 전위 순회를 통해 root를 파악
     2. 중위 순회 왼쪽에 있는지 오른쪽에 있는지 범위를 좁히며 위치를 파악
     3. 만약에 양쪽에 없으면 부모 노드로 올라가 탐색

    인덱스 :     0  1 2 3  4  5 6 7
    전위 순회 : [3] 6 5 4  8 / 7 1 2
    중위 순회 :  5  6 8 4 [3] 1 2 7

    전위 순회의 첫번째가 3이므로 루트 노드는 3이고
    5 6 8 4 는 왼쪽 서브트리, 1 2 7 은 오른쪽 서브트리이다.
    양 서브트리의 루트(최상단) 노드는 전위 순회의 첫번째 노드 이므로 각각 6, 7 이다.

    루트 노트를 찾았으면 또 이등분하여 서브트리를 구한다.
     */

    // s: 시작 인덱스 e: 마지막 인덱스 r: 트리(서브트리)의 루트 노드의 인덱스
    public static void postorder(int s, int e, int r) {
        for(int i=s; i<e; i++) {
            if(in[i] == pre[r]) {
                // i = 4, r = 0, s = 0
                postorder(s, i, r+1);              // 1.  왼쪽 서브트리
                // r+i-s+1 => 5
                // 0+4-0+1 = 5
                postorder(i+1, e, r+i-s+1);     // 2. 오른쪽 서브트리
                System.out.print(pre[r] + " ");      // 루트 노드를 출력
            }
        }
    }
}
