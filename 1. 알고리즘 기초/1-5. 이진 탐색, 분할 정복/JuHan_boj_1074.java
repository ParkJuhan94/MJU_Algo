//package WEEK13.P1074;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static int N, r, c, range, mod;

    public static void main(String[] args) throws IOException {
//        System.setIn(new FileInputStream("src/WEEK13/P1074/input.txt"));

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        r = Integer.parseInt(st.nextToken());
        c = Integer.parseInt(st.nextToken());
        range = 1;
        mod = 1;

        for(int i = 1; i < N; i++){
            range *= 2;
            mod *= 4;
        }
        range *= 2;

        int res = 0;

        // n = 3, r = 3, c = 4
        // res = 26
        for(int i = 0; i < N; i++){
            int x = r / (range / 2);
            r = r % (range / 2);
            int y = c / (range / 2);
            c = c % (range / 2);

            if(x == 0 && y == 0){
                res += mod * 0;
                //System.out.println(i+1 + "번째" + "1사분면");
            }else if(x == 0 && y == 1){
                res += mod * 1;
                //System.out.println(i+1 + "번째" + "2사분면");
            }else if (x == 1 && y == 0){
                res += mod * 2;
                //System.out.println(i+1 + "번째" + "3사분면");
            }else if (x == 1 && y == 1){
                res += mod * 3;
                //System.out.println(i+1 + "번째" + "4사분면");
            }
            mod /= 4;
            range /= 2;
        }

        System.out.println(res);
    }
}


