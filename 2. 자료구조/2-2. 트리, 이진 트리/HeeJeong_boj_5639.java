import java.io.*;


public class boj_5639 {
    //전위 순회: root->l->r
    //후위 순회: l->r->root
    //중위 : l->root->r
  //  static int arr[] = new int [10001];

    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        Tree tree = new Tree();

        while (true){
            String data = bufferedReader.readLine();

            if(data.equals("")) break;
            // 더이상의 인풋이 존재하지 않으면 break
            int intData = Integer.parseInt(data);
            tree.createNode(intData);
        }
        tree.postOrder(tree.root);
        bufferedReader.close();

    }
}

class Node{
    private int data;
    private Node lNode;
    private Node rNode;

    public int getData(){
        return data;
    }
    public Node getlNode(){
        return lNode;
    }
    public Node getrNode(){
        return rNode;
    }

    public void setlNode(int data){
        this.lNode = new Node(data);
    }

    public void setrNode(int data){
        this.rNode=new Node(data);
    }
    public Node(int data){
        this.data=data;
        this.lNode=null;
        this.rNode=null;
    }
}
class Tree{
    Node root;

    //루트 노드를 생성
    void createNode(int data){
        if(root==null){
            root = new Node(data);
        } else {
            anotherNode(root,data);
        }
    }

    //루트 외 다른 노드들을 생성
    void anotherNode(Node node, int data){
        if(node.getData() > data){
           if(node.getlNode()==null) {
               node.setlNode(data);
           } else {
               anotherNode(node.getlNode(), data);
           }
        }
        else {
            if(node.getrNode()==null){
                node.setrNode(data);
            }else {
                anotherNode(node.getrNode(),data);
            }
        }
    }

    //후위 순회 방식으로 노드를 출력
    void postOrder (Node node){
        if(node != null){
            if(node.getlNode()!=null)
                postOrder(node.getlNode());

            if(node.getrNode()!=null)
                postOrder(node.getrNode());
            System.out.println(node.getData());
        }
    }
}
