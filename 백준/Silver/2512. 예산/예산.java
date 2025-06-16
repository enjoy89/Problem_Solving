import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine()); // 지방의 수
        StringTokenizer st = new StringTokenizer(br.readLine());
        int[] items = new int[N];
        for(int i=0; i<N; i++) {
            items[i] = Integer.parseInt(st.nextToken());
        }
        int M = Integer.parseInt(br.readLine());

        long left = 0;
        long right = Arrays.stream(items).max().getAsInt(); // 예산의 최댓값
        long answer = 0;
        while(left <= right) {
            long mid = (left + right) / 2;
            long sum = 0;
            for(int i=0; i<N; i++) {
                if(mid >= items[i]) {
                    sum += items[i];
                } else {
                    sum += mid;
                }
            }
            if(sum <= M) {
                answer = mid;
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        System.out.println(answer);
    }
}
