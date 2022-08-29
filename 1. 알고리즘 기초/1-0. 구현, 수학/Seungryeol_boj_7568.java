import java.util.Scanner;

public class boj7568 {
    public static void main(String[] args) {
        // 무조건 키 몸무게 둘 다 상대방보다 커야 덩치가 크다 말함
        //각 사람의 등수는 자신보다 덩치큰사람의 수 +1

        //입력: 각 사람의 몸무게와 키 (x,y)
        //출력: 각 사람의 순서대로 덩치 등수 공백을 두고 한줄에 출력
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt(); // 전체 사람 수

        int[][] person = new int[n][2];

        for (int i=0; i<n; i++){
            for (int j=0; j<2; j++){
                person[i][j] = sc.nextInt();
            }
        }



        for (int i=0; i<n; i++){
            int k=0; //자신보다 덩치 큰 사람의 수 
            for (int j=0; j<n; j++){
                if(person[i][0]<person[j][0] && person[i][1]<person[j][1]){
                    k++;
                } else{
                    continue;
                }
            }
            System.out.print(k+1+" ");
        }
    }
}
