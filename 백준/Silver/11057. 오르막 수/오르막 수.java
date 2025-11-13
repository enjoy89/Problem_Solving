import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        int[][] dp = new int[N+1][10]; // 길이가 N이고 끝자리가 0~9인 오르막 수
        for(int i=0; i<10; i++) {
            dp[1][i] = 1;
        }

        for(int n=2; n<=N; n++) {
            for(int i=0; i<10; i++) {
                if(i == 0) {
                    dp[n][i] = 1;
                }
                else {
                    int sum = 0;
                    for (int j = 0; j <= i; j++) {
                        sum += dp[n - 1][j];
                    }
                    dp[n][i] = sum % 10007;
                }

            }
        }

        int answer = 0;
        for(int i=0; i<10; i++) {
            answer = (answer + dp[N][i]) % 10007;
        }
        System.out.println(answer);
    }
}
