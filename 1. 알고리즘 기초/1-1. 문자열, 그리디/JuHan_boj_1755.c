package WEEK01.P1755;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Collections;
import java.util.LinkedList;
import java.util.StringTokenizer;

public class Main {
    static int N, M;
    static int[] PriorityTen = { 10, 5, 9, 8, 3, 2, 7, 6, 1, 4};    // zero 부터 nine 까지의 사전순 순위
    static LinkedList<String> arr;

    public static void main(String[] args) throws IOException {
        System.setIn(new FileInputStream("src/WEEK01/P1755/input.txt"));

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        M = Integer.parseInt(st.nextToken());
        N = Integer.parseInt(st.nextToken());
        arr = new LinkedList<>();

        // M과 N은 1이상 99이하 -> 한자리 수 아니면 두자리 수
        for(int i = M; i <= N; i++){
            // 한자리일 때
            if(i < 10){
                
            }
            // 두자리일 때
            else{

            }
        }
        
        Collections.sort(arr);




    }

}
