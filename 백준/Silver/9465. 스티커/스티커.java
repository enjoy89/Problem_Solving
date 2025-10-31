import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());

        for(int t = 0; t < T; t++) {
            int n = Integer.parseInt(br.readLine());
            int[][] score = new int[2][n+1];

            for (int i = 0; i < 2; i++) {
                StringTokenizer st = new StringTokenizer(br.readLine());
                for (int j = 1; j <= n; j++) {
                    score[i][j] = Integer.parseInt(st.nextToken());
                }
            }

            // 위쪽 스티커를 고르는 경우, 아래쪽 스티커를 고르는 경우 각각 계산
            int[][] dp = new int[2][n+1];
            dp[0][1] = score[0][1];
            dp[1][1] = score[1][1];

            for(int i=2; i<n+1; i++) {
                dp[0][i] = Math.max(dp[1][i-1], dp[1][i-2]) + score[0][i];
                dp[1][i] = Math.max(dp[0][i-1], dp[0][i-2]) + score[1][i];
            }
            int answer = Math.max(dp[0][n], dp[1][n]);
            System.out.println(answer);
        }
    }
}
