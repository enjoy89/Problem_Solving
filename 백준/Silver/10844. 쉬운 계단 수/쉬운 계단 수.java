import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        long[][] dp = new long[N+1][10]; // 길이가 N이고 마지막 끝자리 숫자가 0~10인 계단 수의 개수
        long MOD = 1000000000;

        // 길이가 1인 숫자들 초기화 (1,2,3,4,5,6,7,8,9)
        for(int i=1; i<=9; i++) {
            dp[1][i] = 1;
        }

        for(int i=2; i<=N; i++) {
            for(int j=0; j<10; j++) {
                if(j == 0) {
                    dp[i][j] = dp[i-1][j+1];
                } else if(j == 9) {
                    dp[i][j] = dp[i-1][j-1];
                } else {
                    dp[i][j] = dp[i-1][j-1] + dp[i-1][j+1];
                }
                dp[i][j] = dp[i][j] % MOD;
            }
        }

        long answer = 0;
        for(int i=0; i<10; i++) {
            answer += dp[N][i];
        }
        System.out.println(answer % MOD);
    }
}
