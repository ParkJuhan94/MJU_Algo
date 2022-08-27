package WEEK00.P7568;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;


public class Main {
    static int N, x, y;
    static Body[] bodys; // 사람들의 몸무게와 키를 저장한 배열
    static int[] ranks; // 순위를 저장하는 배열. 각 원소를 1로 초기화 (1순위에서 시작해서 더해간다.)

    public static void main(String[] args) throws IOException {
        System.setIn(new FileInputStream("src/WEEK00/P7568/input.txt"));

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        bodys = new Body[N];
        ranks = new int[N];
        Arrays.fill(ranks, 1);

        for(int i = 0; i < N; i++){
            st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());

            bodys[i] = new Body(x, y);
        }

        setRank();

        for(int i = 0; i < N; i++){
            System.out.print(ranks[i] + " ");
        }
        System.out.println();
    }

    // Main 의 bodys 들을 참조해서 ranks 를 만드는 함수
    static void setRank(){
        for(int i = 0; i < N; i++){
            for(int j = 0; j < N; j++){
                // 자기 자신이 아닌 다른 사람과만 비교
                // 키(y)와 몸무게(x) 둘 다 커야만 더 높은 순위이다.
                if(j != i){
                    if(bodys[j].x > bodys[i].x && bodys[j].y > bodys[i].y){
                        ranks[i]++; // 조건을 만족할 때 순위를 1 증가시킴
                    }
                }
            }
        }
    }
}

class Body{
    int x,y;

    public Body(int x, int y) {
        this.x = x;
        this.y = y;
    }
}
