package Practice;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class heapClass {
    static int[] heap = new int[100001];
    static int size =0;
    static StringBuilder sb = new StringBuilder();
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        for (int i=0; i<N; i++){
            int x = Integer.parseInt(br.readLine());

            if(x==0){
                if(size == 0) {
                    sb.append(0+"\n");
                } else {
                    popHeap();
                }
            } else{
                pushHeap(x);
            }
        }

        System.out.print(sb.toString());
    }

    public static void swap(int x, int y){
        int temp =heap[x];
        heap[x]= heap[y];
        heap[y] = temp;
    }
    public static void pushHeap(int n){
        heap[++size]=n;

        for (int i=size; i>1; i=i/2){
            if(heap[i]>heap[i/2]){
                swap(i,i/2);
            }
        }
    }

    public static void popHeap(){
        sb.append(heap[1]+"\n");
        heap[1] = heap[size];
        heap[size--] = 0;
        for(int i=1; i*2<=size;) { //삭제 후 1에서 부터 힙으로 만들어주는 과정
            if(heap[i] > heap[i*2] && heap[i] > heap[i*2+1]) {
                break;
            }else if(heap[i*2] > heap[i*2+1]) {
                swap(i, i*2);
                i = i*2;
            } else {
                swap(i, i*2+1);
                i = i*2+1;
            }
        }
    }
}
