package boj_1431;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class boj_1431 {

	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in)); 
		StringTokenizer st = new StringTokenizer(in.readLine()); 
		
		int N = Integer.parseInt(st.nextToken()); 
		String[] arr = new String[N]; 
		
		for(int i=0;i<N;i++) 
			arr[i] = in.readLine();
		
        Arrays.sort(arr, (o1, o2) -> {
            if(o1.length() - o2.length()==0){   // 1. 길이비교
                int a = getSum(o1);
                int b = getSum(o2);
                
                if(a - b == 0){                 // 2. 문자열에 숫자값의 합 비교
                    return o1.compareTo(o2);    // 3. 알파벳 순서 = 문자열 비교
                }
                else {
                    return a - b;
                }
                
            }else {
                return o1.length() - o2.length();
            }
        }
        );
        
        for (String s : arr) 
        	System.out.println(s); //arr 배열 안의 값 변수s 에 순차적대입 후 출력
        
    }
	
	
	// 대상 문자열을 원하는 문자 값으로 변환하는 함수 이용, 자릿수 합 반환.
    public static int getSum(String s){
        int sum= 0;
        s = s.replaceAll("[^0-9]","");
        
        for(char c : s.toCharArray()) 
        	sum+= Character.getNumericValue(c);
        
        return sum;
    }
}
