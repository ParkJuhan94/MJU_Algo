package WEEK14.P1644;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class Main {
    static int[] check;
    static int[] primeNum;
    static ArrayList<Integer> Prime;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        check = new int[N + 1];
        primeNum = new int[N + 1];
        findPrime(N);
        System.out.println(PrimeSum(N));
    }

    public static void findPrime(int N) {
        int k = 0;
        for (int i = 2; i <= N; i++) {
            if (check[i] == 0) {
                check[i] = 1;
                primeNum[k] = i;

                for (int j = i; j <= N; j = j + i) {
                    check[j] = 1;
                }
                k++;
            }
        }
    }

    public static int PrimeSum(int N) {
        int count = 0;
        int sum = 0;
        int start = 0;
        int end = 0;

        while (true) {
            if(end >= primeNum.length){
                break;
            }
            if (sum == N) {
                count++;
                sum -= primeNum[start++];
            } else if (sum < N) {
                sum += primeNum[end++];
            } else {
                sum -= primeNum[start++];
            }
        }

        return count;
    }
}



