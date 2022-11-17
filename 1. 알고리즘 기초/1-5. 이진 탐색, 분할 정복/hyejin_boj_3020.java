import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

//이진탐색 -  https://www.acmicpc.net/problem/3020
//나중에 누적합으로 풀어보기 !
public class G5_boj3020 {
    static int N, H; //길이, 높이
    static int[] bottom; //석순
    static int[] top; //종유석

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        H = Integer.parseInt(st.nextToken());

        bottom = new int[N/2];
        top = new int[N/2];

        for (int i = 0; i <N/2 ; i++) { //석순, 종유석 크기 반복해서 저장
            bottom[i] = Integer.parseInt(br.readLine());
            top[i] = Integer.parseInt(br.readLine());
        }
        Arrays.sort(bottom); // 예1{1,3,5}
        Arrays.sort(top); // 예1{1,3,5}

        int cnt = 0;
        int min = N; // ** 나올수 있는 최댓값을 최솟값으로 초기화 시킴

        // 어떤 구간에서 충돌 횟수가 최소값인지 확인해보기
        for (int i = 1; i <= H; i++) { // 구간(i) : 1 ~ H
            //구간 i에서 충돌 횟수
            int conflict = binarySearch(0,N/2, i, bottom)
                    + binarySearch(0, N/2, H-i+1, top);

            if(conflict<min){
                min = conflict; //최솟값 갱신
                cnt = 0; //최소값이 달라짐에 따라 cnt도 갱신
            }
            if(conflict == min){
                cnt++;
            }
        }

        System.out.println(min+" "+cnt);
    }

    //구간 h 일때 정렬된 배열에서 충돌 횟수 구하는 함수
    public static int binarySearch(int left, int right, int h, int[] arr){
        while(left<right) {
            int mid = (left + right) / 2;
            if(arr[mid] >= h ){ // 크기 >= h 구간 이면, 충돌
                right = mid; // 더 낮은 인덱스를 탐색
            }
            else{
                left = mid+1; // mid보다 높은 인덱스를 탐색
            }
        }
        return arr.length-right; // h구간에서 충돌횟수
    }

}
