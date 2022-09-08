package boj_1755;
import java.io.BufferedReader; //버퍼를 이용한 입력
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.StringTokenizer; 

// BOJ숫자 놀이(문자열/1755) - 숫자 하나당 영어로 표현하였을 때 정렬된 순서대로 숫자를 출력.
// 입력) 첫째 줄에 M과 N이 주어진다.
// 출력) M 이상 N 이하의 정수를 문제 조건에 맞게 정렬하여 한 줄에 10개씩 출력한다.

public class boj_1755 {
	
	static String[] en = {"zero", "one", "two", "three", "four", "five", "six", "seven", "eight", "nine" }; // 변환시 사용 배열 
	
	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in)); //BufferedReader는 String을 반환
		StringTokenizer st = new StringTokenizer(in.readLine()); // 공백단위로 String을 쪼깨기 위해 사용
		
		int M = Integer.parseInt(st.nextToken()); //한 줄에서 공백 단위로 읽음, 첫번째 입력한 숫자.
		int N = Integer.parseInt(st.nextToken()); //두번째 입력한 숫자.
		LinkedList<String> list = new LinkedList<>(); // 숫자를 영어로 변환하여 저장할 리스트
		LinkedList<Integer> answer = new LinkedList<>(); // 숫자를 영어로 변환하여 저장할 리스트
		
		//M ~ N 까지 반복문 돌기
		for(int i=M; i<=N; i++) {
			if(i/10 > 0) { // 숫자가 두자리 수인 경우
				list.add(en[i/10]+" "+en[i%10]); //각 자리수를 영어로 변환 후 리스트에 추가
			}
			else // 숫자가 한자리 수인 경우
				list.add(en[i]); //영어로 바로 변환된 숫자를 리스트에 추가
		}
		list.sort(null); // 리스트를 사전 순으로 정렬
		
		
		for(int i=0; i < list.size(); i++) {
				StringTokenizer li = new StringTokenizer(list.get(i)); //리스트 각 요소의 문자열(영어)를 쪼갠다.
				String s1 = li.nextToken();
				if(li.hasMoreTokens()) {
					String s2 = li.nextToken();	
					answer.add(changenum(s1)*10 + changenum(s2));
				}
				else
					answer.add(changenum(s1)); // 한자리 수
										
		}
		
		
		while (!answer.isEmpty()) { // 출력을 위한 리스트가 비어있을 때까지 반복.
			for (int i = 0; i < 10; i++) { // 한줄에 10개씩 출력하기 위함
				if (answer.isEmpty()) { // 10개를 다 출력하지 않았을때 null이 출력되는것을 막기위해 한번 더 체크
					return; // 리스트가 비어있으면 종료
				}
				System.out.print(answer.poll() + " "); // 리스트의 첫번째 요소 추출, 출력
			}
			System.out.println(); 
		}
	
			
	}
	
	// 영어를 숫자로 변환하기 위한 함수
	private static int changenum(String s) {
		for (int i = 0; i <= 9; i++) { 
			if (s == (en[i])) { 
				return i; 
			}
		}	
		return 0;
		
	}

}
