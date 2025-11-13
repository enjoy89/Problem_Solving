import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int MOD = 10007;

        int[][] dp = new int[N+1][10]; // 길이가 N이고 끝자리가 0~9인 오르막 수

        // 초기값
        for(int i=0; i<10; i++) {
            dp[1][i] = 1; // 0~9, 길이가 1인 오르막 수는 각각 1개이다.
        }

        for (int n = 2; n <= N; n++) {
            for (int i = 0; i < 10; i++) {
                // 끝자리가 0인 오르막 수는 1개로 고정
                if (i == 0) {
                    dp[n][i] = 1;
                }
                else {
                    for (int j = 0; j <= i; j++) {
                        dp[n][i] += dp[n - 1][j];
                    }
                    dp[n][i] = dp[n][i] % MOD;
                }
            }
        }

        int answer = 0;
        for(int i=0; i<10; i++) {
            answer = (answer + dp[N][i]) % MOD;
        }
        System.out.println(answer);
    }
}
