package WEEK16.P1068;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
import java.util.ArrayList;

public class Main {
    static Node root; // 초기 root는 null
    static ArrayList<Node> Tree = new ArrayList<>();
    static int count = 0;

    public static void main(String[] args) throws IOException {
        System.setIn(new FileInputStream("src/WEEK16/P1068/input.txt"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        int N = Integer.parseInt(br.readLine());

        st = new StringTokenizer(br.readLine());

        for (int i=0; i < N; i++){
            Tree.add(new Node(i));
        }

        for (int i=0; i < N; i++){
            int parent = Integer.parseInt(st.nextToken());
            if(parent != -1){
                Tree.get(parent).child.add(Tree.get(i));
                Tree.get(parent).childSize++;
            }
        }

        int delNum = Integer.parseInt(br.readLine());
        deleteNode(delNum);

        for (int i=0; i<Tree.size(); i++){
            if(Tree.get(i).exist == true && Tree.get(i).childSize == 0) count++;
        }

        System.out.println(count);
    }

    static void deleteNode(int delNum){
        Tree.get(delNum).exist = false;

        for (Node child: Tree.get(delNum).child){
            child.exist = false;
            deleteNode(child.num);
        }

        for(int i = 0; i < Tree.size(); i++){
            if(Tree.get(i).isExist(delNum)){
                Tree.get(i).childSize--;
            }
        }
    }
}

class Node{
    ArrayList<Node> child = new ArrayList<>();
    boolean exist;
    int num; //자신의 번호
    int childSize;

    public Node(int num){
        this.num = num;
        exist = true;
        childSize = 0;
    }

    // child 중에 data를 num으로 갖고있는지 반환
    boolean isExist(int data){
        for(int i = 0; i < childSize; i++){
            if(child.get(i).num == data){
                return true;
            }
        }
        return false;
    }
}
