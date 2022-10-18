package boj_2630;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

//BOJ색종이 만들기(분할정복)
public class boj_2630 {
	public static int N; //한변의 길이
	public static int [][] arr;
	public static int white = 0;
	public static int blue = 0 ;
	
	
	public static void main(String[] args) throws IOException {
		// 첫번째 입력값 만큼 2차원 배열 생성하기
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(in.readLine()); 
		
		// 입력값들 순차적으로 2차원 배열에 저장
		int[][] arr	= new int[N][N];
		for(int i=0; i<N; i++) {
			StringTokenizer st = new StringTokenizer(in.readLine());
			for(int j=0; j<N; j++) {
				//StringTokenizer st = new StringTokenizer(in.readLine());
				arr [i][j] = Integer.parseInt(st.nextToken());
			}		
		}		
		
		div(0, 0, N);
		
		System.out.println(white);
		System.out.println(blue); 
	}
	
	
	// 배열 내 요소 확인후, 컬러가 모두 다를시 분할
	public static void div(int row, int col, int N) {
		if(colorCheck(row, col, N)) { //배열 내 모든 컬러 같은 경우
			if(arr[row][col] == 0) {
				white++;
			}
			else {
				blue++;
			}
		}
		
		int newN = N/2;
		
		div(row, col, newN);//2사분면
		div(row, col + newN, newN);//1사분면
		div(row + newN, col, newN);//3사분면
		div(row + newN, col + newN, newN);//4사분면		
	}
	
	
	// 배열 내 모든 컬러가 같은지 확인
	public static boolean colorCheck(int row, int col, int N) {
		
		for(int i=0; i<N; i++)
			for(int j=0; j<N; j++)
				if(arr[row][col] != arr[i][j]) {
					return false; // 다른 컬러 발견시 false 리턴
				} 
		return true;	
	}

}
