import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int K = Integer.parseInt(st.nextToken()); // 가지고 있는 랜선의 개수
        int N = Integer.parseInt(st.nextToken()); // 필요한 랜선의 개수
        int[] arr = new int[K];
        for (int i = 0; i < K; i++) {
            arr[i] = Integer.parseInt(br.readLine());
        }

        long left = 1;
        long right = Arrays.stream(arr).max().getAsInt(); // 랜선의 최대값
        long answer = 0;
        while (left <= right) {
            long mid = (left + right) / 2;
            long count = 0;
            for (int i = 0; i < K; i++) {
                count += arr[i] / mid;
            }
        
            if (count >= N) {
                answer = mid;
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        System.out.println(answer);
    }
}
