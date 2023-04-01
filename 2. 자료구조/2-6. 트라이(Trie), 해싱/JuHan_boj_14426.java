package WEEK0.P14426;

import java.io.BufferedReader;
        import java.io.FileInputStream;
        import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    static int N, M;
    static int ans;
    static TrieNode root = new TrieNode();

    public static void main(String[] args) throws Exception {
        System.setIn(new FileInputStream("src/WEEK0/P14426/input.txt"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        for (int i = 0; i < N; i++) {
            insertTireNode(br.readLine());
        }

        for (int i = 0; i < M; i++) {
            String str = br.readLine();
            int strlen = str.length();

            TrieNode current = root;
            int flag = 0;

            for(int j = 0; j < strlen; j++){
                char c = str.charAt(j);
                int index = c - 'a';

                if(current.hasChild(c)){
                    current = current.chlid[index];
                }else{
                    flag = 1;
                    break;
                }
            }

            if(flag == 0){
                ans++;
            }
        }

        System.out.println(ans);
    }

    static void insertTireNode(String word) {
        TrieNode current = root;
        for (int i = 0; i < word.length(); i++) {
            char a = word.charAt(i);
            int index = a - 'a';
            if (current.chlid[index] == null) {
                current.chlid[index] = new TrieNode();
            }
            current = current.chlid[index];
        }
        current.isWord = true;
    }
}

class TrieNode {
    boolean isWord = false;
    boolean isHit = false;
    TrieNode[] chlid = new TrieNode[26];

    void clearHit() {
        isHit = false;
        for (int i = 0; i < chlid.length; i++) {
            if (chlid[i] != null) {
                chlid[i].clearHit();
            }
        }
    }

    boolean hasChild(char c) {
        return chlid[c - 'a'] != null;
    }

    TrieNode getChild(char c) {
        return chlid[c - 'a'];
    }
}
