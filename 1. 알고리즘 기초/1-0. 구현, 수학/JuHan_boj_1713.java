//package DAY02.P1713;

import java.io.*;
import java.util.*;

public class Main {
    static int N, M;
    static ArrayList<picture> array = new ArrayList<>();

    public static void main(String[] args) throws IOException {
       // System.setIn(new FileInputStream("src/DAY02/P1713/input.txt"));

        BufferedReader br = br = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(br.readLine());
        M = Integer.parseInt(br.readLine());

        picture tmp;

        StringTokenizer st = new StringTokenizer(br.readLine());

        while(st.hasMoreTokens()){
            int inputNum = Integer.parseInt(st.nextToken());

            if(array.size() == N){
                int flag = 0;
                int idx = 0;

                //중복 검사
                for(int i = 0 ; i < N; i++){
                    if(array.get(i).num == inputNum) {
                        flag = 1;
                        idx = i;
                        break;
                    }
                }
                if (flag == 1) {
                    //꽉 찼는데 중복이 있을 때
                    array.get(idx).like++;
                }else{
                    //꽉 찼는데 중복이 없을 때 -> 삭제하고 넣어야 돼
                    int min = (int)1e9;
                    int minIdx = 0;

                    //삭제할 애 찾기 -> minIdx 찾기
                    for(int j = N - 1; j >= 0; j--){
                        if(array.get(j).like <= min){
                            min = array.get(j).like;
                            minIdx = j;
                        }
                    }

                    //삭제하고 끼워넣기
                    array.remove(minIdx);
                    array.add(new picture(inputNum, 1));
                }
            }else{
                //사진틀이 꽉 안 찼을때
                int flag = 0;
                int idx = 0;

                if(array.size() == 0){
                    array.add(new picture(inputNum, 1));
                }else{
                    //중복 검사
                    for(int i = 0 ; i < array.size(); i++) {
                        if(array.get(i).num == inputNum){
                            flag = 1;
                            idx = i;
                            break;
                        }
                    }

                    if(flag == 1){
                        array.get(idx).like++;
                    } else{
                        array.add(new picture(inputNum, 1));
                    }
                }
            }
        }

        Collections.sort(array);
        for(int i = 0; i < array.size(); i++){
            System.out.println(array.get(i).num);
        }
    }
}

class picture implements Comparable<picture>{
    int num = 0;
    int like = 0;

    public picture(int num, int like) {
        this.num = num;
        this.like = like;
    }

    @Override
    public int compareTo(picture o) {
        return num - o.num;
    }
}
