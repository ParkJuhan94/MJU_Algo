package WEEK08.P2531;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static int N;
    static int numSushi;
    static int numPick;
    static int coupon;
    static int min, max;     // 뽑는 조합 중에서, 쿠폰 스시가 포함된 개수의 최솟값
    static int[] sushi;
    static Queue<Integer> picked;

    public static void main(String[] args) throws IOException {
        System.setIn(new FileInputStream("src/WEEK08/P2531/input.txt"));

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        numSushi = Integer.parseInt(st.nextToken());
        numPick = Integer.parseInt(st.nextToken());
        coupon = Integer.parseInt(st.nextToken());
        min = 0;
        max = 0;
        sushi = new int[N];                 // 회전벨트 전체
        picked = new LinkedList<>();        // 접시

        for(int i = 0; i < N; i++){
            sushi[i] = Integer.parseInt(br.readLine());
            if(i < numPick){
                picked.add(sushi[i]);

                // 쿠폰스시의 초기값
                if(sushi[i] == coupon){
                    min++;
                    max++;
                }
            }
        }

        // 확인용
        for(int i = numPick; i < N; i++){
            Iterator iter = picked.iterator();
            while(iter.hasNext()){
                System.out.print(iter.next() + " -> ");
            }
            System.out.println("END");

            picked.poll();
            picked.add(sushi[i]);
        }
        Iterator iter = picked.iterator();
        while(iter.hasNext()){
            System.out.print(iter.next() + " -> ");
        }
            System.out.println("END");

        int tempMin = min;
        int tempMax = max;
        for(int i = numPick; i < N; i++){
            if(picked.poll() == coupon){        // 빼기
                tempMin--;
                tempMax--;
            }
            if(sushi[i] == coupon){             // 더하기
                tempMin++;
                tempMax++;
            }
            picked.add(sushi[i]);

            if(tempMin < min){
                min = tempMin;
            }
            if(tempMax < max){
                max = tempMax;
            }
        }

        if(tempMin == 0){
            System.out.println(numPick + 1);
        } else {
            System.out.println(numPick - tempMax);
        }
    }

}
