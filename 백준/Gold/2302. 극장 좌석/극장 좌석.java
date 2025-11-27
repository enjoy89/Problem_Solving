import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int[] dp = new int[N+1];
        int M = Integer.parseInt(br.readLine());
        int[] fixed_seat = new int[M+1];

        for(int i=1; i<M+1; i++) {
            fixed_seat[i] = Integer.parseInt(br.readLine());
        }

        if(N == 1) {
            System.out.println(1);
            return;
        }

        dp[1] = 1;
        dp[2] = 2;
        for(int i=3; i<N+1; i++) {
            dp[i] = dp[i-1] + dp[i-2];
        }

        int answer = 1;
        int cur_idx = 1;
        for (int i=1; i<M+1; i++) {
            int n = fixed_seat[i] - cur_idx;
            // 범위 체크
            if(n>=1 && n<N+1) {
                answer *= dp[n];
            }
            cur_idx = fixed_seat[i] + 1;
        }

        if(cur_idx < N+1) {
            answer *= dp[N - cur_idx + 1];
        }
        System.out.println(answer);
    }
}
