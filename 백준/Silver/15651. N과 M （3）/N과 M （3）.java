import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

	static int N, M;
	static int[] selected;
	static StringBuilder sb;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());

		selected = new int[N + 1];
		sb = new StringBuilder();
		dfs(0);
		System.out.println(sb);
	}

	public static void dfs(int n) {
		if (n == M) {
			for (int i = 0; i < M; i++) {
				sb.append(selected[i]).append(" ");
			}
			sb.append("\n");
			return;
		}

		for (int i = 1; i < N + 1; i++) {
			selected[n] = i;
			dfs(n + 1);
		}
	}
}
