package WEEK10.P10816;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.HashMap;
import java.util.StringTokenizer;

public class Main {
    static HashMap<Integer, Integer> cnt = new HashMap<>();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken()); //가지고 있는 숫자 카드의 개수
        int[] card = new int[N];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            card[i] = Integer.parseInt(st.nextToken()); // 가지고 있는 카드의 배열
        }
        Arrays.sort(card);

        st = new StringTokenizer(br.readLine());
        int M = Integer.parseInt(st.nextToken()); //판별해야할 숫자의 개수
        int[] check = new int[M];
        int[] tmpCheck = new int[M];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < M; i++) {
            check[i] = Integer.parseInt(st.nextToken()); // 확인해야할 정수의 배열
            tmpCheck[i] = check[i];
            cnt.put(check[i], 0);
        }
        Arrays.sort(check);

        // 투포인터
        int p1 = 0, p2 = 0;

        while(p1 < N && p2 < M){
            if(check[p2] == card[p1]){
                p1++;
                int tmp = cnt.get(check[p2]);
                cnt.put(check[p2], ++tmp);

                while(true){
                    if(check[p2] == card[p1]){
                        p1++;
                        int tmp2 = cnt.get(check[p2]);
                        cnt.put(check[p2], ++tmp2);
                        if (p1 == N) break;
                    } else{
                        break;
                    }
                }
            }
            else if (check[p2] < card[p1]){
                p2++;
            }
            else if (check[p2] > card[p1]){
                p1++;
            }
        }

        //System.out.println(cnt);
        for(int i = 0; i < M; i++){
            System.out.print(cnt.get(tmpCheck[i]) + " ");
        }
        System.out.println();
    }
}
