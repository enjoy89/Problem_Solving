import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int[] arr = new int[n];

        StringTokenizer st = new StringTokenizer(br.readLine());
        for(int i=0; i<n; i++){
            arr[i] = Integer.parseInt(st.nextToken());
        }

        int[] dp = new int[n];
        dp[0] = arr[0];
        for(int i=1; i<n; i++) {
            dp[i] = Math.max(arr[i], arr[i] + dp[i-1]);
        }

        int answer = dp[0];
        for(int num : dp) {
            answer = Math.max(answer, num);
        }
        System.out.println(answer);
    }
}
