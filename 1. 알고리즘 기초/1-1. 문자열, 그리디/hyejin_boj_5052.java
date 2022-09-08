package boj_5052;

import java.util.Arrays;
import java.util.Scanner;

//BOJ전화번호 목록(문자열/5052) - 주어진 전화번호 목록이 일관성이 있는지 없는지를 구하는 프로그램을 작성
//이전의 숫자가 다음 숫자의 시작부분과 일치하는지 체크하면 접두어인지 아닌지 알 수 있음.
//입력) 첫째줄 - 테스트 케이스의 개수 t (1 ≤ t ≤ 50) 
//	   각 테스트 케이스의 첫째 줄에는 전화번호의 수 n이 주어진다.
//     다음 n개의 줄에는 목록에 포함되어 있는 전화번호가 하나씩 주어진다.
//출력) 각 테스트 케이스에 대해서, 일관성 있는 목록인 경우에는 YES, 아닌 경우에는 NO를 출력. 
public class boj_5052 {

	@SuppressWarnings("resource")
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		int t = scan.nextInt(); //테스트 케이스 개수
		
		for(int i=0; i<t; i++) {			
			int n = scan.nextInt(); //전화번호 수
			scan.nextLine(); //
			
			String[] nums = new String[n]; //입력받은 번호 목록 저장하는 배열

			for(int j=0; j<n; j++) {
				nums[j] = scan.nextLine(); // 입력받은 전화번호을 배열에 저장. 
			}
			Arrays.sort(nums); // 전화번호목록 오름차순으로 정렬.
			
			boolean bool = true;
			for(int j=1; j<n; j++) { //j-1과 j를 비교하므로, j=1로 설정. j=0으로 하면 오류발생	
				if(nums[j].startsWith(nums[j-1])) { // //겹치는 숫자가 있을 경우
					bool = false;
					break;
				}
			}
			
			if(bool==true) System.out.println("YES");
			else System.out.println("NO");			
					
		}		
		
	}
}
			
			
