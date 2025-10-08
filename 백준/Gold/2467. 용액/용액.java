import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        long[] arr = new long[n];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            arr[i] = Long.parseLong(st.nextToken());
        }
        Arrays.sort(arr);

        int left = 0;
        int right = n-1;
        long min = Long.MAX_VALUE;
        long answer1 = 0, answer2 = 0;

        while(left < right) {
            long sum = arr[left] + arr[right];
            long absSum = Math.abs(sum);
            if(absSum < min) {
                min = absSum;
                answer1 = arr[left];
                answer2 = arr[right];
            }

            if(sum > 0) {
                right--;
            } else {
                left++;
            }
        }
        System.out.println(answer1 + " " + answer2);
    }
}
