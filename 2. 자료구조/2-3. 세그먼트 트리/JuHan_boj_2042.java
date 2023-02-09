package WEEK18.P2042;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

// 인덱스트리(포화이진트리)
public class Main {
    static int N, M, K;
    static long[] nums;
    static long[] tree;
    static int S;

    public static void main(String[] args) throws Exception {
        System.setIn(new FileInputStream("src/WEEK18/P2042/input.txt"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());
        nums = new long[N];
        for (int i = 0; i < N; i++) {
            nums[i] = Long.parseLong(br.readLine());
        }

        //  if (N == 12)
        //  S : 1 -> 2 -> 4 -> 8 -> 16 -> while 탈출
        S = 1;
        while (S < N) {
            S *= 2;
        }
        tree = new long[2 * S];     //  long[32]

        initBU();

        for (int i = 0; i < M + K; i++) {
            st = new StringTokenizer(br.readLine());
            int a, b;
            long c;

            a = Integer.parseInt(st.nextToken());
            b = Integer.parseInt(st.nextToken());
            c = Long.parseLong(st.nextToken());

            // 1부터 S까지!
            // 1부터 N까지 아님
            if (a == 1) {
                //updateBu(b, c);
                update(1,S,1, b, c - tree[S + b - 1] );
            } else if (a == 2) {
                System.out.println(query(1, S, 1, b, c));
            }
        }
    }

    static void initBU() {
        // leaf 노드 채우기
        for (int i = 0; i < N; i++) {
            tree[S + i] = nums[i];
        }
        // 내부 노드 채우기
        for (int i = S - 1; i > 0; i--) {
            tree[i] = tree[i * 2] + tree[i * 2 + 1];
        }
    }

    // 구간 합 구하기
    // (현재 노드의 왼쪽 범위, 현재 노드의 오른쪽 범위, 현재 노드 index, 구간합의 start, 구간합의 end)
    static long query(int left, int right, int node, int queryLeft, long queryRight) {
        // 구간합의 범위에 전혀 연관이 없는 경우
        if (left > queryRight || right < queryLeft) {
            return 0;
        }
        // 구간합의 범위에 현재 노드 범위 전체가 포함되는 경우 (쪼개다가 이까지 도달해야해)
        if (queryLeft <= left && right <= queryRight) {
            return tree[node];
        }
        // 구간합의 범위에 현재 노드 범위 일부가 포함되는 경우
        else {
            int mid = (left + right) / 2;
            long resultLeft = query(left, mid, node * 2, queryLeft, queryRight);
            long resultRight = query(mid + 1, right, node * 2 + 1, queryLeft, queryRight);
            return resultLeft + resultRight;
        }
    }

    // (현재 노드의 왼쪽 범위, 현재 노드의 오른쪽 범위, 현재 노드 index, 변경할 data index, 변경할 값)
    static void update(int left, int right, int node, int target, long diff) {
        // 현재 노드의 범위에 변경할 data index 가 포함되지 않는 경우
        if (left > target || right < target) {
            return;
        }
        // 현재 노드 범위에 변경할 data index(target)이 포함되는 경우
        // 내려가면서 다른 원소도 갱신
        else {
            // target 번째 수를 val로 변경한다면, 그 수가 얼마만큼 변했는지를 알아야 합니다.
            // 이 수를 diff 라고 하면, diff = val - a[target]로 쉽게 구할 수 있습니다.
            tree[node] += diff;
            if (left != right) {    // 리프노드가 아니라면
                int mid = (left + right) / 2;
                update(left, mid, node * 2, target, diff);
                update(mid + 1, right, node * 2 + 1, target, diff);
            }
        }
    }

    // 구간합의 범위를 나타냄
    static long queryBU(int queryLeft, int queryRight) {
        // Leaf 노드에서 left, right 설정
        int left = S + queryLeft - 1;
        int right = S + queryRight - 1;

        long sum = 0;
        while (left < right) {
            // left 가 오른쪽 노드인 경우 -> left 노드의 값을 더한 뒤 left++
            if (left % 2 == 1) {
                sum += tree[left];
                left++;
            }
            // right 가 왼쪽 노드인 경우 -> right 노드의 값을 더한 뒤 right--;
            if (right % 2 == 0) {
                sum += tree[right];
                right--;
            }
            // left /= 2 -> 부모 노드로 이동
            left /= 2;
            // right /= 2 -> 부모 노드로 이동
            right /= 2;
            // left > right 이면 종료
        }
        return sum;
    }

    // 업데이트할 위치, 값
    // target 인덱스는 data 인덱스 기준
    static void updateBu(int target, long value) {
        // 트리에서의 target index 계산
        int s = S + target - 1;
        // target 위치의 값을 value 로 변경
        tree[s] = value;
        // target 의 부모 값을 다시 계산
        while (s > 0) {
            s /= 2;
            tree[s] = tree[s * 2] + tree[s * 2 + 1];
        }
    }

}
