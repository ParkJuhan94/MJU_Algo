import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());           //달걀의 개수
        int M = Integer.parseInt(st.nextToken());           //잠재 고객의 수

        int arr[] = new int[M];             //고객별 Pi를 입력 받은 배열
        int sum[] = new int[M];

        int maxsum =0;          
        int maxPi =0;

        for(int i=0; i<M; i++){
            arr[i] = Integer.parseInt(br.readLine());
        }

        Arrays.sort(arr);       //잠재 고객의 희망 가격을 오름차순으로 정렬

        for (int i = 0; i < M; i++) {
            if (M > N) {          //사람이 달걀 갯수보다 많을 경우
                if (i < M - N + 1)     //달걀을 모두 판매하는 경우
                    sum[i] = arr[i] * N;
                else
                    sum[i] = arr[i] * (M - i);
            }
            else            //달걀이 사람 수보다 많을 경우
                sum[i] = arr[i] * (M-i);
        }

        maxsum = sum[0];

        for(int i=0; i<M; i++){
            if(sum[i] > maxsum) {
                maxsum = sum[i];
                maxPi = i;
            }
        }

        System.out.println(arr[maxPi]+" "+maxsum);
        br.close();
    }
}
