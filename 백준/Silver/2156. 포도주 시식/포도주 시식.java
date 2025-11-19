import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int[] wine = new int[n];

        for(int i=0; i<n; i++) {
            wine[i] = Integer.parseInt(br.readLine());
        }

        int[][] dp = new int[3][n]; // i번째일때 연속으로 0개, 1개, 2개 먹었을 때의 최대합
        dp[0][0] = 0;
        dp[1][0] = wine[0];
        dp[2][0] = 0;

        for(int i=1; i<n; i++) {
            dp[0][i] = Math.max(dp[0][i-1], Math.max(dp[1][i-1], dp[2][i-1]));
            dp[1][i] = dp[0][i-1] + wine[i];
            dp[2][i] = dp[1][i-1] + wine[i];
        }

        int answer = Math.max(dp[0][n-1], Math.max(dp[1][n-1],dp[2][n-1]));
        System.out.println(answer);
    }
}
