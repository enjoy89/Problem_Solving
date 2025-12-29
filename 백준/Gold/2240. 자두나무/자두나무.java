
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int T = Integer.parseInt(st.nextToken());
		int W = Integer.parseInt(st.nextToken());
		int[] event = new int[T + 1];
		for (int t = 1; t <= T; t++) {
			event[t] = Integer.parseInt(br.readLine());
		}

		// dp[나무][시간][이동]
		// 1부터 사용
		int[][][] dp = new int[3][T + 1][W + 2];

		for (int t = 1; t < T + 1; t++) {
			for (int w = 1; w < W + 2; w++) {
				// 1번 나무에서 떨어지는 경우
				if (event[t] == 1) {
					// 1번 그대로 유지 vs 2번에서 1번으로 위치 이동
					dp[1][t][w] = Math.max(dp[1][t - 1][w], dp[2][t - 1][w - 1]) + 1;
					dp[2][t][w] = Math.max(dp[2][t - 1][w], dp[1][t - 1][w - 1]);
				}
				// 2번 나무에서 떨어지는 경우
				else {
					if (t == 1 && w == 1) {
						continue;
					}

					// 2번 그대로 유지 vs 1번에서 2번으로 위치 이동
					dp[1][t][w] = Math.max(dp[1][t - 1][w], dp[2][t - 1][w - 1]);
					dp[2][t][w] = Math.max(dp[2][t - 1][w], dp[1][t - 1][w - 1]) + 1;

				}
			}
		}

		int answer = 0;
		for (int w = 1; w < W + 2; w++) {
			answer = Math.max(answer, Math.max(dp[1][T][w], dp[2][T][w]));
		}

		System.out.println(answer);
	}
}