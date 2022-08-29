import java.util.Arrays;
import java.util.Scanner;

public class CandidateRecommend {
    public static void main(String[] args) {
        //입력 1: 사진틀의 갯수
        //입력 2: 총 추천횟수
        //입렫 3: 추천받은 학생들의 번호 (추천받은 순서대로 주어짐)
        //출력 : 사진틀에 게시된 학생번호를 오름차순으로 출력
        Scanner sc = new Scanner(System.in);
        int picNum = sc.nextInt(); //사진 틀의 갯수
        int tot_recommend = sc.nextInt(); //총 추천횟 수
        int[] order =new int[picNum]; // 게시된 순서 (작을수록 오래됨)
        int[] picture = new int[picNum]; // 사진 틀
        int[] recommend = new int[picNum]; //추천 수 카운트
        int tmp;
        int index;
        for (int i=0; i<tot_recommend; i++){
            tmp = sc.nextInt();
            index =0;
            for (int j=0; j<picNum; j++){
                //사진틀이 비어있거나 이미 게시된 경우
                if(picture[j]==0 || picture[j]==tmp){
                    index = j;
                    break;
                }
                //사진틀이 비어있지않을때
                //추천횟수가 적거나, 추천횟수가 같으면 게시된지 오래된 사진 삭제
                if(recommend[index]>recommend[j] ||( recommend[index] == recommend[j] && order[index]>order[j])){
                    index =j; //현재 인덱스가 사진 틀의 인덱스
                }
            }
            if(picture[index]!=tmp){
                picture[index]=tmp;
                recommend[index] =i;
                order[index]=i;
            }
            recommend[index]++;
        }

        Arrays.sort(picture);


        for (int j = 0; j < picture.length; j++) {
            //사진틀이 비어있을수도 있으니까
            if(picture[j]!=0) System.out.print(picture[j]+" ");
        }
    }

}
