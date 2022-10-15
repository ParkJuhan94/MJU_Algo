package WEEK01.P1246;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.StringTokenizer;

public class Main {
    static int N,M;
    static int orgSum = 0, sum, numEgg, price, salePrice, max = 0;
    static ArrayList<Integer> pay;

    public static void main(String[] args) throws IOException {
        System.setIn(new FileInputStream("src/WEEK01/P1246/input.txt"));

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        pay = new ArrayList<>();    // 각자의 고객이 달걀 하나에 지불 가능한 최대의 가격


        for(int i = 0; i < M; i++){
            st = new StringTokenizer(br.readLine());
            int input = Integer.parseInt(st.nextToken());
            pay.add(input);
        }

        Collections.sort(pay);

        // 계란 가격을 낮춰가면서 살 손님이 한 명 더 생기는 순간, 이익을 비교
        // -> 여기서 더 손해라고 해서 바로 break 하면 안 돼!!!!!!!
        // 낮은 금액의 구매자가 1000명 일 수도 있잖아.
        for(numEgg = 1; numEgg < M + 1; numEgg++){
            // 고객들의 지불 가격을 기준으로 함 . 그 중간으로 해봤자 이익이 최대가 될 수 없으니까
            price = pay.get(M - numEgg);
            sum = price * numEgg;

            if(sum > max){
                max = sum;
                salePrice = price;
            }

            if(numEgg == N){
                break;
            }
        }

        System.out.println(salePrice + " " + max);
    }
}
