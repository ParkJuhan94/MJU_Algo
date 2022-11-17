import java.util.Scanner;

public class boj15649 {
    static int N,M;
    static int[] check;
    static int[] arr;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        N=sc.nextInt();
        M=sc.nextInt();
        check = new int[N + 1];
        arr = new int[M+1];

        DFS(1);
    }

    public static void DFS(int depth){

        if (depth ==M+1) {
            for (int i = 1; i <= M; i++) {
                System.out.print(arr[i] + " ");
            }
            System.out.println();
            return;
        }

        for (int i=1; i<=N; i++){
            if( check[i]==0 ){
                check[i]=1;
                arr[depth]=i;
                DFS(depth+1);
                check[i]=0;
            }
        }
    }
}
