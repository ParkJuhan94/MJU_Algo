import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class boj2042 {
    static long[] tree;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken()); // 수의 개수
        int m = Integer.parseInt(st.nextToken()); // 수의 변경이 일어나는 횟수
        int sumCount = Integer.parseInt(st.nextToken());

        int k = 0;

        while(true){ //2^k >=n 을 만족하는 k값 하기
            if (Math.pow(2,k)>=n){
                break;
            } else {
                k++;
            }
        }

        

        int treeSize = (int)Math.pow(2,k)*2;
        int treeStart = (int) Math.pow(2, k); // 시작 인덱스
        tree = new long[treeSize];

        for (int i=treeStart; i<treeStart+n; i++){
            long num = Long.parseLong(br.readLine());
            tree[i] = num;
        }
        SetTree(treeSize - 1);

        for (int i=0; i<m+sumCount; i++){
            st = new StringTokenizer(br.readLine());
            int t = Integer.parseInt(st.nextToken()); //질의 타입
            int s = Integer.parseInt(st.nextToken()); // 변경 시작 지점
            long e = Long.parseLong(st.nextToken()); // 변경 끝나는 지점


            if (t==1){
                changeVal((treeStart-1)+s,e);
            } else if (t==2){
                s = s+(treeStart-1);
                e = e + (treeStart - 1);
                System.out.println(getSum(s, (int) e));
            }
        }

    }
    public static void SetTree(int i){ //Tree 초기화 함수
        while(i>1){ // 15 14 13
            tree[i/2]+=tree[i];
            i--;
        }
    }

    public static void changeVal(int index, long changeNum){
        long diff = changeNum - tree[index];
        tree[index] = changeNum;
        while(index>0){
            tree[index/2]+=diff;
            index= index/2;
        }
    }

    public static long getSum(int start, int end){
        long partSum =0;
        while(start<=end){
            if(start%2 ==1){
                partSum+=tree[start];
                start++;
            }
            if(end%2 ==0){
                partSum += tree[end];
                end --;
            }
            start = start/2;
            end = end/2;
        }

        return partSum;
    }
}
