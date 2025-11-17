import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        long[][] dp = new long[91][2]; // 자릿수가 n개이고 끝자리가 0,1인 배열
                
        dp[1][1] = 1;
        dp[2][0] = 1;
        
        for(int i=3; i<=N; i++) {
            // 앞자리가 1이면 0만 가능
            // 앞자리가 1이면 0또는 1 가능
            dp[i][1] = dp[i-1][0];
            dp[i][0] = dp[i-1][1] + dp[i-1][0];
        }
        long answer = dp[N][1] + dp[N][0];      
        System.out.println(answer);     
              
        
    }
}