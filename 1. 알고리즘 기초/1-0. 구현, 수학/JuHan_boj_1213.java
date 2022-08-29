package WEEK00.P1213;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static String str;
    static int alpha[] = new int[26];  // 0으로 초기화 되어있음

    public static void main(String[] args) throws IOException {
        System.setIn(new FileInputStream("src/WEEK00/P1213/input.txt"));

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        str = st.nextToken();

        if(isPossible(str)){
            printPalindrome(str);
        }else{
            System.out.println("I'm Sorry Hansoo");
        }
    }

    // 팰린드롬을 만드는게 가능한 문자열인지 반환하는 함수
    static boolean isPossible(String str){
        int len = str.length();

        // str 의 길이가 짝수일 때와 홀수일 때를 나눈다
        if(len % 2 == 0){
            for(int i = 0; i < len; i++){
                alpha[str.charAt(i) - 'A']++;
            }
            for(int i = 0; i < 26; i++){
                if(alpha[i] % 2 == 1){
                    return false;
                }
            }
            return true;
        }else{
            int cnt = 0;

            for(int i = 0; i < len; i++){
                alpha[str.charAt(i) - 'A']++;
            }
            for(int i = 0; i < 26; i++){
                if(alpha[i] % 2 == 1){
                    cnt++;
                }
            }

            // 홀수개인 알파벳이 2개 이상 나오면 팰린드롬 변환 불가
            if(cnt > 1){
                return false;
            }else{
                return true;
            }
        }
    }

    // 팰린드롬을 출력해주는 함수
    static void printPalindrome(String str){
        int oddIdx = -1;
        StringBuilder sb = new StringBuilder();

        // 팰린드롬의 앞쪽 절반 만들기
        for(int i = 0; i < 26; i++){
            if(alpha[i] % 2 == 1){
                oddIdx = i;
            }
            if(alpha[i] != 1){
                int tmpLen = alpha[i];

                for(int j = 0; j < tmpLen / 2; j++){
                    sb.append((char)('A' + i));
                    alpha[i]--;
                }    
            }
        }

        // 홀수개 알파벳 중앙 배치
        if(oddIdx != -1){
            sb.append((char)('A' + oddIdx));
            alpha[oddIdx]--;
        }

        // 팰린드롬의 뒤쪽 절반 만들기
        for(int i = 25; i >= 0; i--){
            for(int j = 0; j < alpha[i]; j++){
                sb.append((char)('A' + i));
            }
        }

        System.out.println(sb);
    }
}
