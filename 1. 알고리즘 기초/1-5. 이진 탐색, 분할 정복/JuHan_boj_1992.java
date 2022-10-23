package WEEK08.P1992;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static int N;
    static int[][] map;
    public static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws IOException {
        System.setIn(new FileInputStream("src/WEEK08/P1992/input.txt"));

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());

        map = new int[N][N];
        for(int i = 0; i < N; i++){
            String input = br.readLine();
            for(int j = 0; j < N; j++){
                map[i][j] = input.charAt(j) - '0';
            }
        }

        QuadTree(0, 0, N);
        System.out.println(sb);
    }

    // 압축이 가능한지를 리턴
    public static boolean isPossible(int x, int y, int size) {
        int value = map[x][y];  // 기준으로 할 첫번째 값

        for(int i = x; i < x + size; i++) {
            for(int j = y; j < y + size; j++) {
                if(value != map[i][j]) {
                    return false;
                }
            }
        }
        return true;
    }

    public static void QuadTree(int x, int y, int size) {

        if(isPossible(x, y, size)) {    // 압축 가능해?
            sb.append(map[x][y]);       // 압축되면 append 하고 종료
            return;
        }

        int newSize = size / 2;	    // 압축 불가능 -> 사이즈를 절반으로

        sb.append('(');     // 분할 직전에 여는 괄호

        QuadTree(x, y, newSize);						    // 1 왼쪽 위
        QuadTree(x, y + newSize, newSize);				// 2 오른쪽 위
        QuadTree(x + newSize, y, newSize);				// 3 왼쪽 아래
        QuadTree(x + newSize, y + newSize, newSize);	// 4 오른쪽 아래

        sb.append(')');     // 분할 직후에 닫는 괄호
    }
}
