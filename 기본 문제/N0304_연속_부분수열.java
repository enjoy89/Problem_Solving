import java.io.*;
import java.util.*;

/**
 * 2024-02-18
 * 연속 부분 수열의 합이 M이 되는 경우가 몇 번인지 구하라.
 * 투 포인터 알고리즘 사용
 */
public class N0304_연속_부분수열 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        int[] arr = new int[N];

        st = new StringTokenizer(br.readLine());
        for(int i=0; i<N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        // 왼쪽 포인터와 오른쪽 포인터를 각각 두고,
        // 수열 합이 M보다 작으면 rt++
        // 수열 합이 M보다 크거나 같으면 lt++
        int count = 0;
        int lt = 0, rt = 0;
        while(rt < N) {
            int sum = 0;

            for(int i=lt; i<=rt; i++) {
                sum += arr[i];
            }

            if(sum == M) {
                count++;
                lt++;
            } else if(sum > M) {
                lt++;
            } else {
                rt++;
            }
        }

        System.out.println(count);
    }
}
