import java.io.IOException;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        Scanner scan = new Scanner(System.in);
        String input = scan.next();
        int size = input.length();

        int[] alp = new int[26];
        for(int i=0; i<size; i++){        //문자열을 입력 받으며 알파벳 세기
            alp[input.charAt(i)-'A']++;      //아스키 코드를 사용하여 해당 알파벳 위치 ++
        }

        //홀수의 갯수 세기
        int odd=0;
        for(int i=0; i<alp.length; i++){
            if(alp[i]%2 != 0 ){
                center = i ;
                odd++;
            }
        }
      
        //알파벳 갯수 중 홀수가 있다면 가운데 위치하는 것만 가능
        int center=0;

        if(odd>1 || (odd==1 && size%2==0)) {              //홀수가 1개보다 많다면 만들 수 없다.
            System.out.println("I'm Sorry Hansoo");
            return;
        }

        //홀수가 1개라면 가운데에 위치시키고 양쪽을 완성시킨다.
        StringBuffer result = new StringBuffer();

        for(int i=0; i<alp.length; i++){
            for(int j=0; j<alp[i]/2; j++){
                result.append((char)(i+'A'));
            }
        }
        StringBuffer tmp = new StringBuffer(result.toString());         //알파벳을 순서대로 출력
        if(odd==1)              //가운데 알파벳 출력
        {
            result.append((char)(center+'A'));
        }
        System.out.println(result.toString()+tmp.reverse());            //뒤집은 알파벳 출력
    }
}
