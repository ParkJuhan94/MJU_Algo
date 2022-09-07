import java.lang.reflect.Array;
import java.util.*;

public class boj1246 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int M = sc.nextInt(); //판매할 수 있는 달걀 개수
        int N = sc.nextInt(); //고객 수
        int[] arr = new int[N];
        for(int i=0; i<N; i++) arr[i] = sc.nextInt(); //Pi가격 입력
        Arrays.sort(arr);

        int max=0;
        int A =0;
        int earn =0;
        for (int i=0; i<N; i++){
            int price = arr[i];

            if(N<=M){ // 달걀 수보다 고객수가 적거나 같으면
                 earn = price*(N-i);
                if(max<earn){
                    max = earn;
                    A = price;
                }
            } else{ // 달걀 수보다 고객 수가 많을때
                if(N-i>M){ // 잠재적 고객이 달걀 수보다 많으면 달걀 갯수만큼만 판매
                     earn = price*M;
                    if(max<earn){
                        max = earn;
                        A= price;
                    }
                } else{ //잠재적 고객이 달걀 수보다 적어지면 Pi>=A인 고객들만 구매
                     earn = price * (N - i);
                    if(max<earn){
                        max = earn;
                        A= price;
                    }
                }
            }
        }

        System.out.println(A+" "+max);


    }


}
