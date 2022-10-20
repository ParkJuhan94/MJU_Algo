package WEEK01.P1339;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.StringTokenizer;

public class Main {
    static int N;
    static ArrayList<String> words;
    static int[] alpha;     // 알파벳의 중요도값
    static Node[] weight;   // 알파벳의 중요도값 + 인덱스

    public static void main(String[] args) throws IOException {
        System.setIn(new FileInputStream("src/WEEK01/P1339/input.txt"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        words = new ArrayList<>();
        for(int i = 0; i < N; i++){
            words.add(br.readLine());
        }
        alpha = new int[26];
        weight = new Node[26];

        // 알파벳 중요도값 구하기 -> 단어들의 자릿수에 따라 카운팅하기
        for(int i = 0; i < words.size(); i++){
            String word = words.get(i);
            int len = word.length();
            int digit = 1;
            
            for(int j = len - 1; j >= 0; j--){
                alpha[word.charAt(j) - 'A'] += digit;
                digit *= 10;
            }
        }

        //자릿수 카운팅 확인
//        for(int i = 0; i < 26; i++){
//            System.out.print(alpha[i] + " ");
//        }

        // 알파벳 중요도값에 인덱스를 같이 저장
        for(int i = 0; i < 26; i++){
            weight[i] = new Node(i, alpha[i]);
        }
        Arrays.sort(weight);

        //인덱스까지 확인
//        for(int i = 0; i < 26; i++){
//            System.out.println(weight[i].idx + " " + weight[i].data);
//        }

        int sum = 0;
        // 9부터 분배해서 바로 sum
        for(int i = 0; i < 26; i++){
            sum += weight[i].data * (9 - i);

            if(weight[i].data == 0){
                break;
            }
        }

        System.out.println(sum);
    }
}

class Node implements Comparable<Node>{
    int idx;    // 알파벳
    int data;   // 중요도
    int multi;  // 9부터 내림차순으로 곱할 값

    public Node(int idx, int data) {
        this.idx = idx;
        this.data = data;
    }

    @Override
    public int compareTo(Node o) {
        return o.data - data;
    }
}
