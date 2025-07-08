import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken()); // 강의의 수
        int M = Integer.parseInt(st.nextToken()); // 블루레이 개수
        st = new StringTokenizer(br.readLine());
        int[] arr = new int[N];
        int max = 0;
        for(int i=0; i<N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
            if(arr[i] > max) max = arr[i];
        }

        long left = max; // 강의 길이의 최댓값
        long right = Arrays.stream(arr).sum(); // 모든 강의 길이의 합
        long answer = 0;
        while(left <= right) {
            long mid = (left + right) / 2;
            long count = 1; // 개수는 1부터 시작
            long sum = 0;
            for(int i=0; i<N; i++) {
                long tmp = sum + arr[i];
                if(tmp > mid) {
                    count++;
                    sum = arr[i];
                } else {
                    sum += arr[i];
                }
            }
            // 블루레이 개수가 M보다 작거나 같으면 조건 만족
            // 길이를 줄여서 재탐색
            if(count <= M) {
                answer = mid;
                right =  mid - 1;
            } else {
                // 조건 불만족
                // 길이를 늘려서 재탐색
                left = mid + 1;
            }
        }
        System.out.println(answer);
    }
}
