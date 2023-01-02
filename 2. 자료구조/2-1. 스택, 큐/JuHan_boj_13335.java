package WEEK15.P13335;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
    static int N, W, L;
    static Queue<truck> bridge;
    static Queue<truck> trucks;
    static int ans, sum;

    public static void main(String[] args) throws IOException {
        System.setIn(new FileInputStream("src/WEEK15/P13335/input.txt"));

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        W = Integer.parseInt(st.nextToken());
        L = Integer.parseInt(st.nextToken());
        trucks = new LinkedList<>();
        bridge = new LinkedList<>();

        st = new StringTokenizer(br.readLine());
        for(int i = 0; i < N; i++){
            trucks.add(new truck(Integer.parseInt(st.nextToken()), 0));
        }

        sum = 0;    // 큐에 들어가있는 트럭들의 무게 합
        ans = 0;

        while(!trucks.isEmpty()){
            truck tmpFront = trucks.peek();

            if(sum + tmpFront.weight <= L){
                truck front = trucks.poll();
                bridge.add(front);
                sum += front.weight;
            }

            moveOnBridge(bridge);
        }

        // 모든 트럭이 다 건너기 시작했고, 다리 위에 남은 트럭이 있을 때 쓸어담기
        while(!bridge.isEmpty()){
            moveOnBridge(bridge);
        }
        
        ans++;      // 마지막 트럭이 이동하는 것 카운팅 + 1
        System.out.println(ans);
    }

    static void moveOnBridge(Queue<truck> bridge){
        Iterator<truck> it = bridge.iterator();
        while(it.hasNext()){
            truck tmp = it.next();
            tmp.status++;
//            System.out.println(tmp.weight + ", " + tmp.status);
        }
//        System.out.println();

        if(bridge.peek().status >= W){
            truck front = bridge.poll();
            sum -= front.weight;
        }

        ans++;
    }
}

class truck{
    int weight;
    // status :  0이면 건너기 전, 1이면 건너는 중, 2이면 건넌 후
    int status;

    public truck(int weight, int status) {
        this.weight = weight;
        this.status = status;
    }
}
