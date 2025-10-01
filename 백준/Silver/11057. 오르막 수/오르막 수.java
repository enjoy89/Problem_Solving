import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int[][] dp = new int[N+1][10];

        // 초기값
        for(int i=0; i<10; i++) {
            dp[1][i] = 1;
        }

        for(int i=2; i<N+1; i++) {
            int sum = 0;
            for(int j=0; j<10; j++) {
                sum += dp[i-1][j];
                dp[i][j] = sum % 10007;
            }
        }
        int answer = 0;
        for(int i=0; i<10; i++) {
            answer = (answer + dp[N][i]) % 10007;
        }
        System.out.println(answer);
    }
}
