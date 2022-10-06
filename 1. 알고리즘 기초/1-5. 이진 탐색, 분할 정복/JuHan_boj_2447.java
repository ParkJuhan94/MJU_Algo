package WEEK06.P2447;

import java.io.*;
import java.util.StringTokenizer;

public class Main {
    static String[][] arr;

    public static void main(String[] args) throws IOException {

        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int N = Integer.parseInt(bf.readLine());
        arr = new String[N][N];

        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr[0].length; j++) {
                arr[i][j] = " ";
            }
        }

        star(arr, 0, 0, N);

        for (String[] strings : arr) {
            for (String string : strings) {
                bw.write(string + "");
            }
            bw.write("\n");
        }

        bw.flush();
        bw.close();
    }

    // 파라미터값으로 (배열의 주소값, 시작점 x좌표, 시작점 y좌표, 길이)
    public static void star(String[][] arr, int x, int y, int len) {
        // 종료 조건 : 분할 정복의 끝 -> 길이를 3의 제곱으로 나눠서 1이 되었을 때
        if (len == 1) {
            arr[x][y] = "*";    // 별을 찍어준다.
            return;
        }

        // 분할을 계속 한다 -> 재귀
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                if (!(i == 1 && j == 1)) {      // 가운데 좌표는 비어있도록 호출 안 한다.
                    star(arr, x + i * (len / 3), y + j * (len / 3), len / 3);
                }
            }
        }
    }
}
