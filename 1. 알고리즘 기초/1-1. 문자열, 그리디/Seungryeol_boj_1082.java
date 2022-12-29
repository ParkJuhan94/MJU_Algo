import java.util.Arrays;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

class number{
    int num, price;
    number(int num, int price) {
        this.num = num; this.price = price;
    }
}

public class boj1082 {
    private static int N, pocket;
    private static int res[] = new int[100];
    private static number arr[];
    private static Map<Integer, Integer> m = new HashMap<>(); // 숫자-비용 따로 저장해두려고

    public static void main(String[ ] args) {
        Scanner sc = new Scanner(System.in);
        N = sc.nextInt(); // 0~N-1까지 방번호
        arr = new number[N];
        for(int i = 0; i < N; i++) {
            arr[i] = new number(i, sc.nextInt());
            m.put(i, arr[i].price);
        }
        pocket = sc.nextInt(); //비용

        Arrays.sort(arr, new Comparator<number>() { // 가격 기준 오름차순 정렬
            @Override
            public int compare(number o1, number o2) {
                if(o1.price == o2.price) return o1.num - o2.num; //같으면 번호가 작은순
                return o1.price - o2.price;
            }

        });

        int cnt = 0;
        if(arr[0].num == 0) { // 숫자 0이 가장 작은 수라서 맨 앞에 올 수 없기 때문에
            if(N == 1 || arr[1].price > pocket) { // 0대신 넣을 그 다음 숫자의 비용을 감당할 수 없다면
                System.out.println(0); // 숫자 0으로밖에 할 수 없을 때 답은 0
                System.exit(0);
            }
            res[cnt++] = arr[1].num; // 그 다음 숫자의 비용을 감당할 수 있으면 이 숫자로 맨 앞자리 채운다
            pocket -= arr[1].price;
        }

        while(pocket - arr[0].price >= 0) { // 가장 비용이 작은 숫자로 최대한 많이 채움
            res[cnt++] = arr[0].num;
            pocket -= arr[0].price;
        }

        for(int i = 0; i < cnt; i++) {
            for(int j = N - 1; j >= 0; j--) { // 가장 큰 수부터
                if(i == 0 && j == 0) continue; // 맨 앞자리에 0이 들어가면 안 됨
                int tmp = pocket + m.get(res[i]) - m.get(j); //전으로 돌리고 대체할 방 가격을 다시뺀게 0보다 크면 대체 가능
                if(tmp >= 0) { // 가격 범위 안 넘어서 현재 숫자로 바꿀 수 있으면 바꿈(최대한 큰 수이므로)
                    pocket = tmp; // 허용 가능한 비용 갱신
                    res[i] = j; //대체 숫자로 바꿈
                    break;
                }
            }
        }

        for(int i = 0; i < cnt; i++) System.out.print(res[i]);
    }
}
