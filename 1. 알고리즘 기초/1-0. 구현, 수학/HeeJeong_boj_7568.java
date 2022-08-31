import java.util.*;

public class Main {
    public static void main(String[] args) {

        Scanner scan = new Scanner(System.in);

        int N = scan.nextInt();

        int[][] arr = new int[N][2];        // N행 2열 생성

        for(int i=0; i<N; i++){
            arr[i][0] = scan.nextInt();         //몸무게
            arr[i][1] = scan.nextInt();         //키
        }

        for(int i=0; i <N; i++) {
            int rank = 1;

            for(int j=0; j<N; j++){
                if(i==j) continue;
                if(arr[i][0]<arr[j][0] && arr[i][1] < arr[j][1]){
                    rank++;
                }
            }
            System.out.print(rank+" ");}
    }
}
