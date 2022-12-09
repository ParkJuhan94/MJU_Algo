package WEEK01.P5052;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static int tc, N;

    public static void main(String args[]) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        tc = Integer.valueOf(st.nextToken());

        while(tc --> 0) {
            Trie trie = new Trie();
            st = new StringTokenizer(br.readLine());
            int n = Integer.valueOf(st.nextToken());
            boolean isContain = false;
            List<String> keys = new ArrayList<String>();

            for(int i = 0; i < n; i++) {
                String str = br.readLine();
                trie.insert(str);
                keys.add(str);
            }

            int flag = 0;
            for(String key : keys) {
                TrieNode node = trie.getRootNode();
                StringBuilder sb = new StringBuilder();
                char cur;

                for(int i=0; i < key.length() - 1; i++){
                    cur = key.charAt(i);
                    sb.append(cur);
                    if(trie.contains(sb.toString())) {
                        flag = 1;
                        break;
                    }
                    node = node.getChildNodes().get(cur);
                }
            }

            if(flag == 1) {
                System.out.println("NO");
            }
            else {
                System.out.println("YES");
            }
        }
    }
}

class Trie {
    private TrieNode rootNode;

    Trie(){
        rootNode = new TrieNode();
    }

    void insert(String word){
        TrieNode node = this.rootNode;
        for(int i=0; i<word.length(); i++) {
            node = node.getChildNodes().computeIfAbsent(word.charAt(i),
                    c -> new TrieNode());
        }
        node.setLast(true);
    }

    // 특정 단어가 트라이에 존재하는지 반환
    boolean contains(String word){
        TrieNode node = this.rootNode;
        char cur;
        for(int i=0; i<word.length(); i++){
            cur = word.charAt(i);
            if(!node.getChildNodes().containsKey(cur)) return false;
            node = node.getChildNodes().get(cur);
        }
        return node.isLast();
    }

    void delete(String word){
        delete(this.rootNode, word, 0);
    }

    private void delete(TrieNode node, String word, int index){
        if(index == word.length()){
            if(!node.isLast()) throw new Error("not exist");
            node.setLast(false);
            return;
        }
        char cur = word.charAt(index);
        if(!node.getChildNodes().containsKey(cur)) throw new Error("not exist");
        TrieNode child = node.getChildNodes().get(cur);
        delete(node.getChildNodes().get(cur), word, index+1);
        if(child.getChildNodes().isEmpty()) {
            if(!child.isLast()) node.getChildNodes().remove(cur, child);
        }
    }

    public TrieNode getRootNode() {
        return rootNode;
    }
}

class TrieNode {
    private Map<Character, TrieNode> childNodes = new HashMap<>();
    private boolean isLast;

    public Map<Character, TrieNode> getChildNodes() {
        return childNodes;
    }

    public boolean isLast() {
        return isLast;
    }

    public void setLast(boolean last) {
        isLast = last;
    }
}
