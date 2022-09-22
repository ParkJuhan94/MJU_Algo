import java.util.Scanner;

public class boj19947 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int H = sc.nextInt(); //원금
        int Y = sc.nextInt(); //투자기간
        int[] money = new int[Y + 1];
        int max= 0;
        money[0] = H;

        for (int i=1; i<=Y; i++){
            money[i] = (int)(money[i-1]*1.05);

            if(i>=3) money[i] = Math.max(money[i],(int)(money[i-3]*1.2));
            if(i>=5) money[i] = Math.max(money[i],(int)(money[i-5]*1.35));
        }
        System.out.println(money[Y]);
    }


}
