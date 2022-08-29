import java.util.Scanner;

public class MakePalindrome {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String str = sc.next();

        String answer = "";
        StringBuilder st = new StringBuilder();

        int[] alpha = new int[26];
        int odd =0;
        for (int i=0; i<str.length(); i++){
            alpha[str.charAt(i)-65]++;
        }

        for (int i=0; i< alpha.length; i++){
            if(alpha[i]%2==1) odd++;
        }

        if ((str.length()%2==1 && odd!=1) || str.length()%2==0 && odd>0){
            System.out.println("I'm Sorry Hansoo");
        } else {

            for (int i = 0; i < 26; i++) {
                for (int j = 0; j < alpha[i] / 2; j++) {
                    answer+=(char) +(i + 65);
                }
            }

            String tmp=new StringBuilder(answer).reverse().toString();

           
            for (int i = 0; i < alpha.length; i++) {
                if (alpha[i] % 2 == 1) {
                    answer+=(char)(i+65);

                }
            }
            System.out.println(answer+tmp);


        }

    }

}
