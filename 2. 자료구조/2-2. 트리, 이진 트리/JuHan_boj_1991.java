package WEEK21.P1991;

import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        Tree tree = new Tree();

        for(int i = 0; i < N; i++) {
            char[] data;
            data = br.readLine().replaceAll(" ", "").toCharArray();
            tree.createNode(data[0], data[1], data[2]);
        }

        //전위 
        tree.preorder(tree.root);
        System.out.println();

        //중위 
        tree.inorder(tree.root);
        System.out.println();
        
        //후위 
        tree.postorder(tree.root);

        br.close();
    }

}

class Node {
    char data;
    Node left;
    Node right;

    Node(char data) {
        this.data = data;
    }
}

class Tree {
    Node root; //루트 노드 : 처음엔 null

    public void createNode(char data, char leftData, char rightData) {
        if(root == null) { //아무것도 없는 초기 상태 - A 루트 노드 생성 
            root = new Node(data);

            //좌우 값이 있는 경우에만! 노드 생성 
            if(leftData != '.') {
                root.left = new Node(leftData);
            }
            if(rightData != '.') {
                root.right = new Node(rightData);
            }
        } else { //초기상태가 아니면 어디에 들어가야할지 찾아야함 - A 루트 노드 이후 
            searchNode(root, data, leftData, rightData);
        }
    }

    //여기에서 root는 매개 변수로 들어온 로컬변수 root임을 주의 
    public void searchNode(Node root, char data, char leftData, char rightData) {
        if(root == null) { //도착한 노드가 null이면 재귀 종료 - 찾을(삽입할) 노드 X
            return;
        } else if(root.data == data) { //들어갈 위치를 찾았다면 
            if(leftData != '.') { //.이 아니라 값이 있는 경우에만 좌우 노드 생성 
                root.left = new Node(leftData);
            }
            if(rightData != '.') {
                root.right = new Node(rightData);
            }
        } else { //아직 찾지못했고 탐색할 노드가 남아 있다면 
            searchNode(root.left, data, leftData, rightData); //왼쪽 재귀 탐색 
            searchNode(root.right, data, leftData, rightData); //오른쪽 재귀 탐색 
        }
    }

    // 전위순회 : 루트 -> 좌 -> 우 
    public void preorder(Node root){
        System.out.print(root.data);                //먼저 가운데 출력
        if(root.left!=null) preorder(root.left);    //그 다음 왼쪽
        if(root.right!=null) preorder(root.right);   //마지막 오른쪽
    }

    // 중위순회 : 좌 -> 루트 -> 우
    public void inorder(Node root){
        if(root.left!=null) inorder(root.left);     //왼쪽 먼저
        System.out.print(root.data);                //그 다음 중앙 출력
        if(root.right!=null) inorder(root.right);    //마지막으로 오른쪽
    }

    // 후위순회 : 좌 -> 우 -> 루트 
    public void postorder(Node root){
        if(root.left!=null) postorder(root.left);    //왼쪽 먼저
        if(root.right!=null) postorder(root.right);     //그 다음 오른쪽
        System.out.print(root.data);
    }

}
