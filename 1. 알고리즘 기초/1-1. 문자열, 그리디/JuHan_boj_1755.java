package WEEK01.P1755;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.StringTokenizer;

public class Main {
    static int N, M;

    //static int[] priorityTen = { 8, 5, 4, 9, 1, 7, 6, 3, 2, 0};
    // zero 부터 nine 까지의 사전순 순서
    // 0이 10순위, 1이 5순위        0  1  2  3  4  5  6  7  8  9
    static int[] priorityTen = { 10, 5, 9, 8, 3, 2, 7, 6, 1, 4};
    static ArrayList<Integer> nums;
    static ArrayList<Node> rank; // 정렬 순위를 매기기 위한 nums 들의 고유값을 저장

    public static void main(String[] args) throws IOException {
        System.setIn(new FileInputStream("src/WEEK01/P1755/input.txt"));

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        M = Integer.parseInt(st.nextToken());
        N = Integer.parseInt(st.nextToken());
        nums = new ArrayList<>();
        rank = new ArrayList<>();
        for(int i = M; i <= N; i++){
            nums.add(i);
        }

        // M과 N은 1이상 99이하 -> 한자리 수 아니면 두자리 수
        for(int i = M; i <= N; i++){
            // 한자리일 때
            if(i < 10){
                rank.add(new Node(priorityTen[i] * 100, i));
            }
            // 두자리일 때
            else{
                int sum = priorityTen[i / 10] * 100;
                int target = i % 10;    // 일의 자리
                sum += priorityTen[target];
                rank.add(new Node(sum, i));
            }
        }

        Collections.sort(rank);

        int cnt = 0;
        for(int i = 0; i < rank.size(); i++){
            System.out.print(rank.get(i).getIdx() + " ");
            cnt++;
            if(cnt % 10 == 0){
                System.out.println();
            }
        }
    }

}

class Node implements Comparable<Node>{
    int num;
    int idx;

    public Node(int num, int idx) {
        this.num = num;
        this.idx = idx;
    }

    public int getIdx() {
        return idx;
    }

    @Override
    public int compareTo(Node o) {
        return num - o.num;
    }
}
