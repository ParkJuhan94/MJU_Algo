package boj_10597;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

//BOJ순열장난(백트래킹/10597) - 공백이 지워진 입력된 순열을 복구해서 출력.
//입력) 첫 줄에 공백이 사라진 수열이 주어진다. ex) 4111109876532
//순열은 최소 1개 최대 50개의 수로 이루어져 있다.
//출력) 복구된 수열을 출력한다. ex) 4 1 11 10 9 8 7 6 5 3 2

public class boj_10597 {
	static String str;
	static boolean visit[];
	static int len;
	
	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in)); //BufferedReader는 String을 반환
		str = in.readLine(); 
		len = str.length();
		visit = new boolean[51]; 
		dfs(0,0,"");

	}

	private static void dfs(int idx, int N, String ans) {
		if(idx == len) {
			for(int i=1; i<=N; i++) {
				if(!visit[i])
					return;			
			}
			System.out.println(ans.trim()); //문자열 앞뒤 공백 제거
			System.exit(0);
			return;			
		}
		
		String tmp = str.substring(idx, idx+1); //한 자리씩 끊을 때
		int num = Integer.parseInt(tmp);
		if(!visit[num]) {
			visit[num] = true;
			dfs(idx+1,(num > N)? num : N, ans+" "+tmp);
			visit[num] = false;
		}
		
		if(idx < len-1) {
			tmp = str.substring(idx, idx+2); // 두자리 씩 끊을 때
			num = Integer.parseInt(tmp);
			if(num < 51 &&!visit[num]) {
				visit[num] = true;
				dfs(idx+2, (num>N)? num : N, ans+" "+tmp);
				visit[num] = false;			
			}
		}
	}
		
}
