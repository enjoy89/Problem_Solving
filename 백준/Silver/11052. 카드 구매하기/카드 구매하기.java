import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int[] cards = new int[N+1];

        StringTokenizer st = new StringTokenizer(br.readLine());
        for(int i=1; i<N+1; i++) {
            cards[i] = Integer.parseInt(st.nextToken());
        }

        // 카드 n개를 구매할 때의 최대가격
        // n개 보다 많은 개수를 산 다음에 나머지 카드를 버리는 경우는 불가능
        int[] dp = new int[N+1];
        dp[0] = 0;
        for(int n=1; n<N+1; n++) {
            // 이전의 최대값을 활용해라
            for(int i=1; i<=n; i++) {
                dp[n] = Math.max(dp[n-i] + cards[i], dp[n]);
            }
        }

        System.out.println(dp[N]);
    }
}
