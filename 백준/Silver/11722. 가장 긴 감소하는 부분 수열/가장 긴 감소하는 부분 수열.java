import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int[] nums = new int[N];

        StringTokenizer st = new StringTokenizer(br.readLine());
        for(int i=0; i<N; i++){
            nums[i] = Integer.parseInt(st.nextToken());
        }

        int[] dp = new int[N]; // i번째에서 끝나는 최장 감소 부분 수열
        Arrays.fill(dp, 1);

        for(int i=0; i<N; i++){
            int max = 0;
            for(int j=0; j<i; j++) {
                if(nums[i] < nums[j]) {
                    max = Math.max(max, dp[j]);
                }
            }
            dp[i] = max+1;
        }

        int answer = 0;
        for(int i=0; i<N; i++){
            answer = Math.max(answer, dp[i]);
        }
        System.out.println(answer);
    }
}
