import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader (new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int total = 0;
        int now = 0;
        int candidateIdx = 0;         //후보가 들어갈 사진틀 위치
        int pictureNum =Integer.parseInt(br.readLine());        //사진틀 개수
        StringTokenizer st;

        int[] student = new int[pictureNum];
        int[] recommend = new int[pictureNum];      //추천 횟수
        int[] time = new int[pictureNum];           //추천 시간

        total = Integer.parseInt(br.readLine());
        st = new StringTokenizer(br.readLine());

        for (int x = 0; x < total ; x++){

            now =  Integer.parseInt((st.nextToken()));      
            candidateIdx=0;

            for (int y = 0 ; y < pictureNum ; y++){
                //사진틀이 비었거나, 이미 게시된 경우
                if( student[y] == 0 | student[y] == now ) {
                    candidateIdx = y;
                    break;
                }
               //추천 횟수가 더 적거나, 추천횟수가 같고 시간이 더 빠른 경우
                if( recommend[candidateIdx] > recommend[y] || recommend[candidateIdx] == recommend[y] && time[candidateIdx] > time[y]) {
                    candidateIdx = y ;
                }
            }

            if(student [candidateIdx] != now){
                student[candidateIdx] = now;
                recommend[candidateIdx] = 0;
                time[candidateIdx] = x;
            }
                recommend[candidateIdx]++;
        }

        Arrays.sort(student);

        for (int x : student){
            if(x!=0){
                bw.write(String.valueOf(x)+"");
            }
        }
        bw.flush();
    }
}
