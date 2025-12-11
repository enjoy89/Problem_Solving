import java.io.*;
import java.util.*;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		int[] T = new int[N + 2];
		int[] P = new int[N + 2];
		StringTokenizer st;
		for (int i = 1; i <= N; i++) {
			st = new StringTokenizer(br.readLine());
			T[i] = Integer.parseInt(st.nextToken());
			P[i] = Integer.parseInt(st.nextToken());
		}

		int[] dp = new int[N + 2];
		for(int day = N; day > 0; day--) {
			dp[day] = dp[day + 1];

			if(day + T[day] <= N +1) {
				dp[day] = Math.max(dp[day], P[day] + dp[day + T[day]]);
			}
		}

		System.out.println(dp[1]);
	}
}
