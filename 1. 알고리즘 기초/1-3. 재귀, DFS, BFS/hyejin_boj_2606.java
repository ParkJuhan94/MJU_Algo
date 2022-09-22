package boj_2606;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

//BOJ바이러스(BFS/2606)
//입력) 첫째 줄에는 컴퓨터의 수, 
//	   둘째 줄에는 연결되어 있는 컴퓨터 쌍의 수
//	   이어서 쌍의 수 만큼 한줄에 컴퓨터의 번호 쌍
//출력) 1번 컴퓨터가 웜 바이러스에 걸렸을 때 바이러스 걸린 컴퓨터 수
public class boj_2606 {

	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in)); //BufferedReader는 String을 반환
	
		int N = Integer.parseInt(in.readLine()); // 컴퓨터의 수 = 노드의 수
		int M = Integer.parseInt(in.readLine()); // 컴퓨터 쌍의 수 = 연결된 간선의 수
		
		//연결상태를 확인하는 2차원 인접 행렬 생성
		int[][] arr	= new int[N+1][N+1];
		for(int i=0; i<M; i++) {
			StringTokenizer st = new StringTokenizer(in.readLine());
			int x = Integer.parseInt(st.nextToken());
			int y = Integer.parseInt(st.nextToken());
			arr[x][y] = 1;
			arr[y][x] = 1;
		}
		
		Queue<Integer> queue = new LinkedList<>(); //int형 queue 선언
		boolean[] visit = new boolean[N + 1];
		queue.add(1); //1번부터 검사시작. 
		int count = 0; // 감영된 컴퓨터 수
		while(!queue.isEmpty()) { //큐가 빌때 까지 반복
			int v = queue.poll();// 큐의 첫번째 값을 반환하고 제거, 비어있다면 null
			for(int i=1; i<=N; i++) {
				if(arr[v][i] == 1 && !visit[i]) { 
					visit[i] = true; //해당 정점을 방문함으로 표시
					queue.add(i);
					count ++;
				} 
			}		
		}
		
		System.out.println(count);	
	}

}
