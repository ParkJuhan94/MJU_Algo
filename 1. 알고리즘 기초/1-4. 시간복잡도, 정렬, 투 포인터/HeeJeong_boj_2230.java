import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.OutputStreamWriter;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class boj_2230 {
    public static void main(String[] args) throws Exception {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        int[] A = new int[N];

        //입력값 받기
        for(int i=0; i<N; i++) {
            A[i] = Integer.parseInt(br.readLine());
        }

        //오름차순으로 정리
        Arrays.sort(A);

        int start = 0; int end = 0;
        int ans = Integer.MAX_VALUE;

        //투포인터 알고리즘
        while(end<N){
            if(A[end]-A[start]<M){
                end++;
                continue;
            }else if(A[end]-A[start]==M){
                ans = M;
                break;
            }else {
                ans = Math.min(ans,A[end]-A[start]);
                start++;
            }
        }

        bw.write(ans + "\n");
        bw.flush();
        bw.close();
        br.close();
    }
}
