package boj_1246;

import java.util.Arrays;
import java.util.Scanner;

// BOJ온라인 판매(그리디/1246) - i번째 고객은 달걀 하나를 pi가격 이하로 구매.
// 입력) 첫째줄 - 달걀 N개, 고객 M명
//	    두번째줄 ~ M+1줄 - pi
// 출력) 측정한 가격 A, 이 가격으로 올릴 수 있는 수익 
public class boj_1246 {

	@SuppressWarnings("resource")
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		int N = scan.nextInt(); //달걀 수
		int M = scan.nextInt(); //고객 수
		int[] p = new int[M]; 
		
		for(int i=0; i<M; i++) {			
			p[i] = scan.nextInt(); // 입력받은 pi 가격을 배열에 저장. 
		}
		Arrays.sort(p); // 배열p 오름차순으로 정렬.
		
		int A =0; //측정가격
		int max =0; // 총 수익
		
		for(int i=0; i<M; i++) {
			int result=0; 	
			
			if(M-i<N) { 
				result = p[i] * (M-i);
			}else { // 고객수가 달걀 수 보다 많은 경우
				result = p[i] * N;
			}
			
			if(result>max) {
				max = result;
				A = p[i];		
			}	
		}
		
		System.out.println(A + " "+ max);

	}

}
