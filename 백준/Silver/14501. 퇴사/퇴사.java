import java.io.*;
import java.util.*;

public class Main {
	static int N;
	static int[] T;
	static int[] P;
	static int answer = 0;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		T = new int[N];
		P = new int[N];

		for (int i = 0; i < N; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			T[i] = Integer.parseInt(st.nextToken());
			P[i] = Integer.parseInt(st.nextToken());
		}

		dfs(0, 0);
		System.out.println(answer);

	}

    public static void dfs(int day, int sum) {
		if (day >= N) {
			answer = Math.max(answer, sum);
			return;
		}

		if (day + T[day] <= N) {
			dfs(day + T[day], sum + P[day]);
		}
		dfs(day + 1, sum);

	}
}
