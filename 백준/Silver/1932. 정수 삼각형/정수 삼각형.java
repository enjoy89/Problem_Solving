import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int[][] arr = new int[n][n];

        for(int i=0; i<n; i++) {
            String[] line = br.readLine().split(" ");
            for(int j=0; j< line.length; j++) {
                arr[i][j] = Integer.parseInt(line[j]);
            }
        }

        int[][] dp = new int[n][n];
        dp[0][0] = arr[0][0];

        for(int i=1; i<n; i++) {
            for(int j=0; j<n; j++) {
                if(j == 0) {
                    dp[i][j] = dp[i-1][j] + arr[i][j];
                } else {
                    dp[i][j] = Math.max(dp[i-1][j-1], dp[i-1][j]) + arr[i][j];
                }
            }
        }
        int answer = 0;
        for(int num: dp[n-1]) {
            answer = Math.max(answer, num);
        }

        System.out.println(answer);
    }


}
