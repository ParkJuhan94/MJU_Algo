import java.util.Scanner;

public class boj14501 {
    static int MAX=0;
    static int N;
    static int[] Pi;
    static int[] Ti;
    int answer;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
         N = sc.nextInt(); //상담할 수있는 기간
         Pi = new int[N + 1]; //상담 수익
         Ti = new int[N + 1]; // 상담에 소요되는 일 수
        for (int i=1; i<=N; i++){
            Ti[i] = sc.nextInt();
            Pi[i] = sc.nextInt();
        }
        DFS(1,0);
        System.out.println(MAX);
    }

    public static void DFS(int index, int earn){
         MAX = Math.max(MAX, earn);
        if (index>=N+1) return;
        //상담을 할때
        if(index+Ti[index]<=N+1){
            DFS(index+Ti[index],earn+Pi[index]);
        }

        DFS(index + 1, earn);



    }


}
