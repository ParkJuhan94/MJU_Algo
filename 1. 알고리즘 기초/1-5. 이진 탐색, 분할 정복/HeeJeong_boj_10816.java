import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.StringTokenizer;

public class Main {
    static StringTokenizer st;
    static int n;
    static int m; 
    static HashMap<Integer, Integer> map;

    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        n = Integer.parseInt(br.readLine());
        map = new HashMap<>();
        StringBuffer sb = new StringBuffer();

        // 숫자 카드 입력
        st = new StringTokenizer(br.readLine());
        for(int i = 0; i < n; i++) {
            int num = Integer.parseInt(st.nextToken());

            // 처음 들어오는 숫자
            if(!map.containsKey(num)) {
                map.put(num, 1);
            }
            // 이미 있는 숫자라면 +1
            else {
                map.put(num, map.get(num) + 1);
            }
        }

        // 찾을 카드 입력
        m = Integer.parseInt(br.readLine());
        st = new StringTokenizer(br.readLine());
        for(int i = 0; i < m; i++) {
            int num = Integer.parseInt(st.nextToken());

            // 숫자가 존재하면 갯수 리턴
            if(map.containsKey(num)) {
                sb.append(map.get(num) + " ");
            }
            // 없다면 0
            else {
                sb.append(0 + " ");
            }
        }

        System.out.println(sb.toString());
    }
}
