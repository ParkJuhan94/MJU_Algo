import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.Buffer;
import java.util.Arrays;
import java.util.StringTokenizer;
 
public class boj2357 {  // 세그먼트 트리를 활용해 
    static int N, M;
    static long[] minTree;
    static long[] maxTree;
    static int treeSize;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        StringBuilder sb= new StringBuilder();
        st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken()); // 정수 갯수
        M = Integer.parseInt(st.nextToken()); // 쌍의 갯수
        int k = 0;

        while(true){ //2^k >=n 을 만족하는 k값 하기
            if (Math.pow(2,k)>=N){
                break;
            } else {
                k++;
            }
        }
        treeSize = (int) Math.pow(2, k) * 2;

        minTree = new long[treeSize];
        maxTree = new long[treeSize];
        int treeStart = (int) Math.pow(2, k);

        for (int i=treeStart; i<treeStart+N; i++){
            int num = Integer.parseInt(br.readLine());
            minTree[i]=num;
            maxTree[i]=num;
        }
        setMaxTree(treeSize-1);
        setMinTree(treeSize-1);

        for(int i=0; i<M; i++){
            st = new StringTokenizer(br.readLine());
            int s = Integer.parseInt(st.nextToken());
            int e = Integer.parseInt(st.nextToken());

            int start = s+(treeStart-1);
            int end = e+(treeStart-1);
            sb.append(findMin(start, end) + " " + findBig(start, end) + "\n");

        }

        System.out.print(sb.toString());
    }

    public static long findBig(int start, int end){

        long maxNum=0;
        long maxLeft = Long.MIN_VALUE,maxRight=Long.MIN_VALUE;
        while(start<=end){
            if(start%2==1){
                maxLeft = Math.max(maxLeft,maxTree[start]);
                start++;
            }

            if(end%2 ==0){
                maxRight = Math.max(maxRight,maxTree[end]);
                end --;
            }

            maxNum = Math.max(maxLeft, maxRight);
            start = start/2;
            end = end/2;
        }
        return maxNum;
    }

    public static long findMin(int start, int end){

        long minNum=Long.MAX_VALUE;
        long minLeft =Long.MAX_VALUE ,minRight=Long.MAX_VALUE;

        while(start<=end){
            if(start%2==1){
                minLeft = Math.min(minLeft,minTree[start]);
                start++;
            }

            if(end%2 ==0){
                minRight = Math.min(minRight,minTree[end]);
                end --;
            }

            minNum = Math.min(minLeft, minRight);
            start = start/2;
            end = end/2;

        }


        return minNum;
    }

    public static void setMaxTree(int treeSize){
        int i=treeSize;
        while(i>2){
            maxTree[i/2] = Math.max(maxTree[i],maxTree[i-1]);
            i= i-2;
        }

    }

    public static void setMinTree(int treeSize){
        int i =treeSize;
        while(i>2){
            minTree[i/2] = Math.min(minTree[i],minTree[i-1]);
            i= i-2;
        }
    }

}
