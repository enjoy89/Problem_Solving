import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        st = new StringTokenizer(br.readLine());
        int[] arr = new int[N];
        int max = 0;
        for(int i=0; i<N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
            if(arr[i] > max) max = arr[i];
        }

        long left = max; // 강의 길이의 최대값
        long right = Arrays.stream(arr).sum(); // 강의 길이의 총합
        long answer = 0;
        while(left <= right) {
            long mid = (left + right) / 2;
            long sum = 0;
            int cnt = 1;
            for(int i=0; i<N; i++) {
                long tmp = sum + arr[i];
                if(tmp > mid) {
                    cnt++;
                    sum = arr[i]; // 새로운 길이로 시작
                } else {
                    sum += arr[i];
                }
            }

            if(cnt <= M) {
                answer = mid;
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }
        System.out.println(answer);

    }
}
