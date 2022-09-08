import java.util.Arrays;
import java.util.Scanner;

public class boj5052 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int T  = sc.nextInt();
        for (int i=0; i<T; i++){
            int n =sc.nextInt(); //전화번호 갯수
           // sc.nextLine();
            String[] phoneNum = new String[n];
            for (int j=0; j<n; j++){
                phoneNum[j] = sc.nextLine();
            }
            Arrays.sort(phoneNum); //짧은 문자가 앞에와야 비교가능.
            boolean isString =true;
            int index =0;
            for (int k=index+1; k<n; k++){
                if(phoneNum[k].startsWith(phoneNum[index++])){
                    //j 인덱스 다음 문자들이 j인덱스 문자와 시작이 같으면 false
                    isString = false;
                    break; // 하나라도 같으면 일관성이 없음 .
                }
            }
            if(isString == false){
                System.out.println("NO");
            } else{
                System.out.println("YES");
            }
        }
    }


}
