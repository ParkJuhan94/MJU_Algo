import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.Scanner;

public class boj1339 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt(); //단어 갯수
        String[] num = new String[n];
        
        int[] alpha = new int[26];
        for (int i=0; i<n; i++){
            num[i] = sc.next();
        }

        Arrays.sort(num, new Comparator<String>(){
            public int compare(String s1, String s2){
                return Integer.compare(s2.length(), s1.length());//문자열 길이순 내림차순 정렬
            }
        });

       for (int i=0; i<n; i++){
           int temp = (int)Math.pow(10,num[i].length()-1);
           for (int j=0; j<num[i].length(); j++){
               alpha[num[i].charAt(j)-'A']+=temp;
               temp = temp/10;
           }
       }
        Arrays.sort(alpha); // 높은 숫자부터 9를 감소시키면서 대입 
       
        int x =9;
        int answer =0;
        for (int i=25; i>=0; i--){
            if(alpha[i]==0) continue;
            answer+=alpha[i]*x;
            x--;
        }

        System.out.println(answer);
    }
}
