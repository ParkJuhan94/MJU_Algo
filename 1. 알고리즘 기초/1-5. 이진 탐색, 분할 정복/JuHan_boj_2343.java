package PS_01.P2343;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static int N, M;
    static int[] arr;
    static int lt, rt, mid;

    public static void main(String[] args) throws IOException {
        System.setIn(new FileInputStream("src/PS_01/P2343/input.txt"));

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        arr = new int[N];
        lt = 0;
        rt = 0;
        st = new StringTokenizer(br.readLine());
        for(int i = 0; i < N; i++){
            arr[i] = Integer.parseInt(st.nextToken());
            rt += arr[i];
            lt = Math.max(lt, arr[i]);
        }

        while(lt <= rt){
            mid = (lt + rt) / 2;

            if(getCountBox(arr, mid) > M){
                lt = mid + 1;
            } else {
                rt = mid - 1;
            }
        }

        System.out.println(lt);
    }

    static int getCountBox(int[] arr, int boxSize){
        int sum = 0;
        int res = 0;

        for(int i = 0; i < N; i++){
            if(sum + arr[i] > boxSize){
               sum = 0;
               res++;
            }
            sum += arr[i];
        }

        if(sum != 0){
            res++;
        }

        return res;
    }
}
