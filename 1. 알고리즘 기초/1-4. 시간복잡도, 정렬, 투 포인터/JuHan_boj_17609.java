package WEEK09.P17609;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/*
여러분은 제시된 문자열을 분석하여 그것이 그 자체로 회문인지, 또는 한 문자를 삭제하면 회문이 되는 “유사회문”인지,
아니면 회문이나 유사회문도 아닌 일반 문자열인지를 판단해야 한다.

만일 문자열 그 자체로 회문이면 0, 유사회문이면 1, 그 외는 2를 출력해야 한다.
 */

public class Main {
    static int N;
    static String str;

    public static void main(String[] args) throws IOException {
        System.setIn(new FileInputStream("src/WEEK09/P17609/input.txt"));

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            str = st.nextToken();         

            if (isPossible(str)) {
                System.out.println("0");
            } else if (isPossibleSimilar(str)) {
                System.out.println("1");
            } else {
                System.out.println("2");
            }
        }
    }

    // 문자열이 회문인지 반환하는 함수
    static boolean isPossible(String str){
        StringBuilder sb = new StringBuilder(str);
        String reverse = sb.reverse().toString();

        if (str.equals(reverse)) {
            return true;
        } else {
            return false;
        }
    }

    // 문자열이 유사회문이인지 반환하는 함수
    static boolean isPossibleSimilar(String str){
        int len = str.length();
        int p1 = 0;
        int p2 = len - 1;

        while(p1 < p2)
        {
            if (str.charAt(p1) != str.charAt(p2))
            {
                StringBuffer lt_sb = new StringBuffer(str);
                lt_sb.deleteCharAt(p1);
                StringBuffer rt_sb = new StringBuffer(str);
                rt_sb.deleteCharAt(p2);

                boolean lt = isPossible(lt_sb.toString());
                boolean rt = isPossible(rt_sb.toString());

                if (lt || rt){
                    return true;
                } else {
                    return false;
                }
            }

            p1++;
            p2--;
        }
      
        return true;
    }
}
