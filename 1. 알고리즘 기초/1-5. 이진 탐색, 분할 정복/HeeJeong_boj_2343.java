import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        int[] lessonList = new int[n];

        int left = 0;
        int right = 0;

        for (int i = 0; i < n; i++) {
            lessonList[i] = Integer.parseInt(st.nextToken());
            right += lessonList[i];
            left = Math.max(left, lessonList[i]);
        }

        while (left <= right) {
            int mid = (left + right) / 2;

            int count = getCount(n, lessonList, mid);

            if(count > m){
                left = mid + 1;
            }else{
                right = mid - 1;
            }
        }

        System.out.println(left);
    }

    private static int getCount(int n, int[] lessonList, int mid) {
        int sum = 0;
        int count = 0;

        for (int i = 0; i < n; i++) {
            if (sum + lessonList[i] > mid) {
                sum = 0;
                count++;
            }
            sum += lessonList[i];
        }

        if(sum != 0) count++;
        return count;
    }
}


