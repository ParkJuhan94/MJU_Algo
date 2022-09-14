
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
    static ArrayList<Integer> arr;

    public static void main(String[] args) throws IOException {
        System.setIn(new FileInputStream("src/WEEK01/P1246/input.txt"));

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        arr = new ArrayList<>();

        for(int i = 0; i < M; i++){
            st = new StringTokenizer(br.readLine());
            int input = Integer.parseInt(st.nextToken());
            arr.add(input);
        }

        Collections.sort(arr);

        //계란 가격을 낮춰가면서 살 손님이 한 명 더 생기는 순간, 이익을 비교
        //계란 가격을 1씩 낮추지 않고, 가격 배열에서 뽑아와서 낮춤 -> 시간복잡도 low
        //다음 loof에서 더 손해가 나왔더라도 break 하면 안 돼!!!!
        //그 다음 루프에서의 구매자가 30000명 일 수도 있잖아.
        for(numEgg = 1; numEgg < M + 1; numEgg++){
            price = arr.get(M - numEgg);
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
