package WEEK15.P3078;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
    static int N, K;
    static Queue<Integer> Q[];
    static long ans;

    public static void main(String[] args) throws IOException {
        System.setIn(new FileInputStream("src/WEEK15/P3078/input.txt"));

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());
        Q = new LinkedList[21];     // 이름의 길이별로 나눔, 각 큐에는 같은 이름인 사람들의 등수를 저장
        for(int i = 2; i <= 20; i++) { Q[i] = new LinkedList<>(); }

        ans = 0;
        for(int i = 1; i <= N; i++){         // i는 등수
            String input = br.readLine();
            int len = input.length();

            if(Q[len].isEmpty()){     // 큐가 비었다면 걍 넣음
                Q[len].add(i);
            } else {                // 아니라면 가장 앞의 등수를 확인
                while(!Q[len].isEmpty()){
                    if(i - Q[len].peek() <= K){     // 현재 학생의 등수의 차가 K 이하라면
                        ans += Q[len].size();
                        Q[len].add(i);
                        break;
                    }
                    // 만약 큐의 가장 앞에 있는 등수와의 차가 K보다 크다면 K 이하가 나올때까지 빼낸다.
                    Q[len].poll();
                }
                // 예외 : 큐가 비었다면 큐에 있었던 모든 경우의 수의 차가 K보다 큰 것이다.
                // -> 그냥 현재 학생의 등수만 넣어준다.
                if(Q[len].isEmpty())
                    Q[len].add(i);
            }
        }
        System.out.println(ans);
    }
}
