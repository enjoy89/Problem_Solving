import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());
        Integer[] coins = new Integer[N];
        for (int i = 0; i < N; i++) {
            coins[i] = Integer.parseInt(br.readLine());
        }
        Arrays.sort(coins, Collections.reverseOrder());

        int count = 0;
        for (int coin : coins) {
            if(K == 0) {
                break;
            }
            if (coin <= K) {
                count += K / coin;
                K %= coin;
            }
        }
        System.out.println(count);
    }
}
